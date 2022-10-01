package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Runtime: 1 ms, faster than 98.72% of Java online submissions for Decode Ways.
 * Memory Usage: 40.4 MB, less than 97.75% of Java online submissions for Decode Ways.
 */
public class Q91DecodeWays {

    @Test
    public void test() {
        assertThat(numDecodings("12")).isEqualTo(2);
        assertThat(numDecodings("06")).isEqualTo(0);
        assertThat(numDecodings("226")).isEqualTo(3);
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        dp[s.length() - 1] = s.charAt(s.length() - 1) == '0' ? 0 : 1;

        for (int i = s.length() - 2; i >= 0; i--) {
            int first = s.charAt(i) - '0';
            int twoDigit = Integer.valueOf(s.substring(i, i + 2));
            if (0 < first && 1 <= twoDigit && twoDigit <= 26) {
                dp[i] += (i + 2 < s.length()) ? dp[i + 2] : 1;
            }
            if (0 < first) {
                dp[i] += dp[i + 1];
            }
        }
        return dp[0];
    }

}
