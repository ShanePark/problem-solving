package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * TLE
 */
public class Q29DivideTwoIntegers {

    @Test
    void test() {
        Assertions.assertThat(divide(10, 3)).isEqualTo(3);
        Assertions.assertThat(divide(7, -3)).isEqualTo(-2);
        Assertions.assertThat(divide(-2147483648, -1)).isEqualTo(2147483647);
        Assertions.assertThat(divide(-2147483648, 1)).isEqualTo(-2147483648);
        Assertions.assertThat(divide(2147483647, 1)).isEqualTo(2147483647);
        Assertions.assertThat(divide(2147483647, 2)).isEqualTo(1073741823);
        Assertions.assertThat(divide(-2147483648, 2)).isEqualTo(-1073741824);
        Assertions.assertThat(divide(-1010369383, -2147483648)).isEqualTo(0);
        Assertions.assertThat(divide(-2147483648, 4)).isEqualTo(-536870912);
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && Math.abs(divisor) == 1) {
            return divisor == -1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else if (dividend == Integer.MAX_VALUE && Math.abs(divisor) == 1) {
            return divisor * Integer.MAX_VALUE;
        }
        boolean minus = false;
        long dividendL = dividend;
        long divisorL = divisor;
        if (dividendL < 0) {
            dividendL = -dividendL;
            minus = true;
        }
        if (divisorL < 0) {
            divisorL = -divisorL;
            minus = !minus;
        }
        int i = -1;
        while (divisorL * (++i + 1) <= dividendL) {
        }

        return minus ? -i : i;

    }
}
