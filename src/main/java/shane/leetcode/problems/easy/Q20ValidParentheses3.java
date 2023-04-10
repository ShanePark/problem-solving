package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 79.7%
 * Memory 40.9 MB Beats 15.6%
 */
public class Q20ValidParentheses3 {
    @Test
    public void test() {
        assertThat(isValid("()[]{}")).isTrue();
        assertThat(isValid("()")).isTrue();
        assertThat(isValid("([)]")).isFalse();
    }

    public static boolean isValid(String s) {
        // ( : 40/41 , { : 123/125, [ : 91/93
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 40 || c == 123 || c == 91) {
                stack.push(c);
                continue;
            }
            if (stack.isEmpty())
                return false;
            char pop = stack.pop();
            int diff = Math.abs(c - pop);
            if (diff == 0 || 2 < diff)
                return false;
        }
        return stack.isEmpty();
    }

}
