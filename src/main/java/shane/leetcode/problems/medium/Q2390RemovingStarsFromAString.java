package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 42 ms Beats 84.2%
 * Memory 43.3 MB Beats 90.60%
 */
public class Q2390RemovingStarsFromAString {

    @Test
    public void test() {
        assertThat(removeStars("leet**cod*e")).isEqualTo("lecoe");
        assertThat(removeStars("erase*****")).isEqualTo("");
        assertThat(removeStars("erase******")).isEqualTo("");
    }

    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '*') {
                if (0 < sb.length()) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                continue;
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
