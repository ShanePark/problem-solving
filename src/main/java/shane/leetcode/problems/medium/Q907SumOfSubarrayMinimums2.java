package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * idea from discussion
 * Runtime 121 ms Beats 44.11%
 * Memory 66.3 MB Beats 72.89%
 */
public class Q907SumOfSubarrayMinimums2 {

    @Test
    public void test() {
        assertThat(sumSubarrayMins(new int[]{11, 81, 94, 43, 3})).isEqualTo(444);
        assertThat(sumSubarrayMins(new int[]{3, 1, 2, 4})).isEqualTo(17);
    }

    @Test
    public void test2() {
        assertThat(sumSubarrayMins(new int[30000]));
    }

    public int sumSubarrayMins(int[] arr) {
        final int MOD = (int) 1e9 + 7;
        int[] dp = new int[arr.length + 1];
        int sum = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < arr.length; i++) {
            while (stack.peek() != -1 && arr[i] <= arr[stack.peek()]) {
                stack.pop();
            }
            dp[i + 1] = (dp[stack.peek() + 1] + (i - stack.peek()) * arr[i]) % MOD;
            stack.push(i);
            sum = (sum + dp[i + 1]) % MOD;
        }
        return sum;
    }

}
