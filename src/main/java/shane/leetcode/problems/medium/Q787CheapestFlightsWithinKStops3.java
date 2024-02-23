package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import static java.io.File.separator;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 30 ms Beats 6.52% of users with Java
 */
public class Q787CheapestFlightsWithinKStops3 {

    @Test
    public void test() {
        assertThat(findCheapestPrice(4, Ps.intArray("[[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]]"),
                0, 3, 1)).isEqualTo(700);
        assertThat(findCheapestPrice(3, Ps.intArray("[[0,1,100],[1,2,100],[0,2,500]]"),
                0, 2, 1)).isEqualTo(200);
        assertThat(findCheapestPrice(3, Ps.intArray("[[0,1,100],[1,2,100],[0,2,500]]"),
                0, 2, 0)).isEqualTo(500);
    }

    @Test
    public void tle() throws IOException {
        String filename = getClass().getPackage().getName().replaceAll("\\.", separator) + separator + "Q787CheapestFlightsWithinKStops.txt";
        URL resource = getClass().getClassLoader().getResource(filename);
        BufferedReader bf = new BufferedReader(new FileReader(resource.getFile()));
        String data = bf.readLine();
        assertThat(findCheapestPrice(83, Ps.intArray(data), 82, 19, 81));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        City[] cities = new City[n];
        for (int i = 0; i < n; i++) {
            cities[i] = new City(i);
        }
        for (int[] flight : flights) {
            cities[flight[0]].addFlight(flight[1], flight[2]);
        }

        Integer minPrice = null;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(src, 0);

        for (int move = 0; move <= k; move++) {
            Map<Integer, Integer> tmp = new HashMap<>();
            for (Map.Entry<Integer, Integer> status : map.entrySet()) {
                int index = status.getKey();
                int totalPrice = status.getValue();
                City cur = cities[index];

                for (Map.Entry<Integer, Integer> e : cur.next.entrySet()) {
                    int nextCity = e.getKey();
                    int flightPrice = e.getValue();
                    int nextPrice = totalPrice + flightPrice;
                    if (tmp.getOrDefault(nextCity, Integer.MAX_VALUE) > nextPrice) {
                        tmp.put(nextCity, nextPrice);
                    }

                    if (nextCity == dst) {
                        if (minPrice == null) {
                            minPrice = nextPrice;
                        }
                        minPrice = Math.min(minPrice, nextPrice);
                    }
                }
            }
            map = tmp;
        }
        return minPrice == null ? -1 : minPrice;
    }

    static class City {
        int index;
        Map<Integer, Integer> next = new HashMap<>();

        public City(int i) {
            this.index = i;
        }

        public void addFlight(int city, int price) {
            next.put(city, price);
        }
    }

}
