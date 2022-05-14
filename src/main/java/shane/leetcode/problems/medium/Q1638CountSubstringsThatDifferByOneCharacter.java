package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1638CountSubstringsThatDifferByOneCharacter {

    @Test
    public void test() {
        assertThat(countSubstrings("abc", "def")).isEqualTo(9);
        assertThat(countSubstrings("aba", "baba")).isEqualTo(6);
        assertThat(countSubstrings("ab", "bb")).isEqualTo(3);
    }

    public int countSubstrings(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                int length = j - i;
                String str1 = s.substring(i, j);
                for (int k = 0; k < t.length(); k++) {
                    if (k + length <= t.length()) {
                        String str2 = t.substring(k, k + length);
                        if (oneDiff(str1, str2)) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    private boolean oneDiff(String str1, String str2) {
        int dif = 0;
        for (int i = 0; i < str1.length() && dif < 2; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                dif++;
            }
        }
        return dif == 1;
    }
}
