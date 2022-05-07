package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
@SuppressWarnings("ALL")
public class Q456_132Pattern3 {

    @Test
    public void test() {
        assertThat(find132pattern(new int[]{1, 2, 3, 4})).isFalse();
        assertThat(find132pattern(new int[]{3, 1, 4, 2})).isTrue();
        assertThat(find132pattern(new int[]{-1, 3, 2, 0})).isTrue();
        assertThat(find132pattern(new int[]{3, 5, 0, 3, 4})).isTrue();
    }

    public boolean find132pattern(int[] nums) {
        int k = nums.length;
        int numK = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < numK)
                return true;
            for (; k < nums.length && nums[i] > nums[k]; k++) {
                numK = nums[k];
            }
            nums[--k] = nums[i];
        }
        return false;
    }
}
