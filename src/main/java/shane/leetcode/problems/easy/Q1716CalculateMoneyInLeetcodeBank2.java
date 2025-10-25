package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 2
 * ms
 * Beats
 * 17.17%
 */
public class Q1716CalculateMoneyInLeetcodeBank2 {

    @Test
    public void test() {
        assertThat(totalMoney(4)).isEqualTo(10);
        assertThat(totalMoney(10)).isEqualTo(37);
        assertThat(totalMoney(20)).isEqualTo(96);
    }

    public int totalMoney(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += ((i - 1) % 7) + 1 + (i - 1) / 7;
        }
        return sum;
    }

}
