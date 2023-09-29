package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 2ms Beats 62.86%of users with Java
 * Memory Details 56.48MB Beats 19.65%of users with Java
 */
public class Q896MonotonicArray {

    @Test
    public void test() {
        assertThat(isMonotonic(new int[]{1, 2, 2, 3})).isTrue();
        assertThat(isMonotonic(new int[]{6, 5, 4, 4})).isTrue();
        assertThat(isMonotonic(new int[]{1, 3, 2})).isFalse();
    }

    public boolean isMonotonic(int[] nums) {
        boolean increase = false;
        boolean decrease = false;
        for (int i = 1; i < nums.length; i++) {
            int before = nums[i - 1];
            int after = nums[i];
            if (before < after) {
                increase = true;
            } else if (after < before) {
                decrease = true;
            }
            if (increase && decrease)
                return false;
        }
        return true;
    }

}
