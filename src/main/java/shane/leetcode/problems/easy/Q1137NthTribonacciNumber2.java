package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q1137NthTribonacciNumber2 {


    @Test
    public void test() {
        assertThat(tribonacci(4)).isEqualTo(4);
        assertThat(tribonacci(25)).isEqualTo(1389537);
        assertThat(tribonacci(0)).isEqualTo(0);
    }

    public int tribonacci(int n) {
        int[] dp = new int[Math.max(3, n + 1)];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[n];
    }

}
