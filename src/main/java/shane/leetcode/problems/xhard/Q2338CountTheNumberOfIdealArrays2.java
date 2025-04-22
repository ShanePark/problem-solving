package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q2338CountTheNumberOfIdealArrays2 {

    @Test
    public void test() {
        assertThat(idealArrays(2, 5)).isEqualTo(10);
        assertThat(idealArrays(5, 3)).isEqualTo(11);
        assertThat(idealArrays(184, 389)).isEqualTo(510488787);
    }

    @Test
    public void mle() {
        assertThat(idealArrays(9767, 9557)).isEqualTo(1998089);
    }

    final int MOD = (int) 1e9 + 7;

    public int idealArrays(int n, int maxValue) {
        int maxIncreaseLength = (int) (Math.log(maxValue) / Math.log(2)) + 2;
        long[][] dp = new long[maxValue + 1][maxIncreaseLength];
        for (int i = 1; i <= maxValue; i++) {
            dp[i][1] = 1;
        }

        for (int j = 1; j < maxIncreaseLength - 1; j++) {
            for (int i = 1; i <= maxValue; i++) {
                for (int k = 2; i * k <= maxValue; k++) {
                    dp[k * i][j + 1] = (dp[i][j] + dp[k * i][j + 1]) % MOD;
                }
            }
        }

        long[][] comb = new long[n][maxIncreaseLength];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < maxIncreaseLength && j <= i; j++) {
                if (j == 0) {
                    comb[i][j] = 1;
                    continue;
                }
                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
            }
        }

        long answer = 0L;
        for (int i = 1; i <= maxValue; i++) {
            for (int j = 1; j < maxIncreaseLength && j <= n; j++) {
                answer = (answer + dp[i][j] * comb[n - 1][j - 1]) % MOD;
            }
        }
        return (int) answer;
    }

}
