package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Runtime
 * 2ms
 * Beats99.56%
 */
@SuppressWarnings("ALL")
public class Q135Candy4 {

    @Test
    public void test() {
        assertThat(candy(new int[]{1, 0, 2})).isEqualTo(5);
        assertThat(candy(new int[]{1, 2, 2})).isEqualTo(4);
        assertThat(candy(new int[]{1, 6, 10, 8, 7, 3, 2})).isEqualTo(18);
        assertThat(candy(new int[]{1, 3, 4, 5, 2})).isEqualTo(11);
    }

    public int candy(int[] ratings) {
        final int LENGTH = ratings.length;
        int[] candies = new int[LENGTH];
        for (int i = 1; i < LENGTH; i++) {
            if (ratings[i - 1] < ratings[i]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        for (int i = LENGTH - 2; i >= 0; i--) {
            if (ratings[i + 1] < ratings[i]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        int answer = LENGTH;
        for (int candy : candies) {
            answer += candy;
        }
        return answer;
    }

}
