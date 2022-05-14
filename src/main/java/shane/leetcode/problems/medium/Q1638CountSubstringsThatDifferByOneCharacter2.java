package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1638CountSubstringsThatDifferByOneCharacter2 {

    @Test
    public void test() {
        assertThat(countSubstrings("abc", "def")).isEqualTo(9);
        assertThat(countSubstrings("aba", "baba")).isEqualTo(6);
        assertThat(countSubstrings("ab", "bb")).isEqualTo(3);
    }

    public int countSubstrings(String s, String t) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < t.length(); j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    int left = 1;
                    int right = 1;
                    while (i >= left && j >= left && s.charAt(i - left) == t.charAt(j - left)) {
                        left++;
                    }
                    while (i + right < s.length() && j + right < t.length() && s.charAt(i + right) == t.charAt(j + right)) {
                        right++;
                    }
                    count += left * right;
                }
            }
        }
        return count;
    }

}
