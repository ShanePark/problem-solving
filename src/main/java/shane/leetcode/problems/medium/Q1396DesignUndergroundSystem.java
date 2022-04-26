package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1396DesignUndergroundSystem {

    @Test
    public void test() {
        UndergroundSystem u = new UndergroundSystem();
        u.checkIn(45, "Leyton", 3);
        u.checkIn(32, "Paradise", 8);
        u.checkIn(27, "Leyton", 10);
        u.checkOut(45, "Waterloo", 15);
        u.checkOut(27, "Waterloo", 20);
        u.checkOut(32, "Cambridge", 22);
        assertThat(u.getAverageTime("Paradise", "Cambridge")).isEqualTo(14.0);
        assertThat(u.getAverageTime("Leyton", "Waterloo")).isEqualTo(11.0);
        u.checkIn(10, "Leyton", 24);
        assertThat(u.getAverageTime("Leyton", "Waterloo")).isEqualTo(11.0);
        u.checkOut(10, "Waterloo", 38);
        assertThat(u.getAverageTime("Leyton", "Waterloo")).isEqualTo(12.0);
    }

    class UndergroundSystem {

        Map<Integer, Passenger> passengerMap = new HashMap<>();
        Map<StationInfo, Statistics> data = new HashMap<>();

        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            passengerMap.put(id, new Passenger(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            Passenger passenger = passengerMap.get(id);
            StationInfo stationInfo = new StationInfo(passenger.from, stationName);
            data.merge(stationInfo, new Statistics(1, t - passenger.time), (o, n) -> new Statistics(o.totalNum + n.totalNum, o.totalTime + n.totalTime));
        }

        public double getAverageTime(String startStation, String endStation) {
            Statistics statistics = data.get(new StationInfo(startStation, endStation));
            return (double) statistics.totalTime / statistics.totalNum;
        }

    }

    class StationInfo {
        String from;
        String to;

        public StationInfo(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            StationInfo that = (StationInfo) o;
            return from.equals(that.from) && to.equals(that.to);
        }

        @Override
        public int hashCode() {
            return Objects.hash(from, to);
        }
    }

    class Statistics {
        int totalNum;
        long totalTime;

        public Statistics(int totalNum, long totalTime) {
            this.totalNum = totalNum;
            this.totalTime = totalTime;
        }
    }

    class Passenger {
        String from;
        int time;

        public Passenger(String from, int time) {
            this.from = from;
            this.time = time;
        }
    }

}
