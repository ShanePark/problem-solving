package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Runtime: 3 ms, faster than 86.84% of Java online submissions for Candy.
 * Memory Usage: 51.8 MB, less than 44.36% of Java online submissions for Candy.
 */
@SuppressWarnings("ALL")
public class Q135Candy2 {

    @Test
    public void test() {
        assertThat(candy(new int[]{1, 2, 4, 4, 3})).isEqualTo(9);
        assertThat(candy(new int[]{29, 51, 87, 87, 72, 12})).isEqualTo(12);
        assertThat(candy(new int[]{1, 2, 87, 87, 87, 2, 1})).isEqualTo(13);
        assertThat(candy(new int[]{1, 2, 2, 2, 1, 1})).isEqualTo(8);
        assertThat(candy(new int[]{1, 0, 2})).isEqualTo(5);
        assertThat(candy(new int[]{1, 2, 2})).isEqualTo(4);
    }

    public int candy(int[] ratings) {
        int[] answer = new int[ratings.length];
        int sum = 0;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                answer[i] = answer[i - 1] + 1;
                sum += answer[i];
            }
        }

        for (int i = ratings.length - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && answer[i - 1] < answer[i] + 1) {
                sum = sum - answer[i - 1] + answer[i] + 1;
                answer[i - 1] = answer[i] + 1;
            }
        }

        return sum + ratings.length;
    }

}
