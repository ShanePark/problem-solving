package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 4 ms Beats 82.94%
 * Memory 47.7 MB Beats 68.25%
 */
public class Q918MaximumSumCircularSubarray3 {

    @Test
    public void test() {
        assertThat(maxSubarraySumCircular(new int[]{1, -2, 3, -2})).isEqualTo(3);
        assertThat(maxSubarraySumCircular(new int[]{5, -3, 5})).isEqualTo(10);
        assertThat(maxSubarraySumCircular(new int[]{-3, -2, -3})).isEqualTo(-2);
        assertThat(maxSubarraySumCircular(new int[]{1, 2, 3})).isEqualTo(6);
    }

    @Test
    public void tle() {
        int[] arr = new int[3 * 10000];
        assertThat(maxSubarraySumCircular(arr));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int maxSubArray = 0;
        int minSubArray = 0;
        for (int n : nums) {
            maxSubArray = Math.max(maxSubArray + n, n);
            max = Math.max(max, maxSubArray);
            minSubArray = Math.min(minSubArray + n, n);
            min = Math.min(min, minSubArray);
            sum += n;
        }

        if (max <= 0)
            return max;
        return Math.max(max, sum - min);
    }

}
