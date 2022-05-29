package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 876 ms, faster than 10.31% of Java online submissions for Maximum Product of Word Lengths.
 * Memory Usage: 43.6 MB, less than 74.77% of Java online submissions for Maximum Product of Word Lengths.
 */
public class Q318MaximumProductOfWordLengths2 {

    @Test
    public void test() {
        assertThat(maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"})).isEqualTo(16);
        assertThat(maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"})).isEqualTo(4);
        assertThat(maxProduct(new String[]{"a", "aa", "aaa", "aaaa"})).isEqualTo(0);
    }


    public int maxProduct(String[] words) {
        Map<Character, Set<String>> map = new HashMap<>();
        for (char c = 'a'; c <= 'z'; c++) {
            map.put(c, new HashSet<>());
        }
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                map.get(word.charAt(i)).add(word);
            }
        }
        int max = 0;
        for (String word : words) {
            Set<String> all = Arrays.stream(words).collect(Collectors.toSet());
            for (int i = 0; i < word.length(); i++) {
                all.removeAll(map.get(word.charAt(i)));
            }
            for (String s : all) {
                max = Math.max(max, word.length() * s.length());
            }
        }
        return max;
    }
}
