package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime1msBeats97.36%
 */
public class Q1422MaximumScoreAfterSplittingAString3 {

    @Test
    public void test() {
        assertThat(maxScore("011101")).isEqualTo(5);
        assertThat(maxScore("00111")).isEqualTo(5);
        assertThat(maxScore("1111")).isEqualTo(3);
    }

    public int maxScore(String s) {
        final int LENGTH = s.length();
        int[] oneCnt = new int[LENGTH];
        oneCnt[0] += s.charAt(0) - '0';
        for (int i = 1; i < LENGTH; i++) {
            oneCnt[i] = oneCnt[i - 1] + s.charAt(i) - '0';
        }
        int max = 0;
        for (int i = 1; i < LENGTH; i++) {
            int zeroCntLeft = i - oneCnt[i - 1];
            int oneCntRight = oneCnt[LENGTH - 1] - oneCnt[i - 1];
            max = Math.max(max, zeroCntLeft + oneCntRight);
        }
        return max;
    }

}
