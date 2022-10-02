package shane.leetcode.contest.weekly.w313;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1 {

    @Test
    public void test() {
        assertThat(commonFactors(12, 6)).isEqualTo(4);
        assertThat(commonFactors(25, 30)).isEqualTo(2);
    }

    public int commonFactors(int a, int b) {
        int min = Math.min(a, b);
        int cnt = 0;
        for (int i = 1; i <= min; i++) {
            if (a % i == 0 && b % i == 0) {
                cnt++;
            }
        }
        return cnt;
    }

}
