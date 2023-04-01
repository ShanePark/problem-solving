package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q704BinarySearch2 {

    @Test
    public void test() {
        assertThat(search(new int[]{-1, 0, 3, 5, 9, 12}, 13)).isEqualTo(-1);
        assertThat(search(new int[]{-1, 0, 3, 5, 9, 12}, 9)).isEqualTo(4);
        assertThat(search(new int[]{-1, 0, 3, 5, 9, 12}, 2)).isEqualTo(-1);
        assertThat(search(new int[]{5}, 5)).isEqualTo(0);
        assertThat(search(new int[]{2, 5}, 5)).isEqualTo(1);
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int num = nums[mid];
            if (num < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (nums[left] != target)
            return -1;
        return left;
    }

}
