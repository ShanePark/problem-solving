package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 73.26%
 * Memory 48.3 MB Beats 8.95%
 */
public class Q26RemoveDuplicatesFromSortedArray {

    @Test
    public void test() {
        int[] nums = {1, 1, 2};
        assertThat(removeDuplicates(nums)).isEqualTo(2);
        assertThat(nums[0]).isEqualTo(1);
        assertThat(nums[1]).isEqualTo(2);

        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        assertThat(removeDuplicates(nums)).isEqualTo(5);
        assertThat(nums[0]).isEqualTo(0);
        assertThat(nums[1]).isEqualTo(1);
        assertThat(nums[2]).isEqualTo(2);
        assertThat(nums[3]).isEqualTo(3);
        assertThat(nums[4]).isEqualTo(4);

    }

    public int removeDuplicates(int[] nums) {
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[left]) {
                nums[++left] = nums[i];
            }
        }
        return left + 1;
    }

}
