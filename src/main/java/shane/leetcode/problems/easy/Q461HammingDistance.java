package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q461HammingDistance {

    @Test
    public void test() {
        assertThat(hammingDistance(1, 4)).isEqualTo(2);
        assertThat(hammingDistance(3, 1)).isEqualTo(1);
    }

    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}
