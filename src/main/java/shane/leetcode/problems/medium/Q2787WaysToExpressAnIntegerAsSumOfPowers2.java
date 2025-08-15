package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2787WaysToExpressAnIntegerAsSumOfPowers2 {

    @Test
    public void test() {
        assertThat(numberOfWays(10, 2)).isEqualTo(1);
        assertThat(numberOfWays(4, 1)).isEqualTo(2);
    }

    @Test
    public void tle() {
        assertThat(numberOfWays(300, 1)).isEqualTo(872_471_266);
        assertThat(numberOfWays(126, 1)).isEqualTo(3_457_027);
    }

    final int MOD = (int) 1e9 + 7;

    public int numberOfWays(int n, int x) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            int pow = (int) Math.pow(i, x);
            if (pow > n) {
                break;
            }
            for (int j = n; j >= pow; j--) {
                dp[j] = (dp[j] + dp[j - pow]) % MOD;
            }
        }
        return dp[n];
    }

}
