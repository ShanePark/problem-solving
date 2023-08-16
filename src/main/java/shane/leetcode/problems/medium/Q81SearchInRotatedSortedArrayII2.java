package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * O(NlogN)
 */
public class Q81SearchInRotatedSortedArrayII2 {

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
        Arrays.sort(nums);
        return Arrays.binarySearch(nums, target) >= 0;
    }

}
