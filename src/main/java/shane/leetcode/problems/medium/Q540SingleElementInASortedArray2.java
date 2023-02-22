package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 47.9 MB Beats 93.20%
 */
public class Q540SingleElementInASortedArray2 {

    @Test
    public void test() {
        assertThat(singleNonDuplicate(new int[]{1})).isEqualTo(1);
        assertThat(singleNonDuplicate(new int[]{1, 1, 2})).isEqualTo(2);
        assertThat(singleNonDuplicate(new int[]{1, 1, 2, 3, 3, 4, 4, 8, 8})).isEqualTo(2);
        assertThat(singleNonDuplicate(new int[]{3, 3, 7, 7, 10, 11, 11})).isEqualTo(10);
    }

    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            int midFirst = mid % 2 == 0 ? mid : mid - 1;
            if (nums[midFirst] != nums[midFirst + 1]) {
                right = midFirst;
            } else {
                left = mid + 1;
            }
        }
        return nums[left];
    }

}
