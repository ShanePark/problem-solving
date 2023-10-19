package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 2ms Beats 62.00%of users with Java
 * Memory Details 41.00MB Beats 16.49%of users with Java
 */
public class Q844BackspaceStringCompare2 {

    @Test
    public void test() {
        assertThat(backspaceCompare("ab#c", "ad#c")).isTrue();
        assertThat(backspaceCompare("ab##", "c#d#")).isTrue();
        assertThat(backspaceCompare("a#c", "b")).isFalse();
    }

    public boolean backspaceCompare(String s, String t) {
        return fun(s).equals(fun(t));
    }

    private String fun(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}
