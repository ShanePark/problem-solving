package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1844ReplaceAllDigitsWithCharacters {
    @Test
    public void test() {
        assertThat(replaceDigits("a1c1e1")).isEqualTo("abcdef");
        assertThat(replaceDigits("a1b2c3d4e")).isEqualTo("abbdcfdhe");
    }

    public String replaceDigits(String s) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < s.length() - 1; i += 2) {
            sb.append(s.charAt(i));
            sb.append((char) (s.charAt(i) + s.charAt(i + 1) - '0'));
        }
        return sb.toString() + ((s.length() % 2 == 0) ? "" : s.charAt(sb.length()));
    }
}
