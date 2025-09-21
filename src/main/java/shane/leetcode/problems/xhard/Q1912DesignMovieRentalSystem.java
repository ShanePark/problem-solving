package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1912DesignMovieRentalSystem {

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
        Map<Integer, TreeMap<Integer, List<Integer>>> movies = new HashMap<>(); // movie, price, shops
        Map<Integer, Boolean>[] shops; // value true: rentable, false: renting


        public MovieRentingSystem(int n, int[][] entries) {
            this.shops = new Map[n];
            for (int i = 0; i < n; i++) {
                shops[i] = new HashMap<>();
            }
            for (int[] entry : entries) {
                int shop = entry[0];
                int movie = entry[1];
                int price = entry[2];
                shops[shop].put(movie, true);
                TreeMap<Integer, List<Integer>> tree = movies.getOrDefault(movie, new TreeMap<>());
                movies.put(movie, tree);
                List<Integer> list = tree.getOrDefault(price, new ArrayList<>());
                tree.put(price, list);
                list.add(shop);
            }
            for (TreeMap<Integer, List<Integer>> value : movies.values()) {
                for (List<Integer> list : value.values()) {
                    Collections.sort(list);
                }
            }
        }

        public List<Integer> search(int movie) {
            TreeMap<Integer, List<Integer>> shopsForMovies = movies.get(movie);
            if (shopsForMovies == null)
                return Collections.emptyList();
            Set<Map.Entry<Integer, List<Integer>>> entries = shopsForMovies.entrySet();
            Iterator<Map.Entry<Integer, List<Integer>>> it = entries.iterator();
            List<Integer> list = new ArrayList<>();
            while (it.hasNext() && list.size() < 5) {
                Map.Entry<Integer, List<Integer>> map = it.next();
                List<Integer> shopsIds = map.getValue();
                for (Integer shopId : shopsIds) {
                    Map<Integer, Boolean> shop = this.shops[shopId];
                    if (!shop.get(movie))
                        continue;
                    list.add(shopId);
                    if (list.size() == 5)
                        break;
                }
            }
            return list;
        }

        public void rent(int shop, int movie) {
            Map<Integer, Boolean> shopMap = shops[shop];
            shopMap.put(movie, false);
        }

        public void drop(int shop, int movie) {
            Map<Integer, Boolean> shopMap = shops[shop];
            shopMap.put(movie, true);
        }

        public List<List<Integer>> report() {
            List<int[]> rentedMovies = new ArrayList<>();

            for (int shopId = 0; shopId < shops.length; shopId++) {
                Map<Integer, Boolean> shop = shops[shopId];
                for (Map.Entry<Integer, Boolean> entry : shop.entrySet()) {
                    int movieId = entry.getKey();
                    boolean isAvailable = entry.getValue();

                    if (!isAvailable) {
                        TreeMap<Integer, List<Integer>> moviePrices = movies.get(movieId);
                        for (Map.Entry<Integer, List<Integer>> priceEntry : moviePrices.entrySet()) {
                            int price = priceEntry.getKey();
                            List<Integer> shopsAtThisPrice = priceEntry.getValue();
                            if (shopsAtThisPrice.contains(shopId)) {
                                rentedMovies.add(new int[]{price, shopId, movieId});
                                break;
                            }
                        }
                    }
                }
            }

            rentedMovies.sort((a, b) -> {
                if (a[0] != b[0]) return Integer.compare(a[0], b[0]);
                if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
                return Integer.compare(a[2], b[2]);
            });

            List<List<Integer>> result = new ArrayList<>();
            int count = Math.min(5, rentedMovies.size());
            for (int i = 0; i < count; i++) {
                int[] movie = rentedMovies.get(i);
                result.add(Arrays.asList(movie[1], movie[2]));
            }

            return result;
        }
    }

}
