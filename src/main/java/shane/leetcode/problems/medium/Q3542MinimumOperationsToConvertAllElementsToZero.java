package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3542MinimumOperationsToConvertAllElementsToZero {

    @Test
    public void test() {
        assertThat(minOperations(new int[]{0, 2})).isEqualTo(1);
        assertThat(minOperations(new int[]{3, 1, 2, 1})).isEqualTo(3);
        assertThat(minOperations(new int[]{1, 2, 1, 2, 1, 2})).isEqualTo(4);
    }

    public int minOperations(int[] nums) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }
            if (num == 0)
                continue;
            if (stack.isEmpty() || stack.peek() < num) {
                answer++;
                stack.push(num);
            }
        }
        return answer;
    }

}
