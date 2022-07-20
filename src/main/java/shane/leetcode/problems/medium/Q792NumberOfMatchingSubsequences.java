package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q792NumberOfMatchingSubsequences {

    @Test
    public void test() {
        assertThat(numMatchingSubseq("abcde", new String[]{"a", "bb", "acd", "ace"})).isEqualTo(3);
        assertThat(numMatchingSubseq("dsahjpjauf", new String[]{"ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax"})).isEqualTo(2);
    }

    public int numMatchingSubseq(String s, String[] words) {
        int cnt = 0;
        for (String word : words) {
            if (canMake(s, word)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean canMake(String from, String word) {
        int cur = 0;
        for (int i = 0; i < from.length(); i++) {
            if (from.charAt(i) == word.charAt(cur) && ++cur == word.length()) {
                return true;
            }
        }
        return false;
    }
}
