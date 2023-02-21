package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 41.5 MB Beats 93.24%
 */
public class Q35SearchInsertPosition2 {

    @Test
    public void test() {
        assertThat(searchInsert(new int[]{2, 7, 8, 9, 10}, 9)).isEqualTo(3);
        assertThat(searchInsert(new int[]{1, 3, 5, 6}, 7)).isEqualTo(4);
        assertThat(searchInsert(new int[]{1, 3}, 4)).isEqualTo(2);
        assertThat(searchInsert(new int[]{1, 3, 5, 6}, 5)).isEqualTo(2);
        assertThat(searchInsert(new int[]{1, 3, 5, 6}, 2)).isEqualTo(1);
    }

    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target <= nums[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return (left < nums.length && nums[left] < target) ? left + 1 : left;
    }

}
