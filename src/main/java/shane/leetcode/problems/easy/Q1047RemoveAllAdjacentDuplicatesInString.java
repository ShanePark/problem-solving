package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1047RemoveAllAdjacentDuplicatesInString {

    @Test
    public void test() {
        assertThat(removeDuplicates("abbaca")).isEqualTo("ca");
        assertThat(removeDuplicates("azxxzy")).isEqualTo("ay");
    }

    public String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            while (sb.length() >= 2 && sb.charAt(sb.length() - 1) == sb.charAt(sb.length() - 2)) {
                sb.delete(sb.length() - 2, sb.length());
            }
        }
        return sb.toString();
    }

}
