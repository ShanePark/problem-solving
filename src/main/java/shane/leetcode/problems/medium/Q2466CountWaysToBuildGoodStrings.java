package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 19 ms Beats 36.28%
 * Memory 42.4 MB Beats 48.67%
 */
public class Q2466CountWaysToBuildGoodStrings {

    @Test
    void test() {
        assertThat(countGoodStrings(3, 3, 1, 1)).isEqualTo(8);
        assertThat(countGoodStrings(2, 3, 1, 2)).isEqualTo(5);
    }

    final int MOD = (int) 1e9 + 7;

    public int countGoodStrings(int low, int high, int zero, int one) {
        long[] dp = new long[high + 1];
        dp[zero]++;
        dp[one]++;
        for (int i = 0; i < dp.length; i++) {
            if (i >= zero)
                dp[i] = (dp[i] + dp[i - zero]) % MOD;
            if (i >= one)
                dp[i] = (dp[i] + dp[i - one]) % MOD;
        }

        int sum = 0;
        for (int i = low; i <= high; i++) {
            sum = (int) ((sum + dp[i]) % MOD);
        }
        return sum;
    }

}
