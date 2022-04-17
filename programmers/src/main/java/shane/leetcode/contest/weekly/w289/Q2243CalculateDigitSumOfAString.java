package shane.leetcode.contest.weekly.w289;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2243CalculateDigitSumOfAString {

    @Test
    public void test() {
        assertThat(digitSum("11111222223", 3)).isEqualTo("135");
        assertThat(digitSum("00000000", 3)).isEqualTo("000");
        assertThat(digitSum("999999999", 3)).isEqualTo("36");
        assertThat(digitSum("1234", 2)).isEqualTo("37");
    }

    public String digitSum(String s, int k) {
        if (s.length() <= k) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += k) {
            int n = 0;
            for (int j = 0; j < k && i + j < s.length(); j++) {
                if (i < s.length()) {
                    n += s.charAt(i + j) - '0';
                }
            }
            sb.append(n);
        }
        return digitSum(sb.toString(), k);
    }
}
