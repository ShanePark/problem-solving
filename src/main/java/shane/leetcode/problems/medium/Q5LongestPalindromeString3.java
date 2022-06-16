package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 581 ms, faster than 15.26% of Java online submissions for Longest Palindromic Substring.
 * Memory Usage: 43 MB, less than 71.65% of Java online submissions for Longest Palindromic Substring.
 */
public class Q5LongestPalindromeString3 {

    @Test
    public void test() {
        assertThat(longestPalindrome("babad")).isEqualTo("bab");
        assertThat(longestPalindrome("cbbd")).isEqualTo("bb");
    }

    public static String longestPalindrome(String s) {
        final int LENGTH = s.length();
        for (int i = LENGTH; i > 1; i--) {
            for (int j = 0; j + i <= LENGTH; j++) {
                if (isPalindrome(s, j, i)) {
                    return s.substring(j, j + i);
                }
            }
        }
        return String.valueOf(s.charAt(0));
    }

    private static boolean isPalindrome(String str, int index, int length) {
        int end = index + length - 1;
        while (index < end) {
            if (str.charAt(index) != str.charAt(end))
                return false;
            index++;
            end--;
        }
        return true;
    }

}
