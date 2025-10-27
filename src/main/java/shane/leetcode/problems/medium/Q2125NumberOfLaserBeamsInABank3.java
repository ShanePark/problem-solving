package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Runtime
 * 8
 * ms
 * Beats
 * 97.05%
 */
public class Q2125NumberOfLaserBeamsInABank3 {

    @Test
    void test() {
        Assertions.assertThat(numberOfBeams(new String[]{"011001", "000000", "010100", "001000"})).isEqualTo(8);
        Assertions.assertThat(numberOfBeams(new String[]{"000", "111", "000"})).isEqualTo(0);
    }

    public int numberOfBeams(String[] bank) {
        int cntBefore = 0;
        int answer = 0;
        for (String s : bank) {
            int cnt = 0;
            for (char c : s.toCharArray()) {
                cnt += c - '0';
            }
            if (cnt == 0)
                continue;
            answer += cntBefore * cnt;
            cntBefore = cnt;
        }
        return answer;
    }

}
