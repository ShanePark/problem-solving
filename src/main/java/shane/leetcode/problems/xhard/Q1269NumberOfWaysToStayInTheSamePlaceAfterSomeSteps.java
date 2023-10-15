package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 12ms Beats 48.17%of users with Java
 * Memory Details 43.54MB Beats 50.00%of users with Java
 */
public class Q1269NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {

    @Test
    public void test() {
        assertThat(numWays(3, 2)).isEqualTo(4);
        assertThat(numWays(2, 4)).isEqualTo(2);
        assertThat(numWays(4, 2)).isEqualTo(8);
    }

    final int MOD = (int) 1e9 + 7;

    public int numWays(int steps, int arrLen) {
        int LENGTH = Math.min(steps, arrLen);
        int[] dp = new int[LENGTH];
        dp[0] = 1;
        for (int i = 1; i <= steps; i++) {
            int[] next = new int[LENGTH];
            for (int j = 0; j < LENGTH; j++) {
                if (0 < j) {
                    next[j] = (next[j] + dp[j - 1]) % MOD;
                }
                next[j] = (next[j] + dp[j]) % MOD;
                if (j < LENGTH - 1) {
                    next[j] = (next[j] + dp[j + 1]) % MOD;
                }
            }
            dp = next;
        }
        return dp[0];
    }

}
