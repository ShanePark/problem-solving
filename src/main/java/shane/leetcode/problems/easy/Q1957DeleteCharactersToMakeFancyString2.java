package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
23ms
Beats98.23%

 */
public class Q1957DeleteCharactersToMakeFancyString2 {

    @Test
    public void test() {
        assertThat(makeFancyString("leeetcode")).isEqualTo("leetcode");
        assertThat(makeFancyString("aaabaaaa")).isEqualTo("aabaa");
        assertThat(makeFancyString("aab")).isEqualTo("aab");
    }

    public String makeFancyString(String s) {
        int cnt = 0;
        char last = ' ';
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == last) {
                if (cnt == 2)
                    continue;
                cnt++;
                sb.append(c);
                continue;
            }
            last = c;
            cnt = 1;
            sb.append(c);
        }
        return sb.toString();
    }

}
