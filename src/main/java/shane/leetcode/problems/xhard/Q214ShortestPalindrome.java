package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q214ShortestPalindrome {

    @Test
    public void test() {
        assertThat(shortestPalindrome("abbacd")).isEqualTo("dcabbacd");
        assertThat(shortestPalindrome("aacecaaa")).isEqualTo("aaacecaaa");
        assertThat(shortestPalindrome("abcd")).isEqualTo("dcbabcd");
        assertThat(shortestPalindrome("abb")).isEqualTo("bbabb");
        assertThat(shortestPalindrome("")).isEqualTo("");
        assertThat(shortestPalindrome("aaaba")).isEqualTo("abaaaba");
    }

    public String shortestPalindrome(String s) {
        StringBuilder reverse = new StringBuilder(s).reverse();

        for (int i = 0; i < s.length(); i++) {
            if (isPalindromePrefix(s, reverse, i)) {
                return reverse.substring(0, i) + s;
            }
        }
        return "";
    }

    private boolean isPalindromePrefix(String s, StringBuilder reverse, int offset) {
        for (int i = 0; i < s.length() - offset; i++) {
            if (s.charAt(i) != reverse.charAt(offset + i)) {
                return false;
            }
        }
        return true;
    }

}
