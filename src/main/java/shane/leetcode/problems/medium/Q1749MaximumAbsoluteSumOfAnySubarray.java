package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 6ms
 * Beats43.39%
 */
public class Q1749MaximumAbsoluteSumOfAnySubarray {

    @Test
    public void test() {
        assertThat(maxAbsoluteSum(new int[]{1, -3, 2, 3, -4})).isEqualTo(5);
        assertThat(maxAbsoluteSum(new int[]{2, -5, 1, -4, 3, -2})).isEqualTo(8);
    }

    public int maxAbsoluteSum(int[] nums) {
        int curMin = 0;
        int curMax = 0;
        int min = 0;
        int max = 0;
        for (int num : nums) {
            curMin = Math.min(curMin + num, num);
            curMax = Math.max(curMax + num, num);
            max = Math.max(max, curMax);
            min = Math.min(min, curMin);
        }
        return Math.max(Math.abs(min), max);
    }

}
