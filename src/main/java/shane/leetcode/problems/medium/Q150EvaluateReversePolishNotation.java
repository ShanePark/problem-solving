package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 5 ms Beats 96.91%
 * Memory 42.1 MB Beats 88.63%
 */
public class Q150EvaluateReversePolishNotation {

    @Test
    public void test() {
        assertThat(evalRPN(new String[]{"4", "3", "-"})).isEqualTo(1);
        assertThat(evalRPN(new String[]{"3", "11", "+", "5", "-"})).isEqualTo(9);
        assertThat(evalRPN(new String[]{"18"})).isEqualTo(18);
        assertThat(evalRPN(new String[]{"2", "1", "+", "3", "*"})).isEqualTo(9);
        assertThat(evalRPN(new String[]{"4", "13", "5", "/", "+"})).isEqualTo(6);
        assertThat(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"})).isEqualTo(22);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    stack.push(-stack.pop() + stack.pop());
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    Integer last = stack.pop();
                    stack.push(stack.pop() / last);

                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

}
