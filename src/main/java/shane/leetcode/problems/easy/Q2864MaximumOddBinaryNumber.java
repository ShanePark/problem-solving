package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 83.47% of users with Java
 */
public class Q2864MaximumOddBinaryNumber {

    @Test
    public void test() {
        assertThat(maximumOddBinaryNumber("010")).isEqualTo("001");
        assertThat(maximumOddBinaryNumber("0101")).isEqualTo("1001");
    }

    public String maximumOddBinaryNumber(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                cnt++;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < cnt - 1; i++) {
            result.append("1");
        }
        for (int i = 0; i < s.length() - cnt; i++) {
            result.append("0");
        }
        result.append("1");
        return result.toString();
    }

}
