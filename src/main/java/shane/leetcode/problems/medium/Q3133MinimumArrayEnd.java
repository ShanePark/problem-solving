package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime3msBeats21.43%
 */
public class Q3133MinimumArrayEnd {

    @Test
    public void test() {
        assertThat(minEnd(3, 4)).isEqualTo(6);
        assertThat(minEnd(2, 7)).isEqualTo(15);
    }

    public long minEnd(int n, int x) {
        n--;
        String xBinary = Integer.toBinaryString(x);
        String nBinary = Integer.toBinaryString(n);

        StringBuilder xBinaryReverse = new StringBuilder(xBinary).reverse();
        StringBuilder nBinaryReverse = new StringBuilder(nBinary).reverse();

        int xIndex = 0;
        int nIndex = 0;

        while (nIndex < nBinaryReverse.length()) {
            while (xIndex == xBinaryReverse.length() || xBinaryReverse.charAt(xIndex) == '1') {
                if (xIndex == xBinaryReverse.length()) {
                    xBinaryReverse.append(0);
                    break;
                }
                xIndex++;
            }
            xBinaryReverse.setCharAt(xIndex, nBinaryReverse.charAt(nIndex));
            xIndex++;
            nIndex++;
        }

        String answer = xBinaryReverse.reverse().toString();
        return Long.parseLong(answer, 2);
    }

}
