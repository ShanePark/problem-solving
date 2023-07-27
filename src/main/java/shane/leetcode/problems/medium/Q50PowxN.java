package shane.leetcode.problems.medium;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 40.9 MB Beats 40.10%
 */
public class Q50PowxN {

    @Test
    public void test() {
        assertThat(myPow(2.00000, 10)).isEqualTo(1024.00000);
        assertThat(myPow(2.10000, 3)).isCloseTo(9.26100, Offset.offset(0.0001));
        assertThat(myPow(2.00000, -2)).isEqualTo(0.25);
        assertThat(myPow(2.00000, -2147483648)).isEqualTo(0);
    }

    public double myPow(double x, int n) {
        if (n == 0)
            return 1;
        long pow = n;
        if (n < 0) {
            x = 1 / x;
            pow *= -1;
        }

        double answer = 1;
        double cur = x;

        while (pow >= 1) {
            if (pow % 2 == 1) {
                answer *= cur;
            }
            cur *= cur;
            pow /= 2;
        }

        return answer;
    }

}
