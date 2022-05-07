package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
@SuppressWarnings("ALL")
public class Q456_132Pattern2 {

    @Test
    public void test() {
        assertThat(find132pattern(new int[]{1, 2, 3, 4})).isFalse();
        assertThat(find132pattern(new int[]{3, 1, 4, 2})).isTrue();
        assertThat(find132pattern(new int[]{-1, 3, 2, 0})).isTrue();
        assertThat(find132pattern(new int[]{3, 5, 0, 3, 4})).isTrue();
    }

    public boolean find132pattern(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (min < nums[i]) {
                for (int j = nums.length - 1; j > i; j--) {
                    if (min < nums[j] && nums[j] < nums[i]) {
                        return true;
                    }
                }
            } else {
                min = nums[i];
            }
        }
        return false;
    }
}
