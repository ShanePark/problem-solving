package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1422MaximumScoreAfterSplittingAString2 {

    @Test
    public void test() {
        assertThat(maxScore("011101")).isEqualTo(5);
        assertThat(maxScore("00111")).isEqualTo(5);
        assertThat(maxScore("1111")).isEqualTo(3);
        assertThat(maxScore("100011")).isEqualTo(5);
    }

    public int maxScore(String s) {
        int zeroCnt = 0;
        int oneCnt = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                zeroCnt++;
            } else {
                oneCnt++;
            }
            max = Math.max(zeroCnt - oneCnt, max);
        }
        if (s.charAt(s.length() - 1) == '1')
            oneCnt++;
        return max + oneCnt;
    }

}
