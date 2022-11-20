package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Stack idea from Discussion
 * 
 * Runtime 45 ms Beats 21.38%
 * Memory 44.7 MB Beats 36.56%
 */
public class Q224BasicCalculator {

    @Test
    public void test() {
        assertThat(calculate("2147483647")).isEqualTo(2147483647);
        assertThat(calculate("1 + 1")).isEqualTo(2);
        assertThat(calculate(" 2-1 + 2 ")).isEqualTo(3);
        assertThat(calculate("(1+(4+5+2)-3)+(6+8)")).isEqualTo(23);
    }

    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        stack.push(0);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '+':
                    sign = 1;
                    break;
                case '-':
                    sign = -1;
                    break;
                case ('('):
                    stack.push(sign);
                    stack.push(0);
                    sign = 1;
                    break;
                case (')'):
                    int n = stack.pop();
                    int lastSign = stack.pop();
                    int lastNumber = stack.pop();
                    stack.push(n * lastSign + lastNumber);
                    break;
                default:
                    if (isNumber(c)) {
                        int num = c - '0';
                        while (i + 1 < s.length() && isNumber(s.charAt(i + 1))) {
                            num = num * 10 + s.charAt(++i) - '0';
                        }
                        Integer beforeNumber = stack.pop();
                        stack.push(beforeNumber + num * sign);
                    }
            }
        }
        return stack.pop();
    }

    public boolean isNumber(char c) {
        return '0' <= c && c <= '9';
    }

}
