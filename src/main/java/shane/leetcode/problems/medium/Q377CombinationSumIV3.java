package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 0ms Beats 100.00%of users with Java
 * Memory Details 40.01MB Beats 33.58%of users with Java
 */
public class Q377CombinationSumIV3 {

    @Test
    public void test() {
        assertThat(combinationSum4(new int[]{1, 2, 3}, 3)).isEqualTo(4);
        assertThat(combinationSum4(new int[]{1, 2, 3}, 4)).isEqualTo(7);
        assertThat(combinationSum4(new int[]{9}, 3)).isEqualTo(0);
        assertThat(combinationSum4(new int[]{1, 2, 3}, 30)).isEqualTo(53798080);
    }

    public int combinationSum4(int[] nums, int target) {
        Integer[] dp = new Integer[target + 1];
        dp[0] = 1;
        return getComb(dp, nums, target);
    }

    private int getComb(Integer[] dp, int[] nums, int target) {
        if (dp[target] != null)
            return dp[target];
        int cnt = 0;
        for (int num : nums) {
            if (target < num)
                continue;
            cnt += getComb(dp, nums, target - num);
        }
        return dp[target] = cnt;
    }

}
