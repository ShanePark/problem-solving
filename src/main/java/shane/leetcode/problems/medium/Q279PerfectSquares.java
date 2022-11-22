package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q279PerfectSquares {

    @Test
    public void test() {
        assertThat(numSquares(3)).isEqualTo(3);
        assertThat(numSquares(12)).isEqualTo(3);
        assertThat(numSquares(13)).isEqualTo(2);
        assertThat(numSquares(32)).isEqualTo(2);
    }

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        while (dp[n] == 0) {
            for (int i = 1; i < n; i++) {
                for (int j = 1; i + j <= n; j++) {
                    if (0 < dp[i] && 0 < dp[j] && (dp[i + j] == 0 || dp[i + j] > dp[i] + dp[j])) {
                        dp[i + j] = dp[i] + dp[j];
                    }
                }
            }
        }
        return dp[n];
    }
}
