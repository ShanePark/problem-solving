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
public class Q1523CountOddNumbersInAnIntervalRange2 {

    @Test
    public void test() {
        assertThat(countOdds(3, 7)).isEqualTo(3);
        assertThat(countOdds(8, 10)).isEqualTo(1);
    }

    @Test
    public void test2() {
        assertThat(countOdds(3, 4)).isEqualTo(1);
        assertThat(countOdds(4, 5)).isEqualTo(1);
        assertThat(countOdds(4, 6)).isEqualTo(1);
    }

    public int countOdds(int low, int high) {
        int half = (high - low) / 2;
        if (low % 2 == 1 || high % 2 == 1)
            half++;
        return half;
    }

}
