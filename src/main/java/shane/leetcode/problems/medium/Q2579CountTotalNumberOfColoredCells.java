package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 7ms
 * Beats5.74%
 */
public class Q2579CountTotalNumberOfColoredCells {

    @Test
    public void test() {
        assertThat(coloredCells(1)).isEqualTo(1);
        assertThat(coloredCells(2)).isEqualTo(5);
        assertThat(coloredCells(3)).isEqualTo(13);
        assertThat(coloredCells(4)).isEqualTo(25);
    }


    public long coloredCells(int n) {
        long sum = 1;
        for (long i = 2; i <= n; i++) {
            long mid = (i - 1) * 2 + 1;
            sum += mid * 2 - 2;
        }
        return sum;
    }

}
