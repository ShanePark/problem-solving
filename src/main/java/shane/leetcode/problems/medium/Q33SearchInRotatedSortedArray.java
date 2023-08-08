package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 41.3 MB Beats 18.80%
 */
public class Q33SearchInRotatedSortedArray {

    @Test
    public void test() {
        assertThat(search(new int[]{3, 1}, 3)).isEqualTo(0);
        assertThat(search(new int[]{3, 1}, 1)).isEqualTo(1);
        assertThat(search(new int[]{1}, 2)).isEqualTo(-1);
        assertThat(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0)).isEqualTo(4);
        assertThat(search(new int[]{1}, 0)).isEqualTo(-1);
        assertThat(search(new int[]{1, 2, 3, 4, 5}, 3)).isEqualTo(2);
        assertThat(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3)).isEqualTo(-1);
    }

    @Test
    public void findDec() {
        assertThat(findDec(new int[]{3, 1})).isEqualTo(1);
    }

    @Test
    public void getIndexTest() {
        assertThat(getIndex(0, 1, 2)).isEqualTo(1);
        assertThat(getIndex(1, 1, 2)).isEqualTo(0);
        assertThat(getIndex(0, 4, 7)).isEqualTo(4);
        assertThat(getIndex(1, 4, 7)).isEqualTo(5);
        assertThat(getIndex(6, 4, 7)).isEqualTo(3);
    }

    public int search(int[] nums, int target) {
        int decIndex = findDec(nums);
        if (decIndex == -1) {
            int answer = Arrays.binarySearch(nums, target);
            return answer < 0 ? -1 : answer;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int index = getIndex(mid, decIndex, nums.length);
            int value = nums[index];
            if (target == value) {
                left = mid;
                break;
            }
            if (target < value) {
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }
        int index = getIndex(left, decIndex, nums.length);
        return nums[index] == target ? index : -1;
    }

    private int getIndex(int index, int decIndex, int totalLength) {
        return (index + decIndex) % totalLength;
    }

    private int findDec(int[] nums) {
        if (nums[0] < nums[nums.length - 1])
            return -1;
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[right] < nums[mid]) {
                left = mid;
                continue;
            }
            right = mid;
        }
        return left + 1;
    }

}
