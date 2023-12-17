package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 842ms Beats 37.85%of users with Java
 * Memory Details 74.20MB Beats 32.20%of users with Java
 */
public class Q2353DesignAFoodRatingSystem {

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
        Map<String, PriorityQueue<Food>> cuisineMap = new HashMap<>();
        Map<String, Food> foodMap = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            int length = foods.length;
            for (int i = 0; i < length; i++) {
                Food food = new Food(foods[i], cuisines[i], ratings[i]);
                foodMap.put(foods[i], food);
                PriorityQueue<Food> cuisine = cuisineMap.getOrDefault(cuisines[i], new PriorityQueue<>());
                cuisineMap.put(cuisines[i], cuisine);
                cuisine.offer(food);
            }
        }

        public void changeRating(String food, int newRating) {
            Food f = foodMap.get(food);
            if (f == null)
                return;
            f.changeRating(newRating);
            PriorityQueue<Food> cuisine = cuisineMap.get(f.cuisine);
            cuisine.remove(f);
            cuisine.offer(f);
        }

        public String highestRated(String cuisine) {
            PriorityQueue<Food> pq = cuisineMap.get(cuisine);
            if (pq == null || pq.isEmpty())
                return null;
            return pq.peek().name;
        }
    }

    class Food implements Comparable<Food> {
        final String name;
        final String cuisine;
        int rating;

        public Food(String name, String cuisine, int rating) {
            this.name = name;
            this.cuisine = cuisine;
            this.rating = rating;
        }

        public void changeRating(int newRating) {
            this.rating = newRating;
        }

        @Override
        public int compareTo(Food f) {
            if (f.rating == this.rating)
                return this.name.compareTo(f.name);
            return Integer.compare(f.rating, this.rating);
        }
    }

}
