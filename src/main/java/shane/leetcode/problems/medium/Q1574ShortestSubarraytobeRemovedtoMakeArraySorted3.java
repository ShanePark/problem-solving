package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 4ms Beats16.67%
 */
public class Q1574ShortestSubarraytobeRemovedtoMakeArraySorted3 {

    @Test
    public void test() {
        assertThat(findLengthOfShortestSubarray(new int[]{10, 13, 17, 21, 15, 15, 9, 17, 22, 22, 13})).isEqualTo(7);
        assertThat(findLengthOfShortestSubarray(new int[]{6, 3, 10, 11, 15, 20, 13, 3, 18, 12})).isEqualTo(8);
        assertThat(findLengthOfShortestSubarray(new int[]{1, 1, 1})).isEqualTo(0);
        assertThat(findLengthOfShortestSubarray(new int[]{1, 2, 3})).isEqualTo(0);
        assertThat(findLengthOfShortestSubarray(new int[]{16, 10, 0, 3, 22, 1, 14, 7, 1, 12, 15})).isEqualTo(8);
        assertThat(findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 0, 7, 8, 9})).isEqualTo(2);
        assertThat(findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 4, 2, 3, 5})).isEqualTo(3);
        assertThat(findLengthOfShortestSubarray(new int[]{1, 2, 2, 2, 2, 2, 3, 1, 7, 5, 1, 2, 2, 2, 2, 2, 2, 5, 6})).isEqualTo(5);
        assertThat(findLengthOfShortestSubarray(new int[]{13, 0, 14, 7, 18, 18, 18, 16, 8, 15, 20})).isEqualTo(8);
        assertThat(findLengthOfShortestSubarray(new int[]{2, 2, 2, 1, 1, 1})).isEqualTo(3);
        assertThat(findLengthOfShortestSubarray(new int[]{5, 4, 3, 2, 1})).isEqualTo(4);
    }

    @Test
    public void tle() {
        int[] arr = new int[1_000_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        assertThat(findLengthOfShortestSubarray(arr)).isEqualTo(0);
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int right = arr.length - 1;
        while (right > 0 && arr[right - 1] <= arr[right]) {
            right--;
        }
        int answer = right;

        for (int left = 0; left < arr.length; left++) {
            int cur = arr[left];
            answer = Math.min(answer, arr.length - left);
            if (0 < left && cur < arr[left - 1])
                break;
            while (arr[right] < cur && right < arr.length - 1) {
                right++;
            }
            while (left < right - 1 && arr[right] < cur && arr[right - 1] <= arr[right]) {
                right--;
            }
            if (right <= left || arr[right] < arr[left])
                continue;
            answer = Math.min(answer, right - left - 1);
        }
        return answer;
    }

}
