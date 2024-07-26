package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime148msBeats5.23%
 */
public class Q1334FindTheCityWithTheSmallestNumberOfNeighborsAtAThresholdDistance {

    @Test
    public void test() {
        assertThat(findTheCity(4, Ps.intArray("[[0,1,3],[1,2,1],[1,3,4],[2,3,1]]"), 4))
                .isEqualTo(3);
        assertThat(findTheCity(5, Ps.intArray("[[0,1,2],[0,4,8],[1,2,3],[1,4,2],[2,3,1],[3,4,1]]"), 2))
                .isEqualTo(0);
    }

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        City[] cities = new City[n];
        for (int i = 0; i < n; i++) {
            cities[i] = new City(i);
        }
        for (int[] edge : edges) {
            City city1 = cities[edge[0]];
            City city2 = cities[edge[1]];
            city1.addNext(city2, edge[2]);
        }
        int index = -1;
        int minCity = Integer.MAX_VALUE;
        for (City city : cities) {
            int cnt = city.findPossible(distanceThreshold);
            if (cnt <= minCity) {
                minCity = cnt;
                index = city.index;
            }
        }
        return index;
    }

    static class City {
        final int index;
        Map<City, Integer> next = new HashMap<>();

        City(int index) {
            this.index = index;
        }

        public void addNext(City city, int distance) {
            this.next.put(city, distance);
            city.next.put(this, distance);
        }

        public int findPossible(int limit) {
            PriorityQueue<CityAndDistance> pq = new PriorityQueue<>(Comparator.comparingInt(c -> c.distance));
            Map<City, Integer> distances = new HashMap<>();

            pq.offer(new CityAndDistance(this, 0));
            distances.put(this, 0);

            while (!pq.isEmpty()) {
                CityAndDistance poll = pq.poll();
                City city = poll.city;
                int currentDist = poll.distance;

                for (Map.Entry<City, Integer> e : city.next.entrySet()) {
                    City neighbor = e.getKey();
                    int newDist = currentDist + e.getValue();
                    if (newDist < distances.getOrDefault(neighbor, Integer.MAX_VALUE)) {
                        distances.put(neighbor, newDist);
                        pq.offer(new CityAndDistance(neighbor, newDist));
                    }
                }
            }

            int count = -1;
            for (int dist : distances.values()) {
                if (dist <= limit) {
                    count++;
                }
            }
            return count;
        }
    }

    static class CityAndDistance {
        City city;
        int distance;

        public CityAndDistance(City city, int distance) {
            this.city = city;
            this.distance = distance;
        }
    }

}
