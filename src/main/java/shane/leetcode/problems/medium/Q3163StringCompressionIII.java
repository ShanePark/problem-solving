package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime18msBeats66.10%
 */
public class Q3163StringCompressionIII {

    @Test
    public void test() {
        assertThat(compressedString("aaaaaaaaaaaaaabb")).isEqualTo("9a5a2b");
        assertThat(compressedString("abcde")).isEqualTo("1a1b1c1d1e");
    }

    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        char lastChar = ' ';
        int lastCharCnt = 0;
        for (char c : word.toCharArray()) {
            if (lastChar != c) {
                appendChars(sb, lastChar, lastCharCnt);
                lastChar = c;
                lastCharCnt = 1;
                continue;
            }
            lastCharCnt++;
            if (lastCharCnt == 9) {
                appendChars(sb, lastChar, lastCharCnt);
                lastChar = ' ';
                lastCharCnt = 0;
            }
        }
        appendChars(sb, lastChar, lastCharCnt);
        return sb.toString();
    }

    private void appendChars(StringBuilder sb, char lastChar, int lastCharCnt) {
        if (lastCharCnt == 0)
            return;
        sb.append(lastCharCnt);
        sb.append(lastChar);
    }

}
