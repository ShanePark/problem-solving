package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 3ms
 * Beats59.69%
 */
public class Q2270NumberOfWaysToSplitArray {

    @Test
    public void test() {
        assertThat(waysToSplitArray(new int[]{10, 4, -8, 7})).isEqualTo(2);
        assertThat(waysToSplitArray(new int[]{2, 3, 1, 0})).isEqualTo(2);
    }

    public int waysToSplitArray(int[] nums) {
        final int LENGTH = nums.length;
        long[] accSum = new long[LENGTH];
        accSum[0] = nums[0];
        for (int i = 1; i < LENGTH; i++) {
            accSum[i] = accSum[i - 1] + nums[i];
        }
        int answer = 0;
        long totalSum = accSum[LENGTH - 1];
        for (int i = 0; i < LENGTH - 1; i++) {
            long left = accSum[i];
            long right = totalSum - left;
            if (left >= right)
                answer++;
        }
        return answer;
    }

}
