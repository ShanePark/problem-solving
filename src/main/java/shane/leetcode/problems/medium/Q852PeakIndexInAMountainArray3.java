package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 56.7 MB Beats 28.92%
 */
public class Q852PeakIndexInAMountainArray3 {

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
            int mid = left + (right - left) / 2;
            int v1 = arr[mid];
            int v2 = arr[mid + 1];
            if (v1 < v2) {
                left = mid + 1;
                continue;
            }
            right = mid;
        }
        return left;
    }

}
