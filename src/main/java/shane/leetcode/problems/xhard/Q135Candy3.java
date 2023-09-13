package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


@SuppressWarnings("ALL")
public class Q135Candy3 {

    @Test
    public void test() {
        assertThat(candy(new int[]{1, 0, 2})).isEqualTo(5);
        assertThat(candy(new int[]{1, 2, 2})).isEqualTo(4);
        assertThat(candy(new int[]{1, 6, 10, 8, 7, 3, 2})).isEqualTo(18);
    }

    public int candy(int[] ratings) {
        final int LENGTH = ratings.length;
        int[] arr = new int[LENGTH];

        for (int i = 1; i < LENGTH; i++) {
            if (ratings[i] > ratings[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        for (int i = LENGTH - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i] && arr[i - 1] < arr[i] + 1) {
                arr[i - 1] = arr[i] + 1;
            }
        }

        return arr.length + Arrays.stream(arr).sum();
    }

}
