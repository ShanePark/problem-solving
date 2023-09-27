package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q880DecodedStringAtIndex {

    @Test
    public void test() {
        assertThat(decodeAtIndex("leet2code3", 10)).isEqualTo("o");
        assertThat(decodeAtIndex("ha22", 5)).isEqualTo("h");
        assertThat(decodeAtIndex("a2345678999999999999999", 1)).isEqualTo("a");
    }

    public String decodeAtIndex(String s, int k) {
        int index;
        long curLength = 0;

        for (index = 0; curLength < k; index++) {
            if (Character.isDigit(s.charAt(index))) {
                int n = s.charAt(index) - '0';
                curLength = curLength * n;
                continue;
            }
            curLength++;
        }

        index--;
        while (0 < index) {
            if (Character.isDigit(s.charAt(index))) {
                int n = s.charAt(index) - '0';
                curLength /= n;
                k %= curLength;
            } else {
                if (k % curLength == 0) {
                    break;
                }
                curLength--;
            }
            index--;
        }

        return s.charAt(index) + "";
    }

}
