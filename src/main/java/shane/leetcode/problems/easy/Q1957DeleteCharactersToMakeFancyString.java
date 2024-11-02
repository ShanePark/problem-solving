package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime25msBeats100.00%
 */
public class Q1957DeleteCharactersToMakeFancyString {

    @Test
    public void test() {
        assertThat(makeFancyString("leeetcode")).isEqualTo("leetcode");
        assertThat(makeFancyString("aaabaaaa")).isEqualTo("aabaa");
        assertThat(makeFancyString("aab")).isEqualTo("aab");
    }

    public String makeFancyString(String s) {
        int cnt = 0;
        char before = ' ';
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == before && cnt == 2) {
                continue;
            }
            sb.append(c);
            if (c == before) {
                cnt++;
                continue;
            }
            cnt = 1;
            before = c;
        }
        return sb.toString();
    }

}
