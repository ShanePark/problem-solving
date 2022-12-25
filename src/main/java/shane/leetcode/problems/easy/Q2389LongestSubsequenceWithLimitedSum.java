package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 15 ms Beats 47.75%
 * Memory 42.8 MB Beats 92.57%
 */
public class Q2389LongestSubsequenceWithLimitedSum {

    @Test
    public void test() {
        assertThat(answerQueries(new int[]{736411, 184882, 914641, 37925, 214915}, new int[]{331244, 273144, 118983, 118252, 305688, 718089, 665450}))
                .containsExactly(2, 2, 1, 1, 2, 3, 3);
        assertThat(answerQueries(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21})).containsExactly(2, 3, 4);
        assertThat(answerQueries(new int[]{2, 3, 4, 5}, new int[]{1})).containsExactly(0);
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        int[] minValues = new int[nums.length + 1];
        Arrays.fill(minValues, Integer.MAX_VALUE);
        minValues[0] = 0;

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            for (int j = i + 1; j >= 1; j--) {
                minValues[j] = Math.min(minValues[j], minValues[j - 1] + cur);
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            answer[i] = binarySearch(minValues, query);
        }
        return answer;
    }

    private int binarySearch(int[] minValues, int query) {
        int left = 0;
        int right = minValues.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            int val = minValues[mid];
            if (val <= query) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }

}
