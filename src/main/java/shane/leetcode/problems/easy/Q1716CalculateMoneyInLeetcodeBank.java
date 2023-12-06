package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 1ms Beats 60.95%of users with Java
 * Memory Details 39.29MB Beats 43.33%of users with Java
 */
public class Q1716CalculateMoneyInLeetcodeBank {

    @Test
    public void test() {
        assertThat(totalMoney(4)).isEqualTo(10);
        assertThat(totalMoney(10)).isEqualTo(37);
        assertThat(totalMoney(20)).isEqualTo(96);
    }

    public int totalMoney(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += i % 7 + 1;
            sum += i / 7;
        }
        return sum;
    }

}
