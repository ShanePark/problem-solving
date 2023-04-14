package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 45 ms Beats 80.58%
 * Memory 51.9 MB Beats 51.59%
 */
public class Q516LongestPalindromicSubsequence {

    @Test
    void test() {
        assertThat(longestPalindromeSubseq("bbbab")).isEqualTo(4);
        assertThat(longestPalindromeSubseq("cbbd")).isEqualTo(2);
    }

    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        int[][] dp = new int[length][length];

        for (int right = 0; right < length; right++) {
            dp[right][right] = 1;
            for (int left = right - 1; left >= 0; left--) {
                if (s.charAt(right) == s.charAt(left)) {
                    dp[left][right] = dp[left + 1][right - 1] + 2;
                    continue;
                }
                dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
            }
        }
        return dp[0][length - 1];
    }

}
