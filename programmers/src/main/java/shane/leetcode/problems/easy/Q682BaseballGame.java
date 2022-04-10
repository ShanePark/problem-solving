package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Q682BaseballGame {

    @Test
    public void test() {
        assertThat(calPoints(new String[]{"5", "2", "C", "D", "+"})).isEqualTo(30);
        assertThat(calPoints(new String[]{"5", "-2", "4", "C", "D", "9", "+", "+"})).isEqualTo(27);
    }

    public int calPoints(String[] ops) {
        Stack<Integer> stack = new Stack<>();
        for (String op : ops) {
            switch (op) {
                case "C":
                    stack.pop();
                    break;
                case "D":
                    stack.push(stack.peek() * 2);
                    break;
                case "+":
                    Integer pop = stack.pop();
                    Integer peek = stack.peek();
                    stack.push(pop);
                    stack.push(pop + peek);
                    break;
                default:
                    stack.push(Integer.parseInt(op));
                    break;
            }
        }
        return stack.stream().mapToInt(Integer::valueOf).sum();
    }
}
