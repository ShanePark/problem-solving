package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q921MinimumAddToMakeParenthesesValid {

    @Test
    public void test() {
        assertThat(minAddToMakeValid("())")).isEqualTo(1);
        assertThat(minAddToMakeValid("(((")).isEqualTo(3);
        assertThat(minAddToMakeValid(")))(((")).isEqualTo(6);
        assertThat(minAddToMakeValid(")((")).isEqualTo(3);
    }

    public int minAddToMakeValid(String s) {
        int cnt = 0;
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else if (s.charAt(i) == ')') {
                if (cnt == 0) {
                    total++;
                } else {
                    cnt--;
                }
            }
        }
        return cnt + total;
    }
}
