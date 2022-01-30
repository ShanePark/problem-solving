package shane.leetcode.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q189RotateArray {

    @Test
    void teast() {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 3);
        Assertions.assertThat(nums).containsExactly(5, 6, 7, 1, 2, 3, 4);
        nums = new int[]{-1, -100, 3, 99};
        rotate(nums, 2);
        Assertions.assertThat(nums).containsExactly(3, 99, -1, -100);
        nums = new int[]{1, 2};
        rotate(nums, 3);
        Assertions.assertThat(nums).containsExactly(2, 1);
    }

    public void rotate(int[] nums, int k) {
        int[] temp = Arrays.copyOf(nums, nums.length);
        if (k > nums.length) {
            k %= nums.length;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[(nums.length - k + i) % nums.length];
        }
    }

}
