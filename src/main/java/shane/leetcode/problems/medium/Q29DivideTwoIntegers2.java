package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TLE
 */
public class Q29DivideTwoIntegers2 {

    @Test
    void test() {
        Assertions.assertThat(divide(10, 3)).isEqualTo(3);
        Assertions.assertThat(divide(7, -3)).isEqualTo(-2);
        Assertions.assertThat(divide(-2147483648, 1)).isEqualTo(-2147483648);
        Assertions.assertThat(divide(2147483647, 1)).isEqualTo(2147483647);
        Assertions.assertThat(divide(2147483647, 2)).isEqualTo(1073741823);
        Assertions.assertThat(divide(-2147483648, 2)).isEqualTo(-1073741824);
        Assertions.assertThat(divide(-1010369383, -2147483648)).isEqualTo(0);
        Assertions.assertThat(divide(-2147483648, 4)).isEqualTo(-536870912);
        Assertions.assertThat(divide(-2147483648, -1)).isEqualTo(2147483647);
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int absDividend = Math.abs(dividend);
        int absDivisor = Math.abs(divisor);
        int result = 0;

        for (int i = 31; i >= 0; i--) {
            if ((absDividend >>> i) - absDivisor >= 0) {
                result += 1 << i;
                absDividend -= absDivisor << i;
            }
        }
        return (dividend > 0 == divisor > 0) ? result : -result;
    }
}
