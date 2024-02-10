package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 436 ms, faster than 13.15% of Java online submissions for Palindromic Substrings.
 * Memory Usage: 40.3 MB, less than 89.90% of Java online submissions for Palindromic Substrings.
 */
public class Q647PalindromicSubstrings2 {

    @Test
    public void test() {
        assertThat(countSubstrings("dnncbwoneinoplypwgbwktmvkoimcooyiwirgbxlcttgteqthcvyoueyftiwgwwxvxvg")).isEqualTo(77);
        assertThat(countSubstrings("abba")).isEqualTo(6);
        assertThat(countSubstrings("abc")).isEqualTo(3);
        assertThat(countSubstrings("aaa")).isEqualTo(6);

    }

    public int countSubstrings(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            check:
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    int l = i;
                    int r = j;
                    while (l < r) {
                        if (s.charAt(l) != s.charAt(r)) {
                            continue check;
                        }
                        l++;
                        r--;
                    }
                    cnt++;
                }
            }
        }
        return cnt + s.length();
    }

}
