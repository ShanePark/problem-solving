package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Runtime Details 263ms Beats 14.78%of users with Java
 * Memory Details 41.63MB Beats 58.48%of users with Java
 */
public class Q5LongestPalindromeString5 {

    @Test
    public void test() {
        assertThat(longestPalindrome("babad").length()).isEqualTo(3);
        assertThat(longestPalindrome("cbbd")).isEqualTo("bb");
    }

    public String longestPalindrome(String s) {
        final int LENGTH = s.length();
        String longest = String.valueOf(s.charAt(0));
        int longestLength = 1;

        for (int i = 0; i < LENGTH; i++) {
            for (int j = LENGTH - 1; j > i; j--) {
                int length = j - i + 1;
                if (length <= longestLength) {
                    break;
                }
                if (isPalindrome(s, i, j)) {
                    longestLength = length;
                    longest = s.substring(i, j + 1);
                    break;
                }
            }
        }
        return longest;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--))
                return false;
        }
        return true;
    }

}
