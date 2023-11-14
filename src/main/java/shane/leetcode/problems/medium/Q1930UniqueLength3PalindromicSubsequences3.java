package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1930UniqueLength3PalindromicSubsequences3 {

    @Test
    public void test() {
        assertThat(countPalindromicSubsequence("bbcbaba")).isEqualTo(4);
        assertThat(countPalindromicSubsequence("aabca")).isEqualTo(3);
        assertThat(countPalindromicSubsequence("adc")).isEqualTo(0);
    }

    @Test
    public void tle() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 100000; i++) {
            s.append("a");
        }
        assertThat(countPalindromicSubsequence(s.toString())).isEqualTo(1);
    }

    public int countPalindromicSubsequence(String s) {
        int[] firstIndexes = new int[26];
        int[] lastIndexes = new int[26];
        Arrays.fill(firstIndexes, -1);
        Arrays.fill(lastIndexes, -1);

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (firstIndexes[c - 'a'] < 0) {
                firstIndexes[c - 'a'] = i;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (lastIndexes[c - 'a'] < 0) {
                lastIndexes[c - 'a'] = i;
            }
        }

        int answer = 0;
        for (int i = 0; i < 26; i++) {
            if (firstIndexes[i] < lastIndexes[i]) {
                Set<Character> set = new HashSet<>();
                for (int j = firstIndexes[i] + 1; j < lastIndexes[i]; j++) {
                    set.add(s.charAt(j));
                }
                answer += set.size();
            }
        }
        return answer;
    }

}
