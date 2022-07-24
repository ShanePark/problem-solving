package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * O(N)
 */
public class Q852PeakIndexInAMountainArray {

    @Test
    public void test() {
        assertThat(peakIndexInMountainArray(new int[]{0, 1, 0})).isEqualTo(1);
        assertThat(peakIndexInMountainArray(new int[]{0, 2, 1, 0})).isEqualTo(1);
        assertThat(peakIndexInMountainArray(new int[]{0, 10, 5, 2})).isEqualTo(1);
    }

    public int peakIndexInMountainArray(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return i;
            }
        }
        return arr.length - 1;
    }
}
