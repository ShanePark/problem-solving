package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 9ms Beats 14.58%of users with Java
 * Memory Details 41.02MB Beats 59.91%of users with Java
 */
public class Q2264Largest3SameDigitNumberInString {

    @Test
    public void test() {
        assertThat(largestGoodInteger("6777133339")).isEqualTo("777");
        assertThat(largestGoodInteger("2300019")).isEqualTo("000");
        assertThat(largestGoodInteger("42352338")).isEqualTo("");
    }

    public String largestGoodInteger(String num) {
        int max = -1;
        char before = ' ';
        int cnt = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (c == before) {
                cnt++;
                if (cnt == 2) {
                    max = Math.max(max, c - '0');
                }
                continue;
            }
            before = c;
            cnt = 0;
        }
        if (max < 0)
            return "";
        return String.valueOf(max) + max + max;
    }

}
