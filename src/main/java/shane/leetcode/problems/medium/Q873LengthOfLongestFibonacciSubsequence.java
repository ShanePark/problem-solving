package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
214ms
Beats24.26%
 */
public class Q873LengthOfLongestFibonacciSubsequence {

    @Test
    public void test() {
        assertThat(lenLongestFibSubseq(new int[]{1, 2, 3, 4, 5, 6, 7, 8})).isEqualTo(5);
        assertThat(lenLongestFibSubseq(new int[]{1, 3, 7, 11, 12, 14, 18})).isEqualTo(3);
    }

    public int lenLongestFibSubseq(int[] arr) {
        Set<Integer> nums = new HashSet<>();
        for (int i : arr) {
            nums.add(i);
        }
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int first = arr[i];
                int second = arr[j];
                maxLength = Math.max(maxLength, calcLength(first, second, 2, nums));
            }
        }
        return maxLength;
    }

    private int calcLength(int first, int second, int curLength, Set<Integer> nums) {
        if (!nums.contains(first + second)) {
            return curLength < 3 ? 0 : curLength;
        }
        return calcLength(second, first + second, curLength + 1, nums);
    }

}
