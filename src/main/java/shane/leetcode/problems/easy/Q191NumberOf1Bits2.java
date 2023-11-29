package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 0ms Beats 100.00%of users with Java
 * Memory Details 39.84MB Beats 15.91%of users with Java
 */
public class Q191NumberOf1Bits2 {

    @Test
    public void test() {
        assertThat(hammingWeight(00000000000000000000000000001011)).isEqualTo(3);
        assertThat(hammingWeight(00000000000000000000000010000000)).isEqualTo(1);
        assertThat(hammingWeight(-3)).isEqualTo(31);
    }

    public int hammingWeight(int n) {
        return Integer.bitCount(n);
    }

}
