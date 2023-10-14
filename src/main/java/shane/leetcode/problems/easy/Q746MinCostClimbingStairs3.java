package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 1ms Beats 46.22%of users with Java
 * Memory Details 42.86MB Beats 62.37%of users with Java
 */
public class Q746MinCostClimbingStairs3 {

    @Test
    public void test() {
        assertThat(minCostClimbingStairs(new int[]{10, 15, 20})).isEqualTo(15);
        assertThat(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1})).isEqualTo(6);
    }

    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= cost.length; i++) {
            int step1 = dp[i - 1] + cost[i - 1];
            int step2 = dp[i - 2] + cost[i - 2];
            dp[i] = Math.min(step1, step2);
        }
        return dp[cost.length];
    }

}
