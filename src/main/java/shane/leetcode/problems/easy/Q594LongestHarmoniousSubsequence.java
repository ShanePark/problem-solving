package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 13ms
 * Beats83.08%
 */
public class Q594LongestHarmoniousSubsequence {

    @Test
    public void test() {
        assertThat(findLHS(new int[]{1, 3, 2, 2, 5, 2, 3, 7})).isEqualTo(5);
        assertThat(findLHS(new int[]{1, 2, 3, 4})).isEqualTo(2);
        assertThat(findLHS(new int[]{1, 1, 1, 1})).isEqualTo(0);
    }

    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int max = 0;
        for (int left = 0, right = 0; left < nums.length; left++) {
            while (right + 1 < nums.length && nums[left] + 1 >= nums[right + 1]) {
                right++;
            }
            if (nums[left] + 1 == nums[right]) {
                max = Math.max(max, right - left + 1);
            }
        }
        return max;
    }

}
