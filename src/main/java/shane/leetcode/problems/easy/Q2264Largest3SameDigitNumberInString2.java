package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
7ms
Beats27.54%
 */
public class Q2264Largest3SameDigitNumberInString2 {

    @Test
    public void test() {
        assertThat(largestGoodInteger("6777133339")).isEqualTo("777");
        assertThat(largestGoodInteger("2300019")).isEqualTo("000");
        assertThat(largestGoodInteger("42352338")).isEqualTo("");
    }

    public String largestGoodInteger(String num) {
        int max = -1;
        int before = -1;
        int length = 0;
        for (char c : num.toCharArray()) {
            int n = c - '0';
            if (before == n) {
                length++;
                if (length == 3 && max < n) {
                    max = n;
                }
                continue;
            }
            before = n;
            length = 1;
        }
        if (max < 0)
            return "";
        return String.valueOf(max) + max + max;
    }

}
