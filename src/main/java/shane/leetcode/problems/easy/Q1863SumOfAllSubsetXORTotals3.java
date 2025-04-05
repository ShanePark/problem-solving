package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 0
 * ms
 * Beats
 * 100.00%
 */
public class Q1863SumOfAllSubsetXORTotals3 {

    @Test
    public void test() {
        assertThat(subsetXORSum(new int[]{1, 3})).isEqualTo(6);
        assertThat(subsetXORSum(new int[]{5, 1, 6})).isEqualTo(28);
        assertThat(subsetXORSum(new int[]{3, 4, 5, 6, 7, 8})).isEqualTo(480);
    }


    int sum = 0;

    public int subsetXORSum(int[] nums) {
        sum = 0;
        dfs(nums, 0, 0);
        return sum;
    }

    private void dfs(int[] nums, int i, int cur) {
        if (nums.length == i)
            return;
        int xor = cur ^ nums[i];
        sum += xor;
        dfs(nums, i + 1, cur);
        dfs(nums, i + 1, xor);
    }

}
