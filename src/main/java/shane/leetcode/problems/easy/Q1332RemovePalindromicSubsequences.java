package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1332RemovePalindromicSubsequences {

    @Test
    public void test() {
        assertThat(isPalindrome("ababa")).isTrue();
        assertThat(removePalindromeSub("ababa")).isEqualTo(1);
        assertThat(removePalindromeSub("abb")).isEqualTo(2);
        assertThat(removePalindromeSub("baabb")).isEqualTo(2);
        assertThat(removePalindromeSub("abba")).isEqualTo(1);
        assertThat(removePalindromeSub("bbaaaaabbbb")).isEqualTo(2);
    }

    public int removePalindromeSub(String s) {
        if (isPalindrome(s)) {
            return 1;
        } else {
            int min = 1;
            for (int i = 0; i < s.length(); i++) {
                String str = s.substring(0, i) + s.substring(i + 1);
                min = Math.min(min, removePalindromeSub(str));
            }
            return min + 1;
        }
    }

    boolean isPalindrome(String s) {
        int length = s.length();
        for (int i = 0; i < length / 2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
