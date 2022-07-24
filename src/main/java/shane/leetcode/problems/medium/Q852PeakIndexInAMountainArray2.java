package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * O(logN) Runtime: 0 ms, faster than 100.00% of Java online submissions for Peak Index in a Mountain Array.
 */
public class Q852PeakIndexInAMountainArray2 {

    @Test
    public void test() {
        assertThat(peakIndexInMountainArray(new int[]{3, 4, 5, 1})).isEqualTo(2);
        assertThat(peakIndexInMountainArray(new int[]{0, 1, 0})).isEqualTo(1);
        assertThat(peakIndexInMountainArray(new int[]{0, 2, 1, 0})).isEqualTo(1);
        assertThat(peakIndexInMountainArray(new int[]{0, 10, 5, 2})).isEqualTo(1);
    }

    public int peakIndexInMountainArray(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            int midValue = arr[mid];
            if (midValue < arr[mid + 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
