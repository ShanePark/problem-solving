package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1910RemoveAllOccurrencesOfASubstring {

    @Test
    public void test() {
        assertThat(removeOccurrences("daabcbaabcbc", "abc")).isEqualTo("dab");
        assertThat(removeOccurrences("axxxxyyyyb", "xy")).isEqualTo("ab");
        assertThat(removeOccurrences("aabababa", "aba")).isEqualTo("ba");
    }

    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() > 0) {
            int i = sb.indexOf(part);
            if (i < 0)
                break;
            sb.delete(i, i + part.length());
        }
        return sb.toString();
    }
}
