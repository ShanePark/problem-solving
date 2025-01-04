package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 139
 * ms
 * Beats
 * 79.58%
 */
public class Q1930UniqueLength3PalindromicSubsequences4 {

    @Test
    public void test() {
        assertThat(countPalindromicSubsequence("bbcbaba")).isEqualTo(4);
        assertThat(countPalindromicSubsequence("aabca")).isEqualTo(3);
        assertThat(countPalindromicSubsequence("adc")).isEqualTo(0);
    }

    public int countPalindromicSubsequence(String s) {
        int[][] cnt = new int[s.length()][26];
        int[] cur = new int[26];
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cur[c - 'a']++;
            cnt[i] = Arrays.copyOf(cur, cur.length);
            lastIndex[c - 'a'] = i;
        }

        boolean[] visited = new boolean[26];
        int answer = 0;
        for (int left = 0; left < s.length(); left++) {
            char c = s.charAt(left);
            if (visited[c - 'a'])
                continue;
            visited[c - 'a'] = true;
            int right = lastIndex[c - 'a'];
            if (left == right)
                continue;
            for (int i = 0; i < 26; i++) {
                if (cnt[right - 1][i] == cnt[left][i]) {
                    continue;
                }
                answer++;
            }
        }
        return answer;
    }

}
