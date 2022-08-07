package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 40 ms, faster than 38.74% of Java online submissions for Count Vowels Permutation.
 * Memory Usage: 53.8 MB, less than 32.05% of Java online submissions for Count Vowels Permutation.
 */
public class Q1220CountVowelsPermutation {

    @Test
    public void test() {
        assertThat(countVowelPermutation(1)).isEqualTo(5);
        assertThat(countVowelPermutation(2)).isEqualTo(10);
        assertThat(countVowelPermutation(5)).isEqualTo(68);
        assertThat(countVowelPermutation(20000)).isEqualTo(759959057);
    }

    public int countVowelPermutation(int n) {
        final int MOD = (int) 1e9 + 7;
        long[][] dp = new long[n + 1][5];
        dp[0][0] = 1;
        dp[0][1] = 1;
        dp[0][2] = 1;
        dp[0][3] = 1;
        dp[0][4] = 1;
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][2];
            dp[i][2] = dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][3] + dp[i - 1][4];
            dp[i][3] = dp[i - 1][2] + dp[i - 1][4];
            dp[i][4] = dp[i - 1][0];
            for (int j = 0; j <= 4; j++) {
                dp[i][j] %= MOD;
            }
        }
        return (int) (Arrays.stream(dp[n - 1]).sum() % MOD);
    }
}
