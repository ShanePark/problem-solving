package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1ms
 * Beats98.36%
 */
public class Q3423MaximumDifferenceBetweenAdjacentElementsInACircularArray {

    public int maxAdjacentDistance(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, Math.abs(nums[i] - nums[i + 1]));
        }
        return Math.max(max, Math.abs(nums[nums.length - 1] - nums[0]));
    }

    @Test
    public void test() {
        assertThat(maxAdjacentDistance(new int[]{1, 2, 4})).isEqualTo(3);
        assertThat(maxAdjacentDistance(new int[]{-5, -10, -5})).isEqualTo(5);
    }

}
