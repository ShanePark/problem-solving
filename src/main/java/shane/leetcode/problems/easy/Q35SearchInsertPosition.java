package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 42 MB Beats 50.67%
 */
public class Q35SearchInsertPosition {

    @Test
    public void test() {
        assertThat(searchInsert(new int[]{1, 3, 5, 6}, 7)).isEqualTo(4);
        assertThat(searchInsert(new int[]{2, 7, 8, 9, 10}, 9)).isEqualTo(3);
        assertThat(searchInsert(new int[]{1, 3, 5, 6}, 5)).isEqualTo(2);
        assertThat(searchInsert(new int[]{1, 3, 5, 6}, 2)).isEqualTo(1);
    }

    public int searchInsert(int[] nums, int target) {
        int result = Arrays.binarySearch(nums, target);
        return result < 0 ? -result - 1 : result;
    }

}
