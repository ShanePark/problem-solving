package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1717MaximumScoreFromRemovingSubstrings {

    @Test
    public void test() {
        assertThat(maximumGain("aabbrtababbabmaaaeaabeawmvaataabnaabbaaaybbbaabbabbbjpjaabbtabbxaaavsmmnblbbabaeuasvababjbbabbabbasxbbtgbrbbajeabbbfbarbagha",
                8484, 4096)).isEqualTo(198644);
        assertThat(maximumGain("cdbcbbaaabab", 4, 5)).isEqualTo(19);
        assertThat(maximumGain("aabbaaxybbaabb", 4, 5)).isEqualTo(20);
    }

    /**
     * 250 ms
     */
    @Test
    public void tle() {
        String str = "ab".repeat(100000);
        assertThat(maximumGain(str, 2890, 1643)).isEqualTo(289000000);
    }

    public int maximumGain(String s, int x, int y) {
        StringBuilder sb = new StringBuilder(s);
        int score = 0;
        if (y > x) {
            score += replaceAll(sb, "ba") * y;
            score += replaceAll(sb, "ab") * x;
        } else {
            score += replaceAll(sb, "ab") * x;
            score += replaceAll(sb, "ba") * y;
        }

        s = sb.toString();
        if (s.contains("ab") || s.contains("ba")) {
            return score + maximumGain(s, x, y);
        }
        return score;
    }

    private int replaceAll(StringBuilder sb, String str) {
        int count = 0;
        while (sb.indexOf(str) >= 0) {
            int index = sb.indexOf(str);
            sb.replace(index, index + 2, "");
            count++;
        }
        return count;
    }

}
