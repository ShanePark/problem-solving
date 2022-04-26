package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1021RemoveOutermostParentheses {

    @Test
    public void test() {
        assertThat(removeOuterParentheses("(()())(())")).isEqualTo("()()()");
        assertThat(removeOuterParentheses("(()())(())(()(()))")).isEqualTo("()()()()(())");
        assertThat(removeOuterParentheses("()()")).isEqualTo("");
    }

    public String removeOuterParentheses(String s) {
        List<String> list = new ArrayList<>();
        int left = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    list.add(s.substring(left, i + 1));
                    left = i + 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str, 1, str.length() - 1);
        }

        return sb.toString();
    }
}
