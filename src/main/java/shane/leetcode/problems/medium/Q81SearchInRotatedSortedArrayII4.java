package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * O(logN)
 */
public class Q81SearchInRotatedSortedArrayII4 {

    @Test
    public void test() {
        assertThat(search(new int[]{1, 0, 1, 1, 1}, 0)).isTrue();
        assertThat(search(new int[]{2, 5, 0, 0, 1, 2}, 5)).isTrue();
        assertThat(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0)).isTrue();
        assertThat(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3)).isFalse();
        assertThat(search(new int[]{2, 5, 0, 0, 1, 2}, 3)).isFalse();
        assertThat(search(new int[]{2}, 3)).isFalse();
        assertThat(search(new int[]{3}, 3)).isTrue();
    }

    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int leftValue = nums[left];
            int midValue = nums[mid];
            int rightValue = nums[right];

            if (midValue == target) {
                return true;
            }

            if (leftValue == midValue && midValue == rightValue) {
                left++;
                continue;
            }

            // if between mid and right is sorted
            if (midValue < rightValue || midValue < leftValue) {
                if (target > midValue && target <= rightValue) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                continue;
            }

            // if between left and mid is sorted
            if (target < midValue && target >= leftValue) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

}
