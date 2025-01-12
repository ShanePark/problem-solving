package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my own solution
 */
public class Q2116CheckIfAParenthesesStringCanBeValid {

    @Test
    public void test() {
        assertThat(canBeValid("))()))", "010100")).isTrue();
        assertThat(canBeValid("()()", "0000")).isTrue();
        assertThat(canBeValid(")", "0")).isFalse();
    }

    @Test
    public void test2() {
        assertThat(canBeValid("((()", "1101")).isTrue();
        assertThat(canBeValid(")(", "00")).isTrue();
    }

    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1)
            return false;

        Stack<Integer> open = new Stack<>();
        Stack<Integer> free = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (locked.charAt(i) == '0') {
                free.push(i);
                continue;
            }
            if (s.charAt(i) == '(') {
                open.push(i);
                continue;
            }
            if (!open.empty()) {
                open.pop();
                continue;
            }
            if (free.empty()) {
                return false;
            }
            free.pop();
        }

        while (!open.isEmpty()) {
            if (free.isEmpty())
                return false;
            if (free.pop() < open.pop())
                return false;
        }
        return true;
    }

}
