package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Runtime Details 0ms Beats 100.00%of users with Java
 * Memory Details 41.60MB Beats 11.16%of users with Java
 */
public class Q91DecodeWays2 {

    @Test
    public void test() {
        assertThat(numDecodings("10011")).isEqualTo(0);
        assertThat(numDecodings("2101")).isEqualTo(1);
        assertThat(numDecodings("10")).isEqualTo(1);
        assertThat(numDecodings("12")).isEqualTo(2);
        assertThat(numDecodings("06")).isEqualTo(0);
        assertThat(numDecodings("226")).isEqualTo(3);
    }

    public int numDecodings(String s) {
        final int LENGTH = s.length();
        int[] dp = new int[LENGTH];
        if (s.charAt(0) == '0')
            return 0;
        dp[0] = 1;
        for (int i = 1; i < LENGTH; i++) {
            int cur = s.charAt(i) - '0';
            if (cur == 0 && (s.charAt(i - 1) - '0' > 2 || s.charAt(i - 1) - '0' == 0)) {
                return 0;
            }

            // 1. cut from before
            if (cur != 0 && s.charAt(i - 1) != '0') {
                dp[i] = dp[i - 1];
            }

            // 2. attach to previous number
            int twoDigit = (s.charAt(i - 1) - '0') * 10 + cur;
            if (twoDigit > 26 || ((i < LENGTH - 1) && s.charAt(i + 1) == '0'))
                continue;
            dp[i] += i < 2 ? 1 : dp[i - 2];
        }
        return dp[LENGTH - 1];
    }

}
