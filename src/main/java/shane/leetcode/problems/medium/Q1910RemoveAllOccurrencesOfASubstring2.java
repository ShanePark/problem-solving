package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1ms
 * Beats99.46%
 */
public class Q1910RemoveAllOccurrencesOfASubstring2 {

    @Test
    public void test() {
        assertThat(removeOccurrences("daabcbaabcbc", "abc")).isEqualTo("dab");
        assertThat(removeOccurrences("axxxxyyyyb", "xy")).isEqualTo("ab");
    }

    public String removeOccurrences(String s, String part) {
        while (true) {
            int i = s.indexOf(part);
            if (i < 0)
                return s;
            s = s.substring(0, i) + s.substring(i + part.length());
        }
    }

}
