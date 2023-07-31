package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q712MinimumASCIIDeleteSumForTwoStrings {

    @Test
    public void test() {
        assertThat(minimumDeleteSum("sea", "eat")).isEqualTo(231);
        assertThat(minimumDeleteSum("delete", "leet")).isEqualTo(403);
    }

    public int minimumDeleteSum(String s1, String s2) {
        final int LENGTH1 = s1.length();
        final int LENGTH2 = s2.length();

        int[][] dp = new int[LENGTH1 + 1][LENGTH2 + 1];

        for (int i = 0; i < LENGTH1; i++) {
            dp[i + 1][0] = dp[i][0] + s1.charAt(i);
        }
        for (int j = 0; j < LENGTH2; j++) {
            dp[0][j + 1] = dp[0][j] + s2.charAt(j);
        }

        for (int i = 0; i < LENGTH1; i++) {
            for (int j = 0; j < LENGTH2; j++) {
                char char1 = s1.charAt(i);
                char char2 = s2.charAt(j);
                if (char1 == char2) {
                    dp[i + 1][j + 1] = dp[i][j];
                    continue;
                }
                int removeChar1 = char1 + dp[i][j + 1];
                int removeChar2 = char2 + dp[i + 1][j];
                dp[i + 1][j + 1] = Math.min(removeChar1, removeChar2);
            }
        }

        return dp[LENGTH1][LENGTH2];
    }

}
