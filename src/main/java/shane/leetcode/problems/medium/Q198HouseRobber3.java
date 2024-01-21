package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 5.86% of users with Java
 */
public class Q198HouseRobber3 {

    @Test
    public void test() {
        assertThat(rob(new int[]{1, 2, 3, 1})).isEqualTo(4);
        assertThat(rob(new int[]{2, 7, 9, 3, 1})).isEqualTo(12);
    }

    public int rob(int[] nums) {
        int[][] dp = new int[nums.length][2];
        // include
        dp[0][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // include
            dp[i][0] = dp[i - 1][1] + nums[i];
            // skip
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1]);
        }
        return Arrays.stream(dp[nums.length - 1]).max().getAsInt();
    }

}
