package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime4msBeats85.00%
 */
public class Q2696MinimumStringLengthAfterRemovingSubstrings {

    @Test
    public void test() {
        assertThat(minLength("ABFCACDB")).isEqualTo(2);
        assertThat(minLength("ACBBD")).isEqualTo(5);
    }

    public int minLength(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty() || (c != 'B' && c != 'D')) {
                stack.push(c);
                continue;
            }
            if (c == 'B') {
                if (stack.peek() == 'A') {
                    stack.pop();
                    continue;
                }
                stack.push(c);
                continue;
            }
            if (stack.peek() == 'C') {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.size();
    }

}
