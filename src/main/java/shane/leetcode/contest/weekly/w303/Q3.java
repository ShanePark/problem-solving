package shane.leetcode.contest.weekly.w303;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q3 {

    @Test
    public void test() {
        FoodRatings r = new FoodRatings(new String[]{"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"}, new String[]{"korean", "japanese", "japanese", "greek", "japanese", "korean"}, new int[]{9, 12, 8, 15, 14, 7});
        assertThat(r.highestRated("korean")).isEqualTo("kimchi");
        assertThat(r.highestRated("japanese")).isEqualTo("ramen");
        r.changeRating("sushi", 16);
        assertThat(r.highestRated("japanese")).isEqualTo("sushi");
        r.changeRating("ramen", 16);
        assertThat(r.highestRated("japanese")).isEqualTo("ramen");
    }

    class FoodRatings {

        Map<String, PriorityQueue<Food>> pqMap = new HashMap<>();
        Map<String, String> cuisineMap = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                String name = foods[i];
                int rating = ratings[i];
                String cuisine = cuisines[i];
                PriorityQueue<Food> pq = pqMap.getOrDefault(cuisine, new PriorityQueue<>());
                pqMap.put(cuisine, pq);

                pq.offer(new Food(name, rating));
                cuisineMap.put(name, cuisine);
            }
        }

        public void changeRating(String food, int newRating) {
            String cuisine = cuisineMap.get(food);
            PriorityQueue<Food> pq = pqMap.get(cuisine);
            for (Food f : pq) {
                if (food.equals(f.name)) {
                    pq.remove(f);
                    f.rating = newRating;
                    pq.offer(f);
                    return;
                }
            }
        }

        public String highestRated(String cuisine) {
            PriorityQueue<Food> pq = pqMap.get(cuisine);
            return pq.isEmpty() ? null : pq.peek().name;
        }

        class Food implements Comparable {
            String name;
            int rating;

            public Food(String name, int rating) {
                this.name = name;
                this.rating = rating;
            }

            @Override
            public int compareTo(Object o) {
                Food f = (Food) o;
                if (f.rating == this.rating) {
                    return this.name.compareTo(f.name);
                }
                return Integer.compare(f.rating, this.rating);
            }
        }

    }

}
