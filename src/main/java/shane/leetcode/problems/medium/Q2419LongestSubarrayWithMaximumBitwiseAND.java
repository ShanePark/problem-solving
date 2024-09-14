package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2419LongestSubarrayWithMaximumBitwiseAND {

    @Test
    public void test() {
        assertThat(longestSubarray(new int[]{1, 2, 3, 3, 2, 2})).isEqualTo(2);
        assertThat(longestSubarray(new int[]{1, 2, 3, 4})).isEqualTo(1);
    }

    public int longestSubarray(int[] nums) {
        int max = -1;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int answer = 1;
        int length = 0;
        for (int num : nums) {
            if (num == max) {
                length++;
                answer = Math.max(answer, length);
                continue;
            }
            length = 0;
        }
        return answer;
    }

}
