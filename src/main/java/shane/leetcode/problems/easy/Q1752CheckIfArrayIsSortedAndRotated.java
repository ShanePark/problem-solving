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
public class Q1752CheckIfArrayIsSortedAndRotated {

    @Test
    public void test() {
        assertThat(check(new int[]{1, 2, 3})).isTrue();
        assertThat(check(new int[]{3, 4, 5, 1, 2})).isTrue();
        assertThat(check(new int[]{2, 1, 3, 4})).isFalse();
    }

    @Test
    public void test2() {
        assertThat(check(new int[]{1})).isTrue();
        assertThat(check(new int[]{1, 3, 2})).isFalse();
        assertThat(check(new int[]{1, 2, 1, 1})).isTrue();
    }

    public boolean check(int[] nums) {
        int start = nums[0];
        int i = 1;
        while (i < nums.length) {
            if (nums[i] < nums[i - 1]) {
                i++;
                break;
            }
            i++;
        }
        if (i == nums.length)
            return nums[i - 1] <= start || nums[i - 2] < nums[i - 1];
        while (i < nums.length) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
            i++;
        }
        return nums[i - 1] <= start;
    }

}
