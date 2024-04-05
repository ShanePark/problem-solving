package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3 ms Beats 61.07% of users with Java
 */
public class Q1544MakeTheStringGreat2 {

    @Test
    public void test() {
        assertThat(makeGood("leEeetcode")).isEqualTo("leetcode");
        assertThat(makeGood("abBAcC")).isEqualTo("");
        assertThat(makeGood("s")).isEqualTo("s");
    }

    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                continue;
            }
            char last = stack.peek();
            if (Math.abs(last - c) == 32) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }

}
