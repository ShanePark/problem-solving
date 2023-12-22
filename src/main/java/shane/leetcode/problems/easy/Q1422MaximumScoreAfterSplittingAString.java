package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 1ms Beats 97.78%of users with Java
 * Memory Details 41.21MB Beats 33.33%of users with Java
 */
public class Q1422MaximumScoreAfterSplittingAString {

    @Test
    public void test() {
        assertThat(maxScore("011101")).isEqualTo(5);
        assertThat(maxScore("00111")).isEqualTo(5);
        assertThat(maxScore("1111")).isEqualTo(3);
    }

    public int maxScore(String s) {
        int[] oneCountFromRight = new int[s.length()];
        int cnt = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                cnt++;
            }
            oneCountFromRight[i] = cnt;
        }

        int zeroCnt = 0;
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeroCnt++;
            }
            int score = zeroCnt + oneCountFromRight[i + 1];
            max = Math.max(max, score);
        }
        return max;
    }

}
