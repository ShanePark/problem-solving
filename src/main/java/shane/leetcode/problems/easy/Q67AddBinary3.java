package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 61.76%
 * Memory 42.4 MB Beats 44.24%
 */
public class Q67AddBinary3 {

    @Test
    public void test() {
        assertThat(addBinary("11", "1")).isEqualTo("100");
        assertThat(addBinary("0", "0")).isEqualTo("0");
        assertThat(addBinary("1010", "1011")).isEqualTo("10101");
    }

    public String addBinary(String a, String b) {
        StringBuilder padding = new StringBuilder();
        int lengthDiff = Math.abs(a.length() - b.length());
        for (int i = 0; i < lengthDiff; i++) {
            padding.append("0");
        }
        if (a.length() > b.length()) {
            b = padding + b;
        } else {
            a = padding + a;
        }
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = a.length() - 1; i >= 0; i--) {
            sum += a.charAt(i) - '0';
            sum += b.charAt(i) - '0';
            sb.insert(0, sum % 2);
            sum /= 2;
        }
        if (sum == 1)
            sb.insert(0, 1);
        return sb.toString();
    }

}
