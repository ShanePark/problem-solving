package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 53 ms Beats 91.83%
 * Memory 54.3 MB Beats 78.33%
 */
public class Q1027LongestArithmeticSubsequence {

    @Test
    public void test() {
        assertThat(longestArithSeqLength(new int[]{9, 4, 7, 2, 10})).isEqualTo(3);
        assertThat(longestArithSeqLength(new int[]{3, 6, 9, 12})).isEqualTo(4);
        assertThat(longestArithSeqLength(new int[]{20, 1, 15, 3, 10, 5, 8})).isEqualTo(4);
    }

    public int longestArithSeqLength(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][1001];

        int max = 0;

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            for (int j = 0; j < i; j++) {
                int numBefore = nums[j];
                int diff = (num - numBefore) + 500;
                int seqLength = dp[j][diff] + 1;
                dp[i][diff] = Math.max(dp[i][diff], seqLength);
                max = Math.max(dp[i][diff], max);
            }
        }

        return max + 1;
    }

}
