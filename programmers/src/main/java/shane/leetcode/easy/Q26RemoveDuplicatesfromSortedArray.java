package shane.leetcode.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q26RemoveDuplicatesfromSortedArray {

    @Test
    void test() {
        Assertions.assertThat(removeDuplicates(new int[]{1, 1, 2})).isEqualTo(2);
        Assertions.assertThat(removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4})).isEqualTo(5);
        Assertions.assertThat(removeDuplicates(new int[]{0})).isEqualTo(1);
        Assertions.assertThat(removeDuplicates(new int[]{})).isEqualTo(0);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int cnt = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[cnt++] = nums[i];
                nums[cnt] = nums[i + 1];
            }
        }
        return cnt + 1;
    }
}
