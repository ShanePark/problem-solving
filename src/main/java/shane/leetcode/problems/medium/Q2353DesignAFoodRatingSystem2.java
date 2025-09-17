package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 204ms
 * Beats52.42%
 */
public class Q2353DesignAFoodRatingSystem2 {

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
        Map<String, TreeSet<Food>> cuisineTree = new HashMap<>();
        Map<String, TreeSet<Food>> foodTree = new HashMap<>();
        Map<String, Food> map = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                TreeSet<Food> tree = cuisineTree.getOrDefault(cuisines[i], new TreeSet<>());
                cuisineTree.put(cuisines[i], tree);
                Food f = new Food(foods[i], ratings[i]);
                tree.add(f);
                foodTree.put(foods[i], tree);
                map.put(foods[i], f);
            }
        }

        public void changeRating(String food, int newRating) {
            TreeSet<Food> tree = foodTree.get(food);
            Food f = map.get(food);
            tree.remove(f);
            f.score = newRating;
            tree.add(f);
        }

        public String highestRated(String cuisine) {
            TreeSet<Food> tree = cuisineTree.get(cuisine);
            return tree.last().name;
        }
    }

    static class Food implements Comparable<Food> {
        final String name;
        int score;

        public Food(String food, int rating) {
            this.name = food;
            this.score = rating;
        }

        @Override
        public int compareTo(Food f) {
            if (this.score == f.score) {
                return -this.name.compareTo(f.name);
            }
            return Integer.compare(this.score, f.score);
        }
    }

}
