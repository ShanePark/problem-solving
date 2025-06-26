package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 2ms
 * Beats54.26%
 */
public class Q2311LongestBinarySubsequenceLessThanOrEqualToK {

    @Test
    public void test() {
        assertThat(longestSubsequence("00101001", 1)).isEqualTo(6);
        assertThat(longestSubsequence("001010101011010100010101101010010", 93_951_055)).isEqualTo(31);
        assertThat(longestSubsequence("1001010", 5)).isEqualTo(5);
        assertThat(longestSubsequence("0000", 1)).isEqualTo(4);
    }

    @Test
    public void test2() {
        assertThat(longestSubsequence("1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111100000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000", 1))
                .isEqualTo(500);
    }

    public int longestSubsequence(String s, int k) {
        int[] zeroCnt = new int[s.length()];
        if (s.charAt(0) == '0') {
            zeroCnt[0] = 1;
        }
        for (int i = 1; i < s.length(); i++) {
            zeroCnt[i] = zeroCnt[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
        }
        long cur = 0;
        int max = 0;
        int i = s.lastIndexOf('1');
        if (i == -1)
            return s.length();
        int right = i;
        for (; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                cur += (long) Math.pow(2, right - i);
            }
            if (cur > k) {
                break;
            }
            int curLength = right - i + 1 + (i == 0 ? 0 : zeroCnt[i - 1]);
            int zeroCntRight = zeroCnt[s.length() - 1] - zeroCnt[right];
            long tmp = cur;
            while (tmp * 2 <= k && zeroCntRight > 0) {
                tmp *= 2;
                zeroCntRight--;
                curLength++;
            }
            max = Math.max(max, curLength);
        }
        return Math.max(max, s.length() - right - 1);
    }

}
