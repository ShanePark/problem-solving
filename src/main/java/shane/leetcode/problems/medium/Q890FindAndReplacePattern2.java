package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 2 ms, faster than 74.25% of Java online submissions for Find and Replace Pattern.
 * Memory Usage: 43.8 MB, less than 7.97% of Java online submissions for Find and Replace Pattern.
 */
public class Q890FindAndReplacePattern2 {

    @Test
    public void test() {
        assertThat(findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb")).containsExactly("mee", "aqq");
        assertThat(findAndReplacePattern(new String[]{"a", "b", "c"}, "a")).containsExactly("a", "b", "c");
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> answer = new ArrayList<>();
        for (String word : words) {
            if (check(word, pattern)) {
                answer.add(word);
            }
        }
        return answer;

    }

    private boolean check(String word, String pattern) {
        int length = pattern.length();
        Map<Character, Character> charToPattern = new HashMap<>();
        Set<Character> consumed = new HashSet<>();
        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            char p = pattern.charAt(i);
            if (charToPattern.containsKey(c)) {
                if (charToPattern.get(c) != p) {
                    return false;
                }
            } else if (consumed.contains(p)) {
                return false;
            } else {
                charToPattern.put(c, p);
                consumed.add(p);
            }
        }
        return true;
    }

}
