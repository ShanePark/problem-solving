package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 3ms
 * Beats38.21%
 */
public class Q3174ClearDigits {

    @Test
    public void test() {
        assertThat(clearDigits("abc")).isEqualTo("abc");
        assertThat(clearDigits("cb34")).isEqualTo("");
    }

    public String clearDigits(String s) {
        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if ('0' <= c && c <= '9') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }
            stack.push(String.valueOf(c));
        }
        return String.join("", stack);
    }

}
