package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 39.5 MB Beats 18.28%
 */
public class Q1523CountOddNumbersInAnIntervalRange {

    @Test
    public void test() {
        assertThat(countOdds(3, 7)).isEqualTo(3);
        assertThat(countOdds(3, 6)).isEqualTo(2);
        assertThat(countOdds(8, 10)).isEqualTo(1);
        assertThat(countOdds(0, 1)).isEqualTo(1);
    }

    public int countOdds(int low, int high) {
        return (high + 1) / 2 - (low / 2);
    }
}
