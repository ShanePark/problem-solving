package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 737 ms, faster than 5.63% of Java online submissions for Palindromic Substrings.
 * Memory Usage: 42.4 MB, less than 43.03% of Java online submissions for Palindromic Substrings.
 */
public class Q647PalindromicSubstrings {

    @Test
    public void test() {
        assertThat(countSubstrings("dnncbwoneinoplypwgbwktmvkoimcooyiwirgbxlcttgteqthcvyoueyftiwgwwxvxvg")).isEqualTo(77);
        assertThat(countSubstrings("abc")).isEqualTo(3);
        assertThat(countSubstrings("aaa")).isEqualTo(6);

    }

    public int countSubstrings(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                if (isPalindrome(s.substring(i, j))) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean isPalindrome(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - 1 - i))
                return false;
        }
        return true;
    }
}
