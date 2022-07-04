package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 2435 ms, faster than 5.02% of Java online submissions for Candy.
 * Memory Usage: 51.5 MB, less than 60.94% of Java online submissions for Candy.
 */
public class Q135Candy {

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
        int length = ratings.length;
        int[] answer = new int[length];
        int cnt = 0;

        while (cnt < length) {
            for (int i = 0; i < length; i++) {
                if (answer[i] == 0) {
                    if ((i == 0 || ratings[i - 1] >= ratings[i]) && (i == length - 1 || ratings[i + 1] >= ratings[i])) {
                        answer[i] = 1;
                        cnt++;
                    } else if (
                            (i == 0 || answer[i - 1] > 0 || ratings[i - 1] >= ratings[i])
                                    && (i == length - 1 || answer[i + 1] > 0 || ratings[i + 1] >= ratings[i])
                    ) {
                        int left, right;
                        if (i == 0 || ratings[i - 1] == ratings[i]) {
                            left = 0;
                        } else {
                            left = answer[i - 1] + 1;
                        }
                        if (i == length - 1 || ratings[i + 1] == ratings[i]) {
                            right = 0;
                        } else {
                            right = answer[i + 1] + 1;
                        }

                        answer[i] = Math.max(left, right);
                        cnt++;
                    }
                }
            }
        }

        return Arrays.stream(answer).sum();
    }

}
