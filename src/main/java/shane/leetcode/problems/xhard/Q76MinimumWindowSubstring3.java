package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 96 ms Beats 15.24% of users with Java
 */
public class Q76MinimumWindowSubstring3 {

    @Test
    public void test() {
        assertThat(minWindow("cabwefgewcwaefgcf", "cae")).isEqualTo("cwae");
        assertThat(minWindow("ADOBECODEBANC", "ABC")).isEqualTo("BANC");
        assertThat(minWindow("a", "a")).isEqualTo("a");
        assertThat(minWindow("a", "aa")).isEqualTo("");
        assertThat(minWindow("ABCD", "ACD")).isEqualTo("ABCD");
        assertThat(minWindow("ABCD", "ACD")).isEqualTo("ABCD");
        assertThat(minWindow("AAAA", "AA")).isEqualTo("AA");
    }

    public String minWindow(String s, String t) {
        int left = 0;
        int right = 0;
        String answer = "";
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : t.toCharArray()) {
            cnt.merge(c, -1, Integer::sum);
        }

        StringBuilder cur = new StringBuilder();
        while (right < s.length()) {
            char c = s.charAt(right);
            cur.append(c);
            int val = cnt.merge(c, 1, Integer::sum);
            if (val == 0 && isValid(cnt)) {
                // When it's valid, move left
                while (true) {
                    if (answer.isEmpty() || cur.length() < answer.length()) {
                        answer = cur.toString();
                    }
                    cur.deleteCharAt(0);
                    Integer after = cnt.merge(s.charAt(left++), -1, Integer::sum);
                    if (after < 0)
                        break;
                }
            }
            right++;
        }

        return answer;
    }

    private boolean isValid(Map<Character, Integer> cnt) {
        for (Integer value : cnt.values()) {
            if (value < 0)
                return false;
        }
        return true;
    }

}
