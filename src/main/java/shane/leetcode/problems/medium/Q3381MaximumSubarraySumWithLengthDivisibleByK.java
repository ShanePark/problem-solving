package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3381MaximumSubarraySumWithLengthDivisibleByK {

    @Test
    public void test() {
        assertThat(maxSubarraySum(new int[]{1, 2}, 1)).isEqualTo(3);
        assertThat(maxSubarraySum(new int[]{-1, -2, -3, -4, -5}, 4)).isEqualTo(-10);
        assertThat(maxSubarraySum(new int[]{-5, 1, 2, -3, 4}, 2)).isEqualTo(4);
    }

    public long maxSubarraySum(int[] nums, int k) {
        long[] prefixSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        long max = Long.MIN_VALUE;
        long[] minPrefixSum = new long[k];
        Arrays.fill(minPrefixSum, Long.MAX_VALUE);

        for (int i = 0; i < prefixSum.length; i++) {
            int mod = i % k;
            if (minPrefixSum[mod] != Long.MAX_VALUE) {
                max = Math.max(max, prefixSum[i] - minPrefixSum[mod]);
            }
            minPrefixSum[mod] = Math.min(minPrefixSum[mod], prefixSum[i]);
        }
        return max;
    }

}
