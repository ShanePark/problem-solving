package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 142 ms Beats 23.40%
 * Memory 88.1 MB Beats 95.83%
 */
public class Q2477MinimumFuelCostToReportToTheCapital {

    @Test
    void test() {
        assertThat(minimumFuelCost(STool.convertToIntArray("[[0,1],[0,2],[0,3]]"), 5)).isEqualTo(3);
        assertThat(minimumFuelCost(STool.convertToIntArray("[[3,1],[3,2],[1,0],[0,4],[0,5],[4,6]]"), 2)).isEqualTo(7);
        assertThat(minimumFuelCost(STool.convertToIntArray("[]"), 1)).isEqualTo(0);
    }

    public long minimumFuelCost(int[][] roads, int seats) {
        if (roads.length == 0)
            return 0;
        Map<Integer, City> map = new HashMap<>();
        for (int[] road : roads) {
            City city1 = map.compute(road[0], (index, city) -> city == null ? new City(index) : city);
            City city2 = map.compute(road[1], (index, city) -> city == null ? new City(index) : city);
            city1.addNext(city2);
            city2.addNext(city1);
        }
        City capital = map.get(0);
        long answer = 0;
        for (City next : capital.connections) {
            long[] result = dfs(next, capital, seats);
            answer += result[0];
        }
        return answer;
    }

    private long[] dfs(City city, City before, int seats) {
        long fuel = 0;
        long people = 1;
        for (City next : city.connections) {
            if (next == before) continue;
            long[] result = dfs(next, city, seats);
            fuel += result[0];
            people += result[1];
        }
        fuel += (seats + people - 1) / seats;
        return new long[]{fuel, people};
    }

    class City {
        int index;
        List<City> connections = new ArrayList<>();

        public City(int index) {
            this.index = index;
        }

        public void addNext(City city) {
            connections.add(city);
        }

        @Override
        public String toString() {
            return "City{" +
                    "index=" + index +
                    ", connections=" + connections.stream().map(c -> c.index).collect(Collectors.toList()) +
                    '}';
        }
    }

}
