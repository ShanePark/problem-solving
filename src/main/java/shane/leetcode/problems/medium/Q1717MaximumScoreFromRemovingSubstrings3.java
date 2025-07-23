package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 84ms
 * Beats57.53%
 */
public class Q1717MaximumScoreFromRemovingSubstrings3 {

    @Test
    public void test() {
        assertThat(maximumGain("cdbcbbaaabab", 4, 5)).isEqualTo(19);
        assertThat(maximumGain("aabbaaxybbaabb", 4, 5)).isEqualTo(20);
    }

    public int maximumGain(String s, int x, int y) {
        if (!s.contains("ab") && !s.contains("ba"))
            return 0;
        int score = 0;
        if (x > y) {
            String replace = replace(s, "ab");
            score += (s.length() - replace.length()) / 2 * x;
            s = replace;

            replace = replace(s, "ba");
            score += (s.length() - replace.length()) / 2 * y;
            s = replace;
        } else {
            String replace = replace(s, "ba");
            score += (s.length() - replace.length()) / 2 * y;
            s = replace;

            replace = replace(s, "ab");
            score += (s.length() - replace.length()) / 2 * x;
            s = replace;
        }
        return score + maximumGain(s, x, y);
    }

    private String replace(String s, String target) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            sb.append(c);
            if (sb.length() == 1)
                continue;
            if (sb.charAt(sb.length() - 2) == target.charAt(0) && sb.charAt(sb.length() - 1) == target.charAt(1)) {
                sb.deleteCharAt(sb.length() - 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

}
