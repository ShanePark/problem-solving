package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 37ms Beats7.14%
 */
public class Q1574ShortestSubarraytobeRemovedtoMakeArraySorted2 {

    @Test
    public void test() {
        assertThat(findLengthOfShortestSubarray(new int[]{16, 10, 0, 3, 22, 1, 14, 7, 1, 12, 15})).isEqualTo(8);
        assertThat(findLengthOfShortestSubarray(new int[]{1, 2, 2, 2, 2, 2, 3, 1, 7, 5, 1, 2, 2, 2, 2, 2, 2, 5, 6})).isEqualTo(5);
        assertThat(findLengthOfShortestSubarray(new int[]{13, 0, 14, 7, 18, 18, 18, 16, 8, 15, 20})).isEqualTo(8);
        assertThat(findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 0, 7, 8, 9})).isEqualTo(2);
        assertThat(findLengthOfShortestSubarray(new int[]{2, 2, 2, 1, 1, 1})).isEqualTo(3);
        assertThat(findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 4, 2, 3, 5})).isEqualTo(3);
        assertThat(findLengthOfShortestSubarray(new int[]{5, 4, 3, 2, 1})).isEqualTo(4);
        assertThat(findLengthOfShortestSubarray(new int[]{1, 2, 3})).isEqualTo(0);
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
        int before = -1;
        int max = 0;
        TreeMap<Integer, Integer> left = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < before)
                break;
            before = arr[i];
            left.put(before, i + 1);
            max = i + 1;
        }

        int leftMaxlength = max;
        int after = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i >= leftMaxlength; i--) {
            int cur = arr[i];
            if (after < cur) {
                break;
            }
            after = cur;
            int rightLength = arr.length - i;
            max = Math.max(max, rightLength);
            Map.Entry<Integer, Integer> ceil = left.floorEntry(cur);
            if (ceil == null)
                continue;
            max = Math.max(max, ceil.getValue() + rightLength);
        }
        return arr.length - max;
    }

}
