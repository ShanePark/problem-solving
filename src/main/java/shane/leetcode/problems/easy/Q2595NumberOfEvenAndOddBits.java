package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 51.6%
 * Memory 42.6 MB Beats 46.50%
 */
public class Q2595NumberOfEvenAndOddBits {

    @Test
    void test() {
        assertThat(evenOddBit(17)).containsExactly(2, 0);
        assertThat(evenOddBit(2)).containsExactly(0, 1);
    }

    public int[] evenOddBit(int n) {
        String binary = Integer.toBinaryString(n);
        int[] answer = new int[2];
        int length = binary.length();
        for (int i = 0; i < length; i++) {
            if (binary.charAt(length - 1 - i) == '1') {
                answer[i % 2]++;
            }
        }
        return answer;
    }
}
