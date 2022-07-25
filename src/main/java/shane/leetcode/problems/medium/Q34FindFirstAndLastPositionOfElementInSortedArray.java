package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find First and Last Position of Element in Sorted Array.
 * Memory Usage: 47.7 MB, less than 15.36% of Java online submissions for Find First and Last Position of Element in Sorted Array.
 */
public class Q34FindFirstAndLastPositionOfElementInSortedArray {

    @Test
    public void test() {
        assertThat(searchRange(new int[]{1, 1, 1, 1, 1}, 1)).containsExactly(0, 4);
        assertThat(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)).containsExactly(3, 4);
        assertThat(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)).containsExactly(-1, -1);
        assertThat(searchRange(new int[]{}, 0)).containsExactly(-1, -1);
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0)
            return new int[]{-1, -1};

        int left = 0;
        int right = nums.length - 1;
        int[] answer = new int[2];

        // when can't find return default
        if (nums[left] > target || nums[right] < target)
            return new int[]{-1, -1};

        // find left
        while (left < right) {
            int mid = (left + right) / 2;
            int midVal = nums[mid];
            if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        answer[0] = nums[left] == target ? left : -1;

        left = 0;
        right = nums.length - 1;
        // find right
        while (left < right) {
            int mid = (left + right) / 2;
            if (left == mid) {
                left = nums[right] == target ? right : left;
                break;
            }
            int midVal = nums[mid];
            if (midVal == target) {
                left = mid;
            } else if (midVal < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        answer[1] = nums[left] == target ? left : -1;

        return answer;
    }
}
