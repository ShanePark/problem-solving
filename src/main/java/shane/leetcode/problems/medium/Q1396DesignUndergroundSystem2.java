package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 98 ms Beats 88.31%
 * Memory 54.1 MB Beats 96.66%
 */
public class Q1396DesignUndergroundSystem2 {

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

        Map<String, Statistics> map = new HashMap<>();
        Map<Integer, CheckIn> checkInMap = new HashMap<>();

        public UndergroundSystem() {

        }

        public void checkIn(int id, String stationName, int t) {
            checkInMap.put(id, new CheckIn(stationName, t));
        }

        public void checkOut(int id, String stationName, int t) {
            CheckIn checkIn = checkInMap.remove(id);
            String key = checkIn.stationName + " " + stationName;
            if (!map.containsKey(key)) {
                map.put(key, new Statistics());
            }
            Statistics statistics = map.get(key);
            statistics.checkOut(t - checkIn.time);
        }

        public double getAverageTime(String startStation, String endStation) {
            String key = startStation + " " + endStation;
            Statistics statistics = map.get(key);
            return statistics.getAverage();
        }
    }

    class Statistics {
        int cnt = 0;
        int totalTime = 0;

        public void checkOut(int time) {
            this.cnt++;
            this.totalTime += time;
        }

        public double getAverage() {
            return (double) totalTime / cnt;
        }
    }

    class CheckIn {
        String stationName;
        int time;

        public CheckIn(String stationName, int time) {
            this.stationName = stationName;
            this.time = time;
        }
    }

}
