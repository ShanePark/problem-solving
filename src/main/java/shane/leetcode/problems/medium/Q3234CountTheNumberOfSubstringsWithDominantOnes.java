package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3234CountTheNumberOfSubstringsWithDominantOnes {

    @Test
    public void test() {
        assertThat(numberOfSubstrings("00011")).isEqualTo(5);
        assertThat(numberOfSubstrings("101101")).isEqualTo(16);
    }

    public int numberOfSubstrings(String s) {
        final int LENGTH = s.length();
        int[] pre = new int[LENGTH + 1];
        pre[0] = -1;
        for (int i = 0; i < LENGTH; i++) {
            pre[i + 1] = pre[i];
            if (i == 0 || s.charAt(i - 1) == '0') {
                pre[i + 1] = i;
            }
        }
        int answer = 0;
        for (int i = 1; i <= LENGTH; i++) {
            int cnt0 = '1' - s.charAt(i - 1);
            int j = i;
            while (j > 0 && cnt0 * cnt0 <= LENGTH) {
                int cnt1 = i - pre[j] - cnt0;
                if (cnt0 * cnt0 <= cnt1) {
                    answer += Math.min(j - pre[j], cnt1 - cnt0 * cnt0 + 1);
                }
                j = pre[j];
                cnt0++;
            }
        }
        return answer;
    }
}
