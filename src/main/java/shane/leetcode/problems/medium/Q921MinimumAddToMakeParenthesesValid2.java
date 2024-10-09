package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime0msBeats100.00%
 */
public class Q921MinimumAddToMakeParenthesesValid2 {

    @Test
    public void test() {
        assertThat(minAddToMakeValid("())")).isEqualTo(1);
        assertThat(minAddToMakeValid("(((")).isEqualTo(3);
    }

    public int minAddToMakeValid(String s) {
        int open = 0;
        int answer = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
                continue;
            }
            if (open == 0) {
                answer++;
                continue;
            }
            open--;
        }
        return answer + open;
    }

}
