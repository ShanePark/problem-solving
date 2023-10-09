package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 0ms Beats 100.00%of users with Java
 * Memory Details 44.40MB Beats 54.18%of users with Java
 */
public class Q34FindFirstAndLastPositionOfElementInSortedArray2 {

    @Test
    public void test() {
        assertThat(searchRange(new int[]{1}, 1)).containsExactly(0, 0);
        assertThat(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)).containsExactly(-1, -1);
        assertThat(searchRange(new int[]{1, 1, 1, 1, 1}, 1)).containsExactly(0, 4);
        assertThat(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)).containsExactly(3, 4);
        assertThat(searchRange(new int[]{}, 0)).containsExactly(-1, -1);
    }

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] answer = new int[]{-1, -1};
        if (right < 0 || target < nums[0] || nums[nums.length - 1] < target) {
            return answer;
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
                continue;
            }
            right = mid;
        }

        if (nums[left] != target)
            return answer;

        answer[0] = left;

        left = 0;
        right = nums.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
                continue;
            }
            left = mid;
        }
        answer[1] = left < nums.length - 1 && nums[left + 1] == target ? left + 1 : left;

        return answer;
    }

}
