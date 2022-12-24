package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 66.43%
 * Memory 39.4 MB Beats 82.13%
 */
public class Q790DominoAndTrominoTiling {

    @Test
    public void test() {
        assertThat(numTilings(1)).isEqualTo(1);
        assertThat(numTilings(2)).isEqualTo(2);
        assertThat(numTilings(3)).isEqualTo(5);
        assertThat(numTilings(4)).isEqualTo(11);
        assertThat(numTilings(5)).isEqualTo(24);
        assertThat(numTilings(30)).isEqualTo(312342182);
    }

    public int numTilings(int n) {
        final int MOD = (int) 1e9 + 7;
        long[][] dp = new long[n + 2][3];
        dp[0][0] = 1;
        dp[1][0] = 1;
        dp[2][0] = 2;
        dp[2][1] = 1;
        dp[2][2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i][0] = (dp[i - 2][0] + dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 2][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 2][0] + dp[i - 1][1]) % MOD;
        }
        return (int) dp[n][0];
    }

}
