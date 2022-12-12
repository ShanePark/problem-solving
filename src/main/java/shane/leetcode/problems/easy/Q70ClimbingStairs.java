package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 41 MB Beats 30.22%
 */
public class Q70ClimbingStairs {

    @Test
    public void test() {
        assertThat(climbStairs(2)).isEqualTo(2);
        assertThat(climbStairs(3)).isEqualTo(3);
        assertThat(climbStairs(45)).isEqualTo(1836311903);
    }

    public int climbStairs(int n) {
        int[] dp = new int[46];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
