package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q214ShortestPalindrome2 {

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
        if (s == null || s.isEmpty()) return s;

        String combined = s + "#" + new StringBuilder(s).reverse();
        int[] lps = computeLPSArray(combined);

        int longestPrefixSuffix = lps[lps.length - 1];

        return new StringBuilder(s.substring(longestPrefixSuffix)).reverse() + s;
    }

    private int[] computeLPSArray(String s) {
        int[] lps = new int[s.length()];

        for (int i = 1, len = 0; i < s.length(); i++) {
            while (len > 0 && s.charAt(i) != s.charAt(len)) {
                len = lps[len - 1];
            }
            if (s.charAt(i) == s.charAt(len)) {
                len++;
            }
            lps[i] = len;
        }
        return lps;
    }

}
