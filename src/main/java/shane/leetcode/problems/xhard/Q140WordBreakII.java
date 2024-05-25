package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 4 ms Beats 55.64% of users with Java
 */
public class Q140WordBreakII {

    @Test
    public void test() {
        assertThat(wordBreak("catsanddog", List.of("cat", "cats", "and", "sand", "dog"))).containsExactlyInAnyOrder("cats and dog", "cat sand dog");
        assertThat(wordBreak("pineapplepenapple", List.of("apple", "pen", "applepen", "pine", "pineapple"))).containsExactlyInAnyOrder("pine apple pen apple", "pineapple pen apple", "pine applepen apple");
        assertThat(wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat"))).isEmpty();
    }

    List<String> answer = new ArrayList<>();
    Set<String> dict;

    public List<String> wordBreak(String s, List<String> wordDict) {
        dict = new HashSet<>(wordDict);
        answer.clear();
        dfs(s, new StringBuilder(), 0, "");
        return answer;
    }

    private void dfs(String s, StringBuilder sb, int i, String sentence) {
        if (i == s.length()) {
            if (sb.length() > 0)
                return;
            answer.add(sentence);
            return;
        }
        char c = s.charAt(i);
        sb.append(c);
        // cut
        if (dict.contains(sb.toString())) {
            dfs(s, new StringBuilder(), i + 1, sentence.isEmpty() ? sb.toString() : sentence + " " + sb);
        }
        // skip
        dfs(s, sb, i + 1, sentence);
    }

}
