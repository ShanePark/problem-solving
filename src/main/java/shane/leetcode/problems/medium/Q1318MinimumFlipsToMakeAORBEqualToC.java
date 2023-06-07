package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 8.50%
 * Memory 39.2 MB Beats 88.89%
 */
public class Q1318MinimumFlipsToMakeAORBEqualToC {

    @Test
    public void test() {
        assertThat(minFlips(2, 6, 5)).isEqualTo(3);
        assertThat(minFlips(4, 2, 7)).isEqualTo(1);
    }

    public int minFlips(int a, int b, int c) {
        int cnt = 0;
        String aStr = binaryStr(a);
        String bStr = binaryStr(b);
        String cStr = binaryStr(c);
        for (int i = 0; i < 31; i++) {
            boolean aChar = aStr.charAt(i) == '1';
            boolean bChar = bStr.charAt(i) == '1';
            boolean cChar = cStr.charAt(i) == '1';
            if (cChar && !aChar && !bChar) {
                cnt++;
            }
            if (!cChar) {
                if (aChar)
                    cnt++;
                if (bChar)
                    cnt++;
            }
        }
        return cnt;
    }

    private String binaryStr(int n) {
        String binary = Integer.toBinaryString(n);
        StringBuilder zeros = new StringBuilder();
        int pad = 31 - binary.length();
        for (int i = 0; i < pad; i++) {
            zeros.append("0");
        }
        return zeros + binary;
    }

}
