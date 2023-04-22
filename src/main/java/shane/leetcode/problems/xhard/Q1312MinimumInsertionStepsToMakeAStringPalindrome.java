package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q1312MinimumInsertionStepsToMakeAStringPalindrome {

    @Test
    void test() {
        assertThat(minInsertions("zzazz")).isEqualTo(0);
        assertThat(minInsertions("mbadm")).isEqualTo(2);
        assertThat(minInsertions("leetcode")).isEqualTo(5);
    }

    public int minInsertions(String s) {
        int length = s.length();
        int[][] dp = new int[length + 1][length + 1];
        for (int i = 0; i < length; i++)
            for (int j = 0; j < length; j++) {
                if (s.charAt(i) == s.charAt(length - 1 - j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                    continue;
                }
                dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
            }
        return length - dp[length][length];
    }

}
