package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1912DesignMovieRentalSystem2 {

    @Test
    public void test() {
        MovieRentingSystem movieRentingSystem = new MovieRentingSystem(3, Ps.intArray("[[0,1,5],[0,2,6],[0,3,7],[1,1,4],[1,2,7],[2,1,5]]"));
        assertThat(movieRentingSystem.search(1)).isEqualTo(List.of(1, 0, 2));
        movieRentingSystem.rent(0, 1);
        movieRentingSystem.rent(1, 2);
        assertThat(movieRentingSystem.report()).isEqualTo(Ps.intList("[[0,1],[1,2]]"));
        movieRentingSystem.drop(1, 2);
        assertThat(movieRentingSystem.search(2)).isEqualTo(List.of(0, 1));
    }

    class MovieRentingSystem {
        private final Map<Integer, TreeSet<int[]>> available = new HashMap<>();
        private final TreeSet<int[]> rented = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        private final Map<String, Integer> prices = new HashMap<>();

        public MovieRentingSystem(int n, int[][] entries) {
            for (int[] entry : entries) {
                int shop = entry[0];
                int movie = entry[1];
                int price = entry[2];

                available.computeIfAbsent(movie, k -> new TreeSet<>((a, b) -> {
                    if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                    return Integer.compare(a[1], b[1]);
                })).add(new int[]{price, shop});

                prices.put(shop + "," + movie, price);
            }
        }

        public List<Integer> search(int movie) {
            List<Integer> result = new ArrayList<>();
            TreeSet<int[]> shops = available.get(movie);
            if (shops == null) return result;

            for (int[] shop : shops) {
                result.add(shop[1]);
                if (result.size() == 5) break;
            }
            return result;
        }

        public void rent(int shop, int movie) {
            TreeSet<int[]> shops = available.get(movie);
            int price = prices.get(shop + "," + movie);
            shops.remove(new int[]{price, shop});
            rented.add(new int[]{price, shop, movie});
        }

        public void drop(int shop, int movie) {
            int price = prices.get(shop + "," + movie);
            rented.remove(new int[]{price, shop, movie});
            available.get(movie).add(new int[]{price, shop});
        }

        public List<List<Integer>> report() {
            List<List<Integer>> result = new ArrayList<>();
            int count = 0;
            for (int[] item : rented) {
                result.add(Arrays.asList(item[1], item[2]));
                if (++count == 5) break;
            }
            return result;
        }
    }

}
