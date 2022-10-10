package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Break a Palindrome.
 * Memory Usage: 40.4 MB, less than 89.54% of Java online submissions for Break a Palindrome.
 */
public class Q1328BreakAPalindrome {

    @Test
    public void test() {
        assertThat(breakPalindrome("aba")).isEqualTo("abb");
        assertThat(breakPalindrome("aa")).isEqualTo("ab");
        assertThat(breakPalindrome("abccba")).isEqualTo("aaccba");
        assertThat(breakPalindrome("a")).isEqualTo("");
    }

    public String breakPalindrome(String palindrome) {
        int length = palindrome.length();
        if (length == 1)
            return "";
        StringBuilder sb = new StringBuilder(palindrome);
        for (int i = 0; i < length; i++) {
            if (sb.charAt(i) != 'a' && !(i == length / 2 && length % 2 == 1)) {
                sb.replace(i, i + 1, "a");
                return sb.toString();
            }
        }
        sb.replace(length - 1, length, "b");
        return sb.toString();
    }
}
