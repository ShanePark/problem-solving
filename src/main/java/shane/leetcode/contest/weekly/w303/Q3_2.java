package shane.leetcode.contest.weekly.w303;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 1771 ms
 */
@SuppressWarnings("ALL")
public class Q3_2 {

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

    @Test
    public void test2() {
        FoodRatings r = new FoodRatings(new String[]{"emgqdbo", "jmvfxjohq", "qnvseohnoe", "yhptazyko", "ocqmvmwjq"}, new String[]{"snaxol", "snaxol", "snaxol", "fajbervsj", "fajbervsj"}, new int[]{2, 6, 18, 6, 5});
        r.changeRating("qnvseohnoe", 11);
        assertThat(r.highestRated("fajbervsj")).isEqualTo("yhptazyko");
        r.changeRating("emgqdbo", 3);
        r.changeRating("jmvfxjohq", 9);
        r.changeRating("emgqdbo", 14);
        assertThat(r.highestRated("fajbervsj")).isEqualTo("yhptazyko");
        assertThat(r.highestRated("snaxol")).isEqualTo("emgqdbo");

    }

    @Test
    public void test3() {
        FoodRatings r = new FoodRatings(new String[]{"czopaaeyl", "lxoozsbh", "kbaxapl"}
                , new String[]{"dmnuqeatj", "dmnuqeatj", "dmnuqeatj"}
                , new int[]{11, 2, 15});
        r.changeRating("czopaaeyl", 12);
        assertThat(r.highestRated("dmnuqeatj")).isEqualTo("kbaxapl");
        r.changeRating("kbaxapl", 8);
        r.changeRating("lxoozsbh", 5);
        assertThat(r.highestRated("dmnuqeatj")).isEqualTo("czopaaeyl");
    }

    class FoodRatings {

        Map<String, PriorityQueue<Food>> pqMap = new HashMap<>();
        Map<String, Food> map = new HashMap<>();

        public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
            for (int i = 0; i < foods.length; i++) {
                String name = foods[i];
                String cuisine = cuisines[i];
                Food food = new Food(name, cuisine, ratings[i]);

                PriorityQueue<Food> pq = pqMap.get(cuisine);
                if (pq == null) {
                    pq = new PriorityQueue<>();
                    pqMap.put(cuisine, pq);
                }
                pq.offer(food);
                map.put(name, food);
            }
        }

        public void changeRating(String food, int newRating) {
            Food f = map.get(food);
            f.rating = newRating;
            PriorityQueue<Food> pq = pqMap.get(f.cuisine);
            pq.remove(f);
            pq.offer(f);
        }

        public String highestRated(String cuisine) {
            return pqMap.get(cuisine).peek().name;
        }

        class Food implements Comparable {
            String name;
            String cuisine;
            int rating;

            public Food(String name, String cuisine, int rating) {
                this.name = name;
                this.cuisine = cuisine;
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
