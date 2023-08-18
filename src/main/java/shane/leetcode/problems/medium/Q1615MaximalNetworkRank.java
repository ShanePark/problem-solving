package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 23ms Beats 48.07%of users with Java
 * Memory Details 44.24mb Beats 46.73%of users with Java
 */
public class Q1615MaximalNetworkRank {

    @Test
    public void test() {
        assertThat(maximalNetworkRank(4, Ps.intArray("[[0,1],[0,3],[1,2],[1,3]]"))).isEqualTo(4);
        assertThat(maximalNetworkRank(5, Ps.intArray("[[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]"))).isEqualTo(5);
        assertThat(maximalNetworkRank(8, Ps.intArray("[[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]"))).isEqualTo(5);
    }

    public int maximalNetworkRank(int n, int[][] roads) {
        Map<Integer, City> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new City(i));
        }
        for (int[] road : roads) {
            City city1 = map.get(road[0]);
            City city2 = map.get(road[1]);
            city1.addRoad(city2);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                City city1 = map.get(i);
                City city2 = map.get(j);
                int rank = city1.roads.size() + city2.roads.size();
                if (city1.roads.contains(city2)) {
                    rank--;
                }
                max = Math.max(max, rank);
            }
        }
        return max;
    }

    class City {
        final int index;
        Set<City> roads = new HashSet<>();

        City(int index) {
            this.index = index;
        }

        public void addRoad(City city2) {
            roads.add(city2);
            city2.roads.add(this);
        }
    }

}
