package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 20 ms Beats 8.89% of users with Java
 */
public class Q150EvaluateReversePolishNotation2 {

    @Test
    public void test() {
        assertThat(evalRPN(new String[]{"2", "1", "+", "3", "*"})).isEqualTo(9);
        assertThat(evalRPN(new String[]{"4", "13", "5", "/", "+"})).isEqualTo(6);
        assertThat(evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"})).isEqualTo(22);
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            try {
                int num = Integer.parseInt(token);
                stack.push(num);
            } catch (NumberFormatException e) {
                Integer n2 = stack.pop();
                Integer n1 = stack.pop();
                int res;
                switch (token) {
                    case "+":
                        res = n1 + n2;
                        break;
                    case "-":
                        res = n1 - n2;
                        break;
                    case "*":
                        res = n1 * n2;
                        break;
                    case "/":
                        res = n1 / n2;
                        break;
                    default:
                        throw new IllegalStateException();

                }
                stack.push(res);
            }
        }
        return stack.peek();
    }

}
