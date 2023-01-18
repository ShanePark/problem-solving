package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q918MaximumSumCircularSubarray2 {

    @Test
    public void test() {
        assertThat(maxSubarraySumCircular(new int[]{1, -2, 3, -2})).isEqualTo(3);
        assertThat(maxSubarraySumCircular(new int[]{5, -3, 5})).isEqualTo(10);
        assertThat(maxSubarraySumCircular(new int[]{-3, -2, -3})).isEqualTo(-2);
        assertThat(maxSubarraySumCircular(new int[]{1, 2, 3})).isEqualTo(6);
    }

    /**
     * 2sec 437 ms
     */
    @Test
    public void tle() {
        int[] arr = new int[3 * 10000];
        assertThat(maxSubarraySumCircular(arr));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += nums[(i + j) % nums.length];
                max = Math.max(max, sum);
            }
        }
        return max;
    }

}
