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
public class Q3370SmallestNumberWithAllSetBits {

    @Test
    public void test() {
        assertThat(smallestNumber(5)).isEqualTo(7);
        assertThat(smallestNumber(10)).isEqualTo(15);
        assertThat(smallestNumber(3)).isEqualTo(3);
        assertThat(smallestNumber(8)).isEqualTo(15);
        assertThat(smallestNumber(1)).isEqualTo(1);
    }

    public int smallestNumber(int n) {
        int i = 1;
        while (i <= n) {
            i *= 2;
        }
        return i - 1;
    }

}
