package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 125 ms Beats 21.91%
 * Memory 39.9 MB Beats 81.21%
 */
public class Q198HouseRobber {

    @Test
    public void test() {
        assertThat(rob(new int[]{1, 2, 3, 1})).isEqualTo(4);
        assertThat(rob(new int[]{2, 7, 9, 3, 1})).isEqualTo(12);
        assertThat(rob(new int[]{0})).isEqualTo(0);
    }

    public int rob(int[] nums) {
        final int LENGTH = nums.length;
        if (LENGTH == 1)
            return nums[0];
        int[] dp = new int[LENGTH];
        dp[1] = nums[0];
        for (int i = 2; i < LENGTH; i++) {
            nums[i] += dp[i - 1];
            dp[i] = Math.max(nums[i - 1], dp[i - 1]);
        }
        return Math.max(nums[LENGTH - 1], dp[LENGTH - 1]);
    }

}
