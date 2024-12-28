package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q689MaximumSumOf3NonOverlappingSubarrays {

    @Test
    public void test() {
        assertThat(maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 6, 7, 5, 1}, 2)).containsExactly(0, 3, 5);
        assertThat(maxSumOfThreeSubarrays(new int[]{1, 2, 1, 2, 1, 2, 1, 2, 1}, 2)).containsExactly(0, 2, 4);
        assertThat(maxSumOfThreeSubarrays(new int[]{1, 1, 1, 1}, 1)).containsExactly(0, 1, 2);
    }

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] prefixSum = new int[n + 1];
        int[] leftPos = new int[n];
        int[] rightPos = new int[n];
        int[] result = new int[3];
        int maxSum = 0;

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        for (int i = k, maxLeftSum = prefixSum[k] - prefixSum[0]; i < n; i++) {
            int currentSum = prefixSum[i + 1] - prefixSum[i + 1 - k];
            if (currentSum > maxLeftSum) {
                leftPos[i] = i + 1 - k;
                maxLeftSum = currentSum;
            } else {
                leftPos[i] = leftPos[i - 1];
            }
        }

        rightPos[n - k] = n - k;
        for (int i = n - k - 1, maxRightSum = prefixSum[n] - prefixSum[n - k]; i >= 0; i--) {
            int currentSum = prefixSum[i + k] - prefixSum[i];
            if (currentSum >= maxRightSum) {
                rightPos[i] = i;
                maxRightSum = currentSum;
            } else {
                rightPos[i] = rightPos[i + 1];
            }
        }

        for (int i = k; i <= n - 2 * k; i++) {
            int left = leftPos[i - 1];
            int right = rightPos[i + k];
            int currentSum = (prefixSum[i + k] - prefixSum[i]) +
                    (prefixSum[left + k] - prefixSum[left]) +
                    (prefixSum[right + k] - prefixSum[right]);
            if (currentSum > maxSum) {
                maxSum = currentSum;
                result[0] = left;
                result[1] = i;
                result[2] = right;
            }
        }

        return result;
    }

}
