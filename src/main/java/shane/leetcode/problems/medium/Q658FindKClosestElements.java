package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * can't pass first test case
 */
public class Q658FindKClosestElements {

    @Test
    public void test() {
//        assertThat(findClosestElements(new int[]{0, 1, 1, 1, 2, 3, 6, 7, 8, 9}, 9, 4)).containsExactly(0, 1, 1, 1, 2, 3, 6, 7, 8);
        assertThat(findClosestElements(new int[]{1, 1, 1, 10, 10, 10}, 1, 9)).containsExactly(10);
        assertThat(findClosestElements(new int[]{1, 2, 4, 5, 6}, 1, 3)).containsExactly(2);
        assertThat(findClosestElements(new int[]{1, 2, 4, 5, 6}, 2, 3)).containsExactly(2, 4);
        assertThat(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3)).containsExactly(1, 2, 3, 4);
        assertThat(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, -1)).containsExactly(1, 2, 3, 4);
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int min = arr[0];
        int max = arr[arr.length - 1];
        int left;
        int right;
        if (x <= min) {
            left = 0;
            right = k - 1;
        } else if (x >= max) {
            left = arr.length - k;
            right = arr.length;
        } else {
            // find number index which is same or smaller x
            left = Arrays.binarySearch(arr, x);
            if (left < 0) {
                int valLeft = arr[-left - 2];
                int valRight = arr[-left - 1];
                left = (Math.abs(valLeft - x) <= Math.abs(valRight - x)) ? -left - 2 : -left - 1;
                right = k > 1 ? left + 1 : left;
            } else {
                right = left;
            }

            int half = (k - 1) / 2;
            left = Math.max(0, left - half);
            right = Math.min(right + half, arr.length - 1);

            if (right - left + 1 < k) {
                int gap = k - (right - left + 1);
                if (left > 0) {
                    left = left - gap;
                } else {
                    right = right + gap;
                }
            }
        }

        return Arrays.stream(Arrays.copyOfRange(arr, left, right + 1)).boxed().collect(Collectors.toList());
    }

}
