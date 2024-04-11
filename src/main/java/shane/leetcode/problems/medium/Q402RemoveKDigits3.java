package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Stack;

@SuppressWarnings("ALL")
public class Q402RemoveKDigits3 {

    @Test
    void test() {
        Assertions.assertThat(removeKdigits("1432219", 3)).isEqualTo("1219");
        Assertions.assertThat(removeKdigits("10200", 1)).isEqualTo("200");
        Assertions.assertThat(removeKdigits("10", 2)).isEqualTo("0");
    }

    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack();
        for (int i = 0; i < num.length(); i++) {
            while (!stack.isEmpty() && k > 0 && num.charAt(i) < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }

        for (int i = 0; i < k; i++) {
            stack.pop();
        }

        StringBuffer sb = new StringBuffer();
        for (Character c : stack) {
            sb.append(c);
        }

        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == '0') {
                sb.deleteCharAt(i--);
                continue;
            }
            break;
        }

        if (sb.length() == 0)
            return "0";

        return sb.toString();
    }

}
