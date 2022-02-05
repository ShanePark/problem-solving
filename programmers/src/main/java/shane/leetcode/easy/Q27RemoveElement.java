package shane.leetcode.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class Q27RemoveElement {

    @Test
    void test() {
        int[] nums = {3, 2, 2, 3};
        Assertions.assertThat(removeElement(nums, 3)).isEqualTo(2);
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));

        int[] nums1 = {0, 1, 2, 2, 3, 0, 4, 2};
        Assertions.assertThat(removeElement(nums1, 2)).isEqualTo(5);
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums1));
        Assertions.assertThat(removeElement(new int[]{}, 5)).isEqualTo(0);
    }

    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int num : nums) {
            if (num != val) {
                nums[i++] = num;
            }
        }
        return i;
    }

}
