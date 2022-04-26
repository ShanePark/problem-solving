package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q80RemoveDuplicatesfromSortedArrayII {

    @Test
    void test() {
        int[] arr = {1, 1, 1, 2, 2, 3};
        Assertions.assertThat(removeDuplicates(arr)).isEqualTo(5);
        Assertions.assertThat(arr).containsSubsequence(new int[]{1, 1, 2, 2, 3});

        arr = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        Assertions.assertThat(removeDuplicates(arr)).isEqualTo(7);
        Assertions.assertThat(arr).containsSubsequence(new int[]{0, 0, 1, 1, 2, 3, 3});
    }

    public int removeDuplicates(int[] nums) {
        int cnt = 2;
        for (int i = 2; i < nums.length; i++) {
            if (nums[cnt - 2] != nums[i]) {
                nums[cnt++] = nums[i];
            }
        }
        return cnt;
    }

}
