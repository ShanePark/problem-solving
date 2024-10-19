package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime0msBeats100.00%
 */
public class Q1545FindKthBitInNthBinaryString {

    @Test
    public void test() {
        assertThat(findKthBit(4, 11)).isEqualTo('1');
        assertThat(findKthBit(3, 1)).isEqualTo('0');
        assertThat(findKthBit(2, 3)).isEqualTo('1');
    }

    public char findKthBit(int n, int k) {
        if (n == 1)
            return '0';
        int length = (int) Math.pow(2, n) - 1;
        if (k <= length / 2) {
            return findKthBit(n - 1, k);
        }
        if (k == length / 2 + 1) {
            return '1';
        }
        int invertIndex = length - k + 1;
        return reverse(findKthBit(n - 1, invertIndex));
    }

    private char reverse(char kthBit) {
        return kthBit == '0' ? '1' : '0';
    }

}
