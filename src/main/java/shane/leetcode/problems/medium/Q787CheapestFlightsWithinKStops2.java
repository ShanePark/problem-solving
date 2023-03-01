package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

import static java.io.File.separator;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 16 ms Beats 28.59%
 * Memory 47.3 MB Beats 21.9%
 */
public class Q787CheapestFlightsWithinKStops2 {

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
        List<City> cities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            cities.add(new City(i));
        }
        for (int[] f : flights) {
            City from = cities.get(f[0]);
            City to = cities.get(f[1]);
            Flight flight = new Flight(from, to, f[2]);
            from.addFlight(flight);
        }

        int[] minPrice = new int[n];
        Arrays.fill(minPrice, Integer.MAX_VALUE);
        minPrice[src] = 0;

        Queue<Status> q = new LinkedList<>();
        City from = cities.get(src);
        q.offer(new Status(from));
        for (int move = 0; move <= k && !q.isEmpty(); move++) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Status poll = q.poll();
                for (Flight flight : poll.curCity.flights) {
                    City nextCity = flight.to;
                    Status next = poll.next(flight);
                    if (next.curCost < minPrice[nextCity.index]) {
                        minPrice[nextCity.index] = next.curCost;
                        q.add(next);
                    }
                }
            }
        }

        if (minPrice[dst] == Integer.MAX_VALUE)
            return -1;
        return minPrice[dst];
    }

    class Status {
        City curCity;
        int curCost = 0;

        public Status(City curCity) {
            this.curCity = curCity;
        }

        public Status next(Flight flight) {
            Status next = new Status(flight.to);
            next.curCost = curCost + flight.price;
            return next;
        }
    }

    class City {
        int index;

        public City(int index) {
            this.index = index;
        }

        List<Flight> flights = new ArrayList<>();

        void addFlight(Flight flight) {
            this.flights.add(flight);
        }
    }

    class Flight {
        City from;
        City to;
        int price;

        public Flight(City from, City to, int price) {
            this.from = from;
            this.to = to;
            this.price = price;
        }
    }
}
