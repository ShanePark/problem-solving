package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2220MinimumBitFlipsToConvertNumber {

    @Test
    public void test() {
        assertThat(minBitFlips(10, 7)).isEqualTo(3);
        assertThat(minBitFlips(3, 4)).isEqualTo(3);
    }

    public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }
}
