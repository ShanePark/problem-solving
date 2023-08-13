package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 56ms Beats 5.83%of users with Java
 * Memory Details 64.79mb Beats 8.74%of users with Java
 */
public class Q2369CheckIfThereIsAValidPartitionForTheArray3 {

    @Test
    public void test() {
        assertThat(validPartition(new int[]{730480, 730481, 730482, 730483, 730484, 730485})).isTrue();
        assertThat(validPartition(new int[]{4, 4, 4, 5, 6})).isTrue();
        assertThat(validPartition(new int[]{1, 1, 1, 2})).isFalse();
    }

    public boolean validPartition(int[] nums) {
        Boolean[] dp = new Boolean[nums.length];
        boolean result = validPartition(dp, nums, 0);
        System.err.println("Arrays.toString(dp) = " + Arrays.toString(dp));
        return result;

    }

    private boolean validPartition(Boolean[] dp, int[] nums, int from) {
        if (from == nums.length)
            return true;
        if (from >= nums.length - 1)
            return false;

        if (dp[from] != null)
            return dp[from];

        // cut length2
        boolean canCut2 = (nums[from] == nums[from + 1]);
        if (canCut2 && validPartition(dp, nums, from + 2) == true) {
            return dp[from] = true;
        }

        // cut length3
        boolean canCut3 = (from + 3 <= nums.length) && (allSame(nums, from) || increase(nums, from));
        if (canCut3 && validPartition(dp, nums, from + 3) == true) {
            return dp[from] = true;
        }
        return dp[from] = false;
    }

    private boolean increase(int[] nums, int from) {
        return nums[from + 2] == nums[from] + 2 && nums[from + 1] == nums[from] + 1;
    }

    private boolean allSame(int[] nums, int from) {
        return nums[from] == nums[from + 1] && nums[from] == nums[from + 2];
    }

}
