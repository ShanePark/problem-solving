package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 0
 * ms
 * Beats
 * 100.00%
 */
public class Q342PowerOfFour3 {

    @Test
    public void test() {
        assertThat(isPowerOfFour(16)).isEqualTo(true);
        assertThat(isPowerOfFour(5)).isEqualTo(false);
        assertThat(isPowerOfFour(1)).isEqualTo(true);
    }

    public boolean isPowerOfFour(int n) {
        if (n == 1)
            return true;
        if (n <= 0 || n % 4 > 0)
            return false;
        return isPowerOfFour(n / 4);
    }

}
