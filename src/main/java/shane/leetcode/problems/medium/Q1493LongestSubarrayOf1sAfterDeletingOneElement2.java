package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 9 ms Beats 5.53%
 * Memory 53.5 MB Beats 11.97%
 */
public class Q1493LongestSubarrayOf1sAfterDeletingOneElement2 {

    @Test
    void test() {
        assertThat(longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1})).isEqualTo(5);
        assertThat(longestSubarray(new int[]{1, 1, 0})).isEqualTo(2);
        assertThat(longestSubarray(new int[]{1, 1, 1})).isEqualTo(2);
        assertThat(longestSubarray(new int[]{0, 0, 1, 1})).isEqualTo(2);
        assertThat(longestSubarray(new int[]{1, 1, 0, 1})).isEqualTo(3);
    }

    public int longestSubarray(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int max = 0;
        boolean hasZeroInside = false;
        for (int num : nums) {
            if (num == 0) {
                while (hasZeroInside && deque.pollFirst() != 0) {
                    // Poll first until delete 0
                }
                deque.offer(0);
                hasZeroInside = true;
                max = Math.max(max, deque.size() - 1);
                continue;
            }
            deque.offerLast(1);
            max = Math.max(max, deque.size() - 1);
        }
        return max;
    }

}
