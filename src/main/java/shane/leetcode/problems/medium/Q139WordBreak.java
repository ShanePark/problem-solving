package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q139WordBreak {

    @Test
    public void test() {
        assertThat(wordBreak("leetcode", List.of("lee", "leet", "code"))).isTrue();
        assertThat(wordBreak("leetcode", List.of("leet", "code"))).isTrue();
        assertThat(wordBreak("applepenapple", List.of("apple", "pen"))).isTrue();
        assertThat(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))).isFalse();
    }

    @Test
    public void tle() {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        List<String> wordDict = List.of("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
        assertThat(wordBreak(s, wordDict)).isFalse();
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, 0);
    }

    private boolean dfs(String s, List<String> wordDict, int i) {
        if (i == s.length())
            return true;
        String sub = s.substring(i);
        int subLength = sub.length();
        for (String word : wordDict) {
            if (subLength < word.length() || !sub.startsWith(word)) {
                continue;
            }
            if (dfs(s, wordDict, i + word.length())) {
                return true;
            }
        }
        return false;
    }

}
