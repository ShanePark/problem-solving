package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 1ms Beats 76.31%of users with Java
 * Memory Details 39.28MB Beats 83.82%of users with Java
 */
public class Q342PowerOfFour2 {

    @Test
    public void test() {
        assertThat(isPowerOfFour(16)).isEqualTo(true);
        assertThat(isPowerOfFour(5)).isEqualTo(false);
        assertThat(isPowerOfFour(1)).isEqualTo(true);
        assertThat(isPowerOfFour(12)).isEqualTo(false);
        assertThat(isPowerOfFour(0)).isEqualTo(false);
    }

    public boolean isPowerOfFour(int n) {
        while (n > 0) {
            if (n == 1)
                return true;
            if (n % 4 > 0)
                return false;
            n /= 4;
        }
        return false;
    }

}
