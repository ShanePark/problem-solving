package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my
 */
public class Q2014LongestSubsequenceRepeatedKTimes {

    @Test
    public void test() {
        assertThat(longestSubsequenceRepeatedK("letsleetcode", 2)).isEqualTo("let");
        assertThat(longestSubsequenceRepeatedK("bb", 2)).isEqualTo("b");
        assertThat(longestSubsequenceRepeatedK("ab", 2)).isEqualTo("");
    }

    public String longestSubsequenceRepeatedK(String s, int k) {
        int LENGTH = s.length();
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        int[] avail = new int[26];
        int totalAvail = 0;
        for (int i = 0; i < 26; i++) {
            avail[i] = freq[i] / k;
            totalAvail += avail[i];
        }

        List<Character> chars = new ArrayList<>();
        for (int i = 25; i >= 0; i--) {
            if (avail[i] > 0) {
                chars.add((char) ('a' + i));
            }
        }
        char[] cand = new char[chars.size()];
        for (int i = 0; i < chars.size(); i++) {
            cand[i] = chars.get(i);
        }

        int[][] next = new int[LENGTH + 1][26];
        for (int c = 0; c < 26; c++) {
            next[LENGTH][c] = -1;
        }
        for (int i = LENGTH - 1; i >= 0; i--) {
            next[i] = next[i + 1].clone();
            next[i][s.charAt(i) - 'a'] = i;
        }
        StringBuilder answer = new StringBuilder();
        dfs(new StringBuilder(), new int[26], cand, k, answer, avail, totalAvail, next);
        return answer.toString();
    }

    private void dfs(StringBuilder sb, int[] curCount, char[] cand, int k, StringBuilder answer, int[] avail, int totalAvail, int[][] next) {
        if (sb.length() > answer.length() || (sb.length() == answer.length() && sb.compareTo(answer) > 0)) {
            answer.setLength(0);
            answer.append(sb);
        }
        if (answer.length() == totalAvail)
            return;

        for (char c : cand) {
            int idx = c - 'a';
            if (curCount[idx] < avail[idx]) {
                sb.append(c);
                curCount[idx]++;
                if (isValid(sb, k, next)) {
                    dfs(sb, curCount, cand, k, answer, avail, totalAvail, next);
                }
                curCount[idx]--;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    private boolean isValid(StringBuilder sb, int k, int[][] next) {
        int pos = 0;
        for (int rep = 0; rep < k; rep++) {
            for (int j = 0; j < sb.length(); j++) {
                int c = sb.charAt(j) - 'a';
                pos = next[pos][c];
                if (pos < 0) return false;
                pos++;
            }
        }
        return true;
    }

}
