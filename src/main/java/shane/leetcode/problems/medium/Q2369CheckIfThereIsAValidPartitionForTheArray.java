package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Memory Limit Exceeded
 * 58 / 117 testcases passed
 */
public class Q2369CheckIfThereIsAValidPartitionForTheArray {

    @Test
    public void test() {
        assertThat(validPartition(new int[]{4, 4, 4, 5, 6})).isTrue();
        assertThat(validPartition(new int[]{1, 1, 1, 2})).isFalse();
    }

    public boolean validPartition(int[] nums) {
        final int LENGTH = nums.length;
        Boolean[][] dp = new Boolean[LENGTH][LENGTH];
        return validPartition(dp, nums, 0, LENGTH - 1);

    }

    private boolean validPartition(Boolean[][] dp, int[] nums, int from, int end) {
        if (dp[from][end] != null)
            return dp[from][end];
        if (from + 1 == end) {
            return dp[from][end] = (nums[from] == nums[end]);
        }
        if (from + 2 == end) {
            if (nums[from] == nums[from + 1] && nums[from] == nums[from + 2]) {
                return dp[from][end] = true;
            }
            if (nums[from + 2] == nums[from] + 2 && nums[from + 1] == nums[from] + 1) {
                return dp[from][end] = true;
            }
            return dp[from][end] = false;
        }
        if (from + 3 == end) {
            return dp[from][end] = validPartition(dp, nums, from, from + 1) && validPartition(dp, nums, from + 2, end);
        }

        // cut length2
        if (validPartition(dp, nums, from, from + 1) == true && validPartition(dp, nums, from + 2, end) == true) {
            return dp[from][end] = true;
        }

        // cut length3
        if (validPartition(dp, nums, from, from + 2) == true && validPartition(dp, nums, from + 3, end) == true) {
            return dp[from][end] = true;
        }
        return dp[from][end] = false;
    }

}
