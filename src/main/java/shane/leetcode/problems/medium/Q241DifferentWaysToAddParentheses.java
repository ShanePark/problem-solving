package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q241DifferentWaysToAddParentheses {

    @Test
    public void test() {
        assertThat(diffWaysToCompute("2-1-1")).containsExactlyInAnyOrder(0, 2);
        assertThat(diffWaysToCompute("2*3-4*5")).containsExactlyInAnyOrder(-34, -14, -10, -10, 10);
    }

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if ('0' <= c && c <= '9') {
                continue;
            }
            List<Integer> left = diffWaysToCompute(expression.substring(0, i));
            List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
            for (int l : left) {
                for (int r : right) {
                    answer.add(calc(l, r, c));
                }
            }
        }
        if (answer.isEmpty()) {
            return List.of(Integer.parseInt(expression));
        }
        return answer;
    }

    private Integer calc(int a, int b, char op) {
        switch (op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            default:
                throw new IllegalArgumentException();
        }
    }

}
