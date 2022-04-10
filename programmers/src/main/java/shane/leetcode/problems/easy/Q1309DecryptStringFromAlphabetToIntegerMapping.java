package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1309DecryptStringFromAlphabetToIntegerMapping {

    @Test
    public void test() {
        assertThat(freqAlphabets("10#11#12")).isEqualTo("jkab");
        assertThat(freqAlphabets("1326#")).isEqualTo("acz");
    }

    public String freqAlphabets(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                sb.append((char) ('a' + (s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') - 1));
                i += 2;
            } else {
                sb.append((char) ('a' + s.charAt(i) - '0' - 1));
            }
        }
        return sb.toString();
    }
}
