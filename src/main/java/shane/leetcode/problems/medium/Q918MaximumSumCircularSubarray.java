package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q918MaximumSumCircularSubarray {

    @Test
    public void test() {
        assertThat(maxSubarraySumCircular(new int[]{1, -2, 3, -2})).isEqualTo(3);
        assertThat(maxSubarraySumCircular(new int[]{5, -3, 5})).isEqualTo(10);
        assertThat(maxSubarraySumCircular(new int[]{-3, -2, -3})).isEqualTo(-2);
    }

    /**
     * 14 sec 823 ms
     */
    @Test
    public void tle() {
        int[] arr = new int[3 * 10000];
        assertThat(maxSubarraySumCircular(arr));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int max = Integer.MIN_VALUE;
        Queue<int[]> q = new LinkedList<>();
        final int LENGTH = nums.length;
        for (int i = 0; i < LENGTH * 2 - 1; i++) {
            Queue<int[]> next = new LinkedList<>();
            int val = nums[i % LENGTH];
            max = Math.max(max, val);
            next.offer(new int[]{1, val});
            for (int[] subArray : q) {
                int length = subArray[0];
                if (length < LENGTH) {
                    int sum = subArray[1] + val;
                    max = Math.max(max, sum);
                    next.offer(new int[]{length + 1, sum});
                }
            }
            q = next;
        }
        return max;
    }

}
