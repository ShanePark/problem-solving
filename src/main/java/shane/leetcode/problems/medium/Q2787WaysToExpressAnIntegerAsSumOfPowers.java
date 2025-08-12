package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q2787WaysToExpressAnIntegerAsSumOfPowers {

    @Test
    public void test() {
        assertThat(numberOfWays(10, 2)).isEqualTo(1);
        assertThat(numberOfWays(4, 1)).isEqualTo(2);
    }

    @Test
    public void tle() {
        assertThat(numberOfWays(300, 1)).isEqualTo(872_471_266);
        assertThat(numberOfWays(126, 1)).isEqualTo(3_457_027);
    }

    public int numberOfWays(int n, int x) {
        return numberOfWays(n, x, 1);
    }

    private int numberOfWays(int n, int x, int index) {
        if (n == 0)
            return 1;
        if (n < 0)
            return 0;
        int pow = 1;
        for (int i = 0; i < x; i++) {
            pow *= index;
        }
        if (n < pow)
            return 0;
        return numberOfWays(n, x, index + 1) + numberOfWays(n - pow, x, index + 1);
    }

}
