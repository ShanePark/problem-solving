package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 52ms
 * Beats89.97%
 */
public class Q1930UniqueLength3PalindromicSubsequences5 {

    @Test
    public void test() {
        assertThat(countPalindromicSubsequence("aabca")).isEqualTo(3);
        assertThat(countPalindromicSubsequence("adc")).isEqualTo(0);
        assertThat(countPalindromicSubsequence("bbcbaba")).isEqualTo(4);
    }

    public int countPalindromicSubsequence(String s) {
        int[][] cnt = new int[s.length()][26];
        int[][] firstLast = new int[26][2];
        for (int[] ints : firstLast) {
            Arrays.fill(ints, -1);
        }
        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i) - 'a';
            if (firstLast[charIndex][0] == -1) {
                firstLast[charIndex][0] = i;
            }
            firstLast[charIndex][1] = i;
            cnt[i][charIndex] = 1;
            if (i == 0)
                continue;
            for (int j = 0; j < 26; j++) {
                cnt[i][j] += cnt[i - 1][j];
            }
        }
        int answer = 0;
        for (int i = 0; i < 26; i++) {
            int first = firstLast[i][0];
            int last = firstLast[i][1];
            if (first < 0 || first == last)
                continue;
            for (int j = 0; j < 26; j++) {
                int midCnt = (last == 0 ? 0 : cnt[last - 1][j]) - cnt[first][j];
                if (midCnt > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }

}
