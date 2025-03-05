package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 0ms
 * Beats100.00%
 */
public class Q2579CountTotalNumberOfColoredCells2 {

    @Test
    public void test() {
        assertThat(coloredCells(1)).isEqualTo(1);
        assertThat(coloredCells(2)).isEqualTo(5);
        assertThat(coloredCells(3)).isEqualTo(13);
        assertThat(coloredCells(4)).isEqualTo(25);
    }


    public long coloredCells(int n) {
        return (long) n * (n - 1) * 2 + 1;
    }

}
