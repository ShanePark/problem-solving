package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q81SearchInRotatedSortedArrayII {

    @Test
    public void test() {
        assertThat(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0)).isTrue();
        assertThat(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 3)).isFalse();
        assertThat(search(new int[]{1}, 0)).isFalse();
        assertThat(search(new int[]{3, 1}, 1)).isTrue();
    }

    public boolean search(int[] nums, int target) {
        int left = 0;
        while (left < nums.length - 1 && nums[left] <= nums[left + 1]) {
            if (nums[left] == target) {
                return true;
            }
            left++;
        }
        if (nums[left++] == target) {
            return true;
        }

        // binary search
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return (left < nums.length && nums[left] == target);
    }

}
