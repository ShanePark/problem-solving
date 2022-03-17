package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q856ScoreOfParentheses {

    @Test
    void test() {
        Assertions.assertThat(scoreOfParentheses("()")).isEqualTo(1);
        Assertions.assertThat(scoreOfParentheses("(())")).isEqualTo(2);
        Assertions.assertThat(scoreOfParentheses("()()")).isEqualTo(2);
        Assertions.assertThat(scoreOfParentheses("((()))")).isEqualTo(4);
        Assertions.assertThat(scoreOfParentheses("(()(()))")).isEqualTo(6);
    }

    public int scoreOfParentheses(String s) {
        if (s.length() == 2)
            return 1;
        List<String> parentheses = new ArrayList<>();
        int cnt = 0;
        int startIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ('(')) {
                cnt++;
            } else {
                cnt--;
            }
            if (cnt == 0) {
                parentheses.add(s.substring(startIndex, i + 1));
                startIndex = i + 1;
                cnt = 0;
            }
        }
        if (parentheses.size() > 1) {
            return parentheses.stream().mapToInt(this::scoreOfParentheses).sum();
        } else {
            return 2 * scoreOfParentheses(s.substring(1, s.length() - 1));
        }
    }

}
