package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q678ValidParenthesisString {

    @Test
    public void test() {
        assertThat(checkValidString("()")).isTrue();
        assertThat(checkValidString("(*)")).isTrue();
        assertThat(checkValidString("(*))")).isTrue();
        assertThat(checkValidString("(*(")).isFalse();
        assertThat(checkValidString("()(*")).isTrue();
        assertThat(checkValidString("**))")).isTrue();
        assertThat(checkValidString("(*()")).isTrue();
        assertThat(checkValidString("***)))")).isTrue();
        assertThat(checkValidString("(**)")).isTrue();
        assertThat(checkValidString("()()")).isTrue();
        assertThat(checkValidString("(())")).isTrue();
    }

    public boolean checkValidString(String s) {
        final int LENGTH = s.length();
        int open = 0;
        int close = 0;

        for (int left = 0; left < LENGTH; left++) {
            char c = s.charAt(left);
            if (c == '(' || c == '*') {
                open++;
            } else {
                open--;
            }

            char c2 = s.charAt(LENGTH - left - 1);
            if (c2 == ')' || c2 == '*') {
                close++;
            } else {
                close--;
            }

            if (open < 0 || close < 0) {
                return false;
            }
        }
        return true;
    }

}
