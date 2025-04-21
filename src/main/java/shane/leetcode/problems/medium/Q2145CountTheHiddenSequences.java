package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 5ms
 * Beats33.33%
 */
public class Q2145CountTheHiddenSequences {

    @Test
    public void test() {
        assertThat(numberOfArrays(new int[]{1, -3, 4}, 1, 6)).isEqualTo(2);
        assertThat(numberOfArrays(new int[]{3, -4, 5, 1, -2}, -4, 5)).isEqualTo(4);
        assertThat(numberOfArrays(new int[]{4, -7, 2}, 3, 6)).isEqualTo(0);

    }

    public int numberOfArrays(int[] differences, int lower, int upper) {
        long min = 0;
        long max = 0;
        long cur = 0;
        for (int d : differences) {
            cur += d;
            max = Math.max(max, cur);
            min = Math.min(min, cur);
        }
        return (int) Math.max(0, (upper - lower) - (max - min) + 1);
    }

}
