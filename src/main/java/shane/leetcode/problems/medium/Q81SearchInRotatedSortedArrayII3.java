package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details -ms Beats 100.00%
 * Memory Details 42.68mb Beats 96.66%
 */
public class Q81SearchInRotatedSortedArrayII3 {

    @Test
    public void test() {
        assertThat(search(new int[]{1, 0, 1, 1, 1}, 0)).isTrue();
        assertThat(search(new int[]{2, 5, 0, 0, 1, 2}, 5)).isTrue();
        assertThat(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0)).isTrue();
        assertThat(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3)).isFalse();
        assertThat(search(new int[]{2, 5, 0, 0, 1, 2}, 3)).isFalse();
        assertThat(search(new int[]{2}, 3)).isFalse();
        assertThat(search(new int[]{3}, 3)).isTrue();
    }

    public boolean search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target)
                return true;
        }
        return false;
    }

}
