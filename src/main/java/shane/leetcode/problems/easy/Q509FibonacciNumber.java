package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q509FibonacciNumber {

    @Test
    public void test() {
        assertThat(fib(2)).isEqualTo(1);
        assertThat(fib(3)).isEqualTo(2);
        assertThat(fib(4)).isEqualTo(3);
        assertThat(fib(5)).isEqualTo(5);
        assertThat(fib(30)).isEqualTo(832040);
    }

    public int fib(int n) {
        int[] dp = new int[31];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
