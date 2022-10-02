package shane.leetcode.contest.weekly.w313;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3 {

    @Test
    public void test() {
        assertThat(minimizeXor(25, 72)).isEqualTo(24);
        assertThat(minimizeXor(1, 12)).isEqualTo(3);
        assertThat(minimizeXor(3, 5)).isEqualTo(3);
    }

    public int minimizeXor(int num1, int num2) {
        int bitCount = Integer.bitCount(num2) - Integer.bitCount(num1);

        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num1));
        for (int i = sb.length() - 1; i >= 0 && bitCount > 0; i--) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, '1');
                bitCount--;
            }
        }

        for (int i = sb.length() - 1; i >= 0 && bitCount < 0; i--) {
            if (sb.charAt(i) == '1') {
                sb.setCharAt(i, '0');
                bitCount++;
            }
        }

        while (bitCount > 0) {
            sb.insert(0, '1');
            bitCount--;
        }

        return Integer.valueOf(sb.toString(), 2);
    }

}
