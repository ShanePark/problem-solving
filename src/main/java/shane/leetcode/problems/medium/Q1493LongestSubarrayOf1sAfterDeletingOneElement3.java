package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 10
 * ms
 * Beats
 * 5.33%
 */
public class Q1493LongestSubarrayOf1sAfterDeletingOneElement3 {

    @Test
    void test() {
        assertThat(longestSubarray(new int[]{1, 1, 0, 1})).isEqualTo(3);
        assertThat(longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1})).isEqualTo(5);
        assertThat(longestSubarray(new int[]{1, 1, 1})).isEqualTo(2);
    }

    @Test
    public void test2() {
        assertThat(longestSubarray(new int[]{1, 0, 0, 0, 0})).isEqualTo(1);
    }

    public int longestSubarray(int[] nums) {
        Queue<Integer> zeroIndex = new LinkedList<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroIndex.offer(i);
                if (zeroIndex.size() == 3)
                    zeroIndex.poll();
            }
            int lastZero = zeroIndex.size() < 2 ? -1 : zeroIndex.peek();
            max = Math.max(max, i - lastZero - 1);
        }
        return max;
    }

}
