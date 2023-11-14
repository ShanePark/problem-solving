package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1930UniqueLength3PalindromicSubsequences2 {

    @Test
    public void test() {
        assertThat(countPalindromicSubsequence("aabca")).isEqualTo(3);
        assertThat(countPalindromicSubsequence("adc")).isEqualTo(0);
        assertThat(countPalindromicSubsequence("bbcbaba")).isEqualTo(4);
    }

    /**
     * 1min 58s
     */
    @Test
    public void tle() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            s.append("a");
        }
        assertThat(countPalindromicSubsequence(s.toString())).isEqualTo(1);
    }

    public int countPalindromicSubsequence(String s) {
        int[] firstIndex = new int[26];
        Arrays.fill(firstIndex, -1);

        Set<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (firstIndex[c - 'a'] < 0) {
                firstIndex[c - 'a'] = i;
                continue;
            }
            for (int j = firstIndex[c - 'a'] + 1; j < i; j++) {
                String palindrome = String.valueOf(s.charAt(i)) + s.charAt(j) + s.charAt(i);
                set.add(palindrome);
            }
        }
        return set.size();
    }

}
