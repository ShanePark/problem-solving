package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Runtime 9 ms Beats 96.03% of users with Java
 */
public class Q1249MinimumRemoveToMakeValidParentheses2 {

    @Test
    void test() {
        Assertions.assertThat(minRemoveToMakeValid("lee(t(c)o)de)")).isEqualTo("lee(t(c)o)de");
        Assertions.assertThat(minRemoveToMakeValid("a)b(c)d")).isEqualTo("ab(c)d");
        Assertions.assertThat(minRemoveToMakeValid("))((")).isEqualTo("");
    }

    public String minRemoveToMakeValid(String s) {
        int openCnt = 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ')') {
                if (openCnt == 0)
                    continue;
                openCnt--;
            }
            if (c == '(') {
                openCnt++;
            }
            sb.append(c);
        }
        int index = sb.length() - 1;
        while (openCnt != 0) {
            char c = sb.charAt(index);
            if (c == '(') {
                sb.deleteCharAt(index);
                openCnt--;
            }
            index--;
        }
        return sb.toString();
    }

}
