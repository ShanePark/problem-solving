package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 54.31%
 * Memory 39.9 MB Beats 77.43%
 */
public class Q486PredictTheWinner {

    @Test
    public void test() {
        assertThat(PredictTheWinner(new int[]{1, 3, 1})).isFalse();
        assertThat(PredictTheWinner(new int[]{1, 5, 2})).isFalse();
        assertThat(PredictTheWinner(new int[]{1, 5, 233, 7})).isTrue();
    }

    public boolean PredictTheWinner(int[] nums) {
        Integer[][] dp = new Integer[nums.length][nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i][i] = nums[i];
        }
        int sum = Arrays.stream(nums).sum();
        int max = getMax(0, nums.length - 1, nums, dp);
        return max * 2 >= sum;
    }

    private int getMax(int from, int end, int[] nums, Integer[][] dp) {
        if (dp[from][end] != null) {
            return dp[from][end];
        }
        if (from + 1 == end) {
            return dp[from][end] = Math.max(nums[from], nums[end]);
        }
        int sum = 0;
        for (int i = from; i <= end; i++) {
            sum += nums[i];
        }
        int case1 = getMax(from + 1, end, nums, dp);
        int case2 = getMax(from, end - 1, nums, dp);
        int max = sum - Math.min(case1, case2);
        return dp[from][end] = max;
    }

}
