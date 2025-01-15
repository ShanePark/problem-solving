package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1ms
 * Beats15.09%
 */
public class Q2429MinimizeXOR {

    @Test
    public void test() {
        assertThat(minimizeXor(346, 6654)).isEqualTo(1023);
        assertThat(minimizeXor(65, 84)).isEqualTo(67);
        assertThat(minimizeXor(25, 72)).isEqualTo(24);
        assertThat(minimizeXor(3, 5)).isEqualTo(3);
        assertThat(minimizeXor(3, 1)).isEqualTo(2);
        assertThat(minimizeXor(1, 12)).isEqualTo(3);
    }

    public int minimizeXor(int num1, int num2) {
        int cnt1 = Integer.bitCount(num1);
        int cnt2 = Integer.bitCount(num2);
        if (cnt1 == cnt2)
            return num1;
        if (cnt1 < cnt2)
            return replaceAndAddLeft(num1, cnt1, cnt2);
        return replaceRight(num1, cnt1, cnt2);
    }

    private int replaceRight(int num, int cnt1, int cnt2) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(num));
        int diff = cnt1 - cnt2;
        for (int i = sb.length() - 1; i >= 0 && diff > 0; i--) {
            if (sb.charAt(i) == '1') {
                sb.setCharAt(i, '0');
                diff--;
            }
        }
        return Integer.valueOf(sb.toString(), 2);
    }

    private int replaceAndAddLeft(int num, int cnt1, int cnt2) {
        String binary = Integer.toBinaryString(num);
        int diff = cnt2 - cnt1;
        StringBuilder sb = new StringBuilder(binary);
        for (int i = sb.length() - 1; i >= 0 && diff > 0; i--) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, '1');
                diff--;
            }
        }
        for (int i = 0; i < diff; i++) {
            sb.insert(0, '1');
        }
        return Integer.valueOf(sb.toString(), 2);
    }

}

