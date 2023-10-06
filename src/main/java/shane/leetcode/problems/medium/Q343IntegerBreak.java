package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 0ms Beats 100.00%of users with Java
 * Memory Details 38.98MB Beats 74.61%of users with Java
 */
public class Q343IntegerBreak {

    @Test
    public void test() {
        assertThat(integerBreak(2)).isEqualTo(1);
        assertThat(integerBreak(3)).isEqualTo(2);
        assertThat(integerBreak(4)).isEqualTo(4);
        assertThat(integerBreak(5)).isEqualTo(6);
        assertThat(integerBreak(6)).isEqualTo(9);
        assertThat(integerBreak(9)).isEqualTo(27);
        assertThat(integerBreak(10)).isEqualTo(36);
    }

    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        return integerBreak(n, dp);
    }

    private int integerBreak(int n, int[] dp) {
        if (dp[n] != 0)
            return dp[n];
        int max = 0;
        for (int i = 1; i <= n / 2; i++) {
            int before = Math.max(i, integerBreak(i, dp));
            int after = Math.max(n - i, integerBreak(n - i, dp));
            max = Math.max(max, before * after);
        }
        return dp[n] = max;
    }

}
