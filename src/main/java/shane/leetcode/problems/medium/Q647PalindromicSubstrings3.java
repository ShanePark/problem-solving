package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q647PalindromicSubstrings3 {

    @Test
    public void test() {
        assertThat(countSubstrings("dnncbwoneinoplypwgbwktmvkoimcooyiwirgbxlcttgteqthcvyoueyftiwgwwxvxvg")).isEqualTo(77);
        assertThat(countSubstrings("abba")).isEqualTo(5);
        assertThat(countSubstrings("abc")).isEqualTo(3);
        assertThat(countSubstrings("aaa")).isEqualTo(6);

    }

    public int countSubstrings(String s) {
        int cnt = 0;
        for (int i = 1; i < s.length(); i++) {
            int length = 1;
            // odd
            while (i - length >= 0 && i + length < s.length()) {
                if (s.charAt(i - length) == s.charAt(i + length)) {
                    cnt++;
                } else {
                    break;
                }
                length++;
            }
            // even
            while (i - length >= 0 && i + length - 1 < s.length()) {
                if (s.charAt(i - length) == s.charAt(i + length - 1)) {
                    System.out.println("s.charAt(i-length) = " + s.charAt(i-length));
                    System.out.println("s.charAt(i-length) = " + s.charAt(i+length-1));
                    System.out.println("s.substring(i-length, i+length) = " + s.substring(i-length, i+length));
                    cnt++;
                } else {
                    break;
                }
                length++;
            }
        }
        return cnt + s.length();

    }
}
