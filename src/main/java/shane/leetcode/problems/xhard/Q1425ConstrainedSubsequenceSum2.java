package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q1425ConstrainedSubsequenceSum2 {

    @Test
    public void test() {
        assertThat(constrainedSubsetSum(new int[]{10, 2, -10, 5, 20}, 2)).isEqualTo(37);
        assertThat(constrainedSubsetSum(new int[]{-1, -2, -3}, 1)).isEqualTo(-1);
        assertThat(constrainedSubsetSum(new int[]{10, -2, -10, -5, 20}, 2)).isEqualTo(23);
    }

    @Test
    public void tle() {
        int[] arr = new int[(int) 1e5];
        assertThat(constrainedSubsetSum(arr, (int) 1e4)).isEqualTo(0);
    }

    public int constrainedSubsetSum(int[] nums, int k) {
        int max = nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            dp[i] = nums[i];
            if (!deque.isEmpty()) {
                dp[i] += dp[deque.peekFirst()];
            }
            max = Math.max(max, dp[i]);

            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            if (dp[i] > 0) {
                deque.offerLast(i);
            }
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
        }
        return max;
    }

}
