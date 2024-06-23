package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime169msBeats7.83%
 */
public class Q1438LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    @Test
    public void test() {
        assertThat(longestSubarray(new int[]{8, 2, 4, 7}, 4)).isEqualTo(2);
        assertThat(longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5)).isEqualTo(4);
        assertThat(longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0)).isEqualTo(3);
    }

    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Integer> inc = new PriorityQueue<>();
        PriorityQueue<Integer> dec = new PriorityQueue<>(Comparator.reverseOrder());
        int max = 1;
        inc.offer(nums[0]);
        dec.offer(nums[0]);
        int left = 0;
        for (int i = 1; i < nums.length; i++) {
            inc.offer(nums[i]);
            dec.offer(nums[i]);
            while (dec.peek() - inc.peek() > limit) {
                dec.remove(nums[left]);
                inc.remove(nums[left]);
                left++;
            }
            max = Math.max(max, dec.size());
        }
        return max;
    }

}
