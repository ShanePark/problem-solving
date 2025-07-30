package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 3ms
 * Beats82.57%
 */
public class Q2419LongestSubarrayWithMaximumBitwiseAND2 {

    @Test
    public void test() {
        assertThat(longestSubarray(new int[]{1, 2, 3, 3, 2, 2})).isEqualTo(2);
        assertThat(longestSubarray(new int[]{1, 2, 3, 4})).isEqualTo(1);
        assertThat(longestSubarray(new int[]{311155, 311155, 311155, 311155, 311155, 311155, 311155, 311155, 201191, 311155})).isEqualTo(8);
    }

    public int longestSubarray(int[] nums) {
        int max = -1;
        int length = 0;
        int answer = 1;
        for (int num : nums) {
            if (num < max) {
                length = 0;
                continue;
            }
            if (num == max) {
                answer = Math.max(answer, ++length);
                continue;
            }
            max = num;
            length = 1;
            answer = 1;
        }
        return answer;
    }

}
