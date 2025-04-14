package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 20ms
 * Beats5.81%
 */
public class Q1534CountGoodTriplets2 {
    @Test
    public void test() {
        assertThat(countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3)).isEqualTo(4);
        assertThat(countGoodTriplets(new int[]{1, 1, 2, 2, 3}, 0, 0, 1)).isEqualTo(0);
    }

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (isGood(arr, i, j, k, a, b, c)) {
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    private boolean isGood(int[] arr, int i, int j, int k, int a, int b, int c) {
        return Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c;
    }

}
