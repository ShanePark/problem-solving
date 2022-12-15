package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 39.6 MB Beats 93.88%
 */
public class Q198HouseRobber2 {

    @Test
    public void test() {
        assertThat(rob(new int[]{2, 1, 1, 2})).isEqualTo(4);
        assertThat(rob(new int[]{2, 7, 19, 3, 1, 5})).isEqualTo(26);
        assertThat(rob(new int[]{1, 2, 3, 1})).isEqualTo(4);
        assertThat(rob(new int[]{2, 7, 9, 3, 1})).isEqualTo(12);
        assertThat(rob(new int[]{0})).isEqualTo(0);
    }

    public int rob(int[] nums) {
        final int LENGTH = nums.length;
        if (LENGTH == 1)
            return nums[0];

        for (int i = 2; i < LENGTH; i++) {
            nums[i] = Math.max(nums[i] + nums[i - 2], nums[i - 1]);
            nums[i - 1] = Math.max(nums[i - 1], nums[i - 2]);
        }
        return Math.max(nums[LENGTH - 1], nums[LENGTH - 2]);
    }

}
