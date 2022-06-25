package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q665NondecreasingArray2 {

    @Test
    public void test() {
        assertThat(checkPossibility(new int[]{3, 4, 2, 3})).isFalse();
        assertThat(checkPossibility(new int[]{1, 2, 0})).isTrue();
        assertThat(checkPossibility(new int[]{4, 2, 1})).isFalse();
        assertThat(checkPossibility(new int[]{9, 3, 4, 1})).isFalse();
        assertThat(checkPossibility(new int[]{4, 2, 3})).isTrue();
    }

    public boolean checkPossibility(int[] nums) {
        boolean changed = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                if (changed)
                    return false;
                if (i < 2 || nums[i - 2] <= nums[i]) {
                    nums[i - 1] = nums[i];
                } else {
                    nums[i] = nums[i - 1];
                }
                changed = true;
            }
        }
        return true;
    }

}
