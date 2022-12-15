package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 15 ms Beats 84.56%
 * Memory 46.1 MB Beats 72.53%
 */
public class Q1143LongestCommonSubsequence {

    @Test
    public void test() {
        assertThat(longestCommonSubsequence("bsbininm", "jmjkbkjkv")).isEqualTo(1);
        assertThat(longestCommonSubsequence("hofubmnylkra", "pqhgxgdofcvmr")).isEqualTo(5);
        assertThat(longestCommonSubsequence("ezupkr", "ubmrapg")).isEqualTo(2);
        assertThat(longestCommonSubsequence("abcde", "ace")).isEqualTo(3);
        assertThat(longestCommonSubsequence("abc", "abc")).isEqualTo(3);
        assertThat(longestCommonSubsequence("abc", "def")).isEqualTo(0);
        assertThat(longestCommonSubsequence("bl", "yby")).isEqualTo(1);
    }

    public int longestCommonSubsequence(String text1, String text2) {
        final int LENGTH1 = text1.length();
        final int LENGTH2 = text2.length();
        int[][] dp = new int[LENGTH1 + 1][LENGTH2 + 1];

        for (int i = 0; i < LENGTH1; i++) {
            for (int j = 0; j < LENGTH2; j++) {
                int before = Math.max(dp[i + 1][j], dp[i][j + 1]);
                dp[i + 1][j + 1] = before;
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = Math.max(before, dp[i][j] + 1);
                }
            }
        }
        return dp[LENGTH1][LENGTH2];
    }

}
