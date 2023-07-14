package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 44 ms Beats 73.27%
 * Memory 56.6 MB Beats 47.21%
 */
public class Q1218LongestArithmeticSubsequenceOfGivenDifference {

    @Test
    public void test() {
        assertThat(longestSubsequence(new int[]{1, 2, 3, 4}, 1)).isEqualTo(4);
        assertThat(longestSubsequence(new int[]{1, 3, 5, 7}, 1)).isEqualTo(1);
        assertThat(longestSubsequence(new int[]{1, 5, 7, 8, 5, 3, 4, 2, 1}, -2)).isEqualTo(4);
    }

    public int longestSubsequence(int[] arr, int difference) {
        Map<Integer, Integer> stepMap = new HashMap<>();
        for (int n : arr) {
            Integer before = stepMap.getOrDefault(n - difference, 0);
            stepMap.put(n, before + 1);
        }
        return stepMap.values().stream().max(Comparator.naturalOrder()).get();
    }

}
