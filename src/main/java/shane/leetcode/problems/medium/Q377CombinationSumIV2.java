package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q377CombinationSumIV2 {

    /**
     * Runtime: 3 ms, faster than 36.49% of Java online submissions for Combination Sum IV.
     * Memory Usage: 41.7 MB, less than 33.56% of Java online submissions for Combination Sum IV.
     */
    @Test
    public void test() {
        assertThat(combinationSum4(new int[]{1, 2, 3}, 3)).isEqualTo(4);
        assertThat(combinationSum4(new int[]{1, 2, 3}, 4)).isEqualTo(7);
        assertThat(combinationSum4(new int[]{9}, 3)).isEqualTo(0);
        assertThat(combinationSum4(new int[]{1, 2, 3}, 30)).isEqualTo(53798080);
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }

}
