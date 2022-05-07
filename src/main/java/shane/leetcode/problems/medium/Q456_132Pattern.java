package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q456_132Pattern {

    @Test
    public void test() {
        assertThat(find132pattern(new int[]{1, 2, 3, 4})).isFalse();
        assertThat(find132pattern(new int[]{3, 1, 4, 2})).isTrue();
        assertThat(find132pattern(new int[]{-1, 3, 2, 0})).isTrue();
        assertThat(find132pattern(new int[]{3, 5, 0, 3, 4})).isTrue();
    }

    public boolean find132pattern(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] < nums[j]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[i] < nums[k] && nums[k] < nums[j]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
