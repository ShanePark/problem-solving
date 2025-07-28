package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 9ms
 * Beats48.40%
 */
public class Q2044CountNumberOfMaximumBitwiseORSubsets3 {

    @Test
    public void test() {
        assertThat(countMaxOrSubsets(new int[]{3, 1})).isEqualTo(2);
        assertThat(countMaxOrSubsets(new int[]{2, 2, 2})).isEqualTo(7);
        assertThat(countMaxOrSubsets(new int[]{3, 2, 1, 5})).isEqualTo(6);
    }

    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max |= num;
        }
        return dfs(nums, 0, 0, max);
    }

    private int dfs(int[] nums, int cur, int index, int max) {
        if (index == nums.length) {
            if (cur == max)
                return 1;
            return 0;
        }
        return dfs(nums, cur, index + 1, max) + dfs(nums, cur | nums[index], index + 1, max);
    }

}
