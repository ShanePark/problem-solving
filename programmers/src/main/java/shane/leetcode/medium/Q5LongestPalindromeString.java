package shane.leetcode.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Q5LongestPalindromeString {

    public static void main(String[] args) {
        assertEquals("bab", longestPalindrome("babad"));
        assertEquals("bb", longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        for (int len = s.length(); len > 1; len--) {
            for (int j = 0; j + len <= s.length(); j++) {
                if (isPalindrome(s, j, j + len)) {
                    return s.substring(j, j + len);
                }
            }
        }
        return String.valueOf(s.charAt(0));
    }

    private static boolean isPalindrome(String str, int start, int end) {
        int length = end - start;
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i + start) != str.charAt(end - 1 - i)) {
                return false;
            }
        }
        return true;
    }

}
