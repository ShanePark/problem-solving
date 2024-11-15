package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1574ShortestSubarraytobeRemovedtoMakeArraySorted {

    @Test
    public void test() {
        assertThat(findLengthOfShortestSubarray(new int[]{1, 2, 3, 10, 4, 2, 3, 5})).isEqualTo(3);
        assertThat(findLengthOfShortestSubarray(new int[]{5, 4, 3, 2, 1})).isEqualTo(4);
        assertThat(findLengthOfShortestSubarray(new int[]{1, 2, 3})).isEqualTo(0);
    }

    @Test
    public void tle() {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        assertThat(findLengthOfShortestSubarray(arr)).isEqualTo(arr.length);
    }

    public int findLengthOfShortestSubarray(int[] arr) {
        int maxlength = 1;

        List<SortedArray> left = new ArrayList<>();
        int start = arr[0];
        int before = start;
        left.add(new SortedArray(start, start, 1));

        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            if (cur < before)
                break;
            before = cur;
            left.add(new SortedArray(start, cur, i + 1));
            maxlength = Math.max(maxlength, i + 1);
        }

        List<SortedArray> right = new ArrayList<>();
        int end = arr[arr.length - 1];
        int after = end;
        right.add(new SortedArray(end, end, 1));
        for (int i = arr.length - 2; i >= 0; i--) {
            int cur = arr[i];
            if (after < cur) {
                break;
            }
            after = cur;
            right.add(new SortedArray(after, end, arr.length - i));
            maxlength = Math.max(maxlength, arr.length - i);
        }

        for (SortedArray l : left) {
            for (SortedArray r : right) {
                int lengthSum = l.length + r.length;
                if (lengthSum >= arr.length)
                    continue;
                if (l.endVal <= r.startVal) {
                    maxlength = Math.max(maxlength, lengthSum);
                }
            }
        }
        return arr.length - maxlength;
    }

    static class SortedArray {
        final int startVal;
        final int endVal;
        final int length;


        SortedArray(int startVal, int endVal, int length) {
            this.startVal = startVal;
            this.endVal = endVal;
            this.length = length;
        }

        @Override
        public String toString() {
            return "SortedArray{" +
                    "startVal=" + startVal +
                    ", endVal=" + endVal +
                    ", length=" + length +
                    '}';
        }
    }

}
