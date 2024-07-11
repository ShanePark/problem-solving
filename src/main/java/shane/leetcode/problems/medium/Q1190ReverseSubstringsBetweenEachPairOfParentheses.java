package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime2msBeats70.03%
 */
public class Q1190ReverseSubstringsBetweenEachPairOfParentheses {

    @Test
    public void test() {
        assertThat(reverseParentheses("sxmdll(q)eki(x)")).isEqualTo("sxmdllqekix");
        assertThat(reverseParentheses("(abcd)")).isEqualTo("dcba");
        assertThat(reverseParentheses("(u(love)i)")).isEqualTo("iloveu");
        assertThat(reverseParentheses("(ed(et(oc))el)")).isEqualTo("leetcode");
    }

    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        StringBuilder reverse = new StringBuilder();
        int open = 0;
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                open++;
                reverse.append(c);
                continue;
            }
            if (c == ')') {
                open--;
                reverse.append(c);
                if (open == 0) {
                    sb.append(reverse(reverse));
                    reverse = new StringBuilder();
                }
                continue;
            }
            if (open > 0) {
                reverse.append(c);
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }

    private String reverse(StringBuilder target) {
        StringBuilder sb = new StringBuilder();
        int length = target.length();
        for (int i = 1; i < length - 1; i++) {
            char c = target.charAt(length - i - 1);
            if (c == '(') {
                c = ')';
            } else if (c == ')') {
                c = '(';
            }
            sb.append(c);
        }
        return reverseParentheses(sb.toString());
    }

}
