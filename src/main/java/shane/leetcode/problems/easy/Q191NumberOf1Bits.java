package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q191NumberOf1Bits {

    @Test
    public void test() {
        assertThat(hammingWeight(00000000000000000000000000001011)).isEqualTo(3);
        assertThat(hammingWeight(00000000000000000000000010000000)).isEqualTo(1);
//        assertThat(hammingWeight(11111111111111111111111111111101)).isEqualTo(31);
    }

    public int hammingWeight(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt += (n & 1);
            n >>>= 1;
        }
        return cnt;
    }

    public int hammingWeight1(int n) {
        return Integer.bitCount(n);
    }
}
