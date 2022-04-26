package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q890FindAndReplacePattern {

    @Test
    public void test() {
        assertThat(findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb")).containsExactly("mee", "aqq");
        assertThat(findAndReplacePattern(new String[]{"a", "b", "c"}, "a")).containsExactly("a", "b", "c");
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> answer = new ArrayList<>();
        for (String word : words) {
            if (match(word, pattern))
                answer.add(word);
        }
        return answer;
    }

    private boolean match(String word, String pattern) {
        Map<Character, Character> wordMap = new HashMap<>();
        Map<Character, Character> patternMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            Character c = wordMap.get(word.charAt(i));
            if (c == null) {
                wordMap.put(word.charAt(i), pattern.charAt(i));
                if (patternMap.put(pattern.charAt(i), word.charAt(i)) != null)
                    return false;
            } else if (c != pattern.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
