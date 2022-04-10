package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1863SumOfAllSubsetXORTotals {

    @Test
    public void test() {
        assertThat(subsetXORSum(new int[]{5, 1, 6})).isEqualTo(28);
        assertThat(subsetXORSum(new int[]{1, 3})).isEqualTo(6);
    }

    int sum;

    public int subsetXORSum(int[] nums) {
        sum = 0;
        dfs(nums, 0, 0);
        return sum;
    }

    private void dfs(int[] nums, int index, int cur) {
        if (index == nums.length) {
            sum += cur;
            return;
        }

        dfs(nums, index + 1, cur);
        dfs(nums, index + 1, cur ^ nums[index]);
    }
}
