package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Runtime: 35 ms, faster than 84.64% of Java online submissions for Longest Palindromic Substring.
 * Memory Usage: 42 MB, less than 97.37% of Java online submissions for Longest Palindromic Substring.
 */
public class Q5LongestPalindromeString4 {

    @Test
    public void test() {
        assertThat(longestPalindrome("ccc")).isEqualTo("ccc");
        assertThat(longestPalindrome("babad").length()).isEqualTo(3);
        assertThat(longestPalindrome("cbbd")).isEqualTo("bb");
    }

    public static String longestPalindrome(String s) {
        int length = s.length();
        int maxIndex = 0;
        int maxLength = 1;
        for (int i = 0; i < length; i++) {
            // odd
            int left = i;
            int right = i;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int max = right - left - 1;

            // even
            left = i;
            right = i + 1;
            while (left >= 0 && right < length && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            max = Math.max(max, right - left - 1);

            if (maxLength < max) {
                maxIndex = i;
                maxLength = max;
            }
        }
        return s.substring(maxIndex - (maxLength - 1) / 2, maxIndex + (maxLength / 2) + 1);
    }

}
