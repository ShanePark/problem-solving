package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 21ms Beats 33.33%of users with Java
 * Memory Details 43.44MB Beats 51.49%of users with Java
 */
public class Q1220CountVowelsPermutation2 {

    @Test
    public void test() {
        assertThat(countVowelPermutation(144)).isEqualTo(18208803);
        assertThat(countVowelPermutation(1)).isEqualTo(5);
        assertThat(countVowelPermutation(2)).isEqualTo(10);
        assertThat(countVowelPermutation(5)).isEqualTo(68);
    }

    final int MOD = (int) 1e9 + 7;

    public int countVowelPermutation(int n) {
        int[][] dp = new int[n + 1][5];
        for (int i = 0; i < 5; i++) {
            dp[1][i] = 1;
        }
        for (int j = 2; j <= n; j++) {
            long a = (long) dp[j - 1][1] + dp[j - 1][2] + dp[j - 1][4];
            long e = (long) dp[j - 1][0] + dp[j - 1][2];
            long i = (long) dp[j - 1][1] + dp[j - 1][3];
            long o = dp[j - 1][2];
            long u = (long) dp[j - 1][2] + dp[j - 1][3];
            dp[j][0] = (int) (a % MOD);
            dp[j][1] = (int) (e % MOD);
            dp[j][2] = (int) (i % MOD);
            dp[j][3] = (int) (o % MOD);
            dp[j][4] = (int) (u % MOD);
        }

        return (int) (Arrays.stream(dp[n]).asLongStream().sum() % MOD);
    }

}
