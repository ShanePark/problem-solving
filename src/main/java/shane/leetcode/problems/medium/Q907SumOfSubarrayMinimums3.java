package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Q907SumOfSubarrayMinimums3 {

    @Test
    public void test() {
        assertThat(sumSubarrayMins(new int[]{3, 1, 2, 4})).isEqualTo(17);
        assertThat(sumSubarrayMins(new int[]{11, 81, 94, 43, 3})).isEqualTo(444);
    }

    final int MOD = (int) 1e9 + 7;

    public int sumSubarrayMins(int[] arr) {
        int[] dp = new int[arr.length + 1];
        int sum = 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        for (int i = 0; i < arr.length; i++) {
            clearStack(arr, stack, arr[i]);
            int minIndex = stack.peek();
            dp[i + 1] = (dp[minIndex + 1] + (i - minIndex) * arr[i]) % MOD;
            sum = (sum + dp[i + 1]) % MOD;

            stack.push(i);
        }
        return sum;
    }

    private void clearStack(int[] arr, Stack<Integer> stack, int curValue) {
        while (stack.peek() != -1 && curValue < arr[stack.peek()]) {
            stack.pop();
        }
    }

}
