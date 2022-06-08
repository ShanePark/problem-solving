package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1332RemovePalindromicSubsequences2 {

    @Test
    public void test() {
        assertThat(removePalindromeSub("abbbbbbaaabaaabaabab")).isEqualTo(2);
        assertThat(removePalindromeSub("ababa")).isEqualTo(1);
        assertThat(removePalindromeSub("abb")).isEqualTo(2);
        assertThat(removePalindromeSub("baabb")).isEqualTo(2);
        assertThat(removePalindromeSub("abba")).isEqualTo(1);
    }

    public int removePalindromeSub(String s) {
        return isPalindrome(s) ? 1 : 2;
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
