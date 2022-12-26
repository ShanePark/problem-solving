package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 92.42%
 * Memory 42.8 MB Beats 85.72%
 */
public class Q55JumpGame4 {

    @Test
    public void test() {
        assertThat(canJump(new int[]{2, 3, 1, 1, 4})).isTrue();
        assertThat(canJump(new int[]{3, 2, 1, 0, 4})).isFalse();
        assertThat(canJump(new int[]{0})).isTrue();
    }

    @Test
    public void tle() {
        int[] arr = new int[10000];
        Arrays.fill(arr, 100000);
        assertThat(canJump(arr)).isTrue();
    }

    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i <= max; i++) {
            max = Math.max(max, i + nums[i]);
            if (max >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }

}
