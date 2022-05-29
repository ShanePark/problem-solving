package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q318MaximumProductOfWordLengths {

    @Test
    public void test() {
        assertThat(maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"})).isEqualTo(16);
        assertThat(maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"})).isEqualTo(4);
        assertThat(maxProduct(new String[]{"a", "aa", "aaa", "aaaa"})).isEqualTo(0);
    }


    public int maxProduct(String[] words) {
        Set[] sets = new Set[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < word.length(); j++) {
                set.add(word.charAt(j));
            }
            sets[i] = set;
        }
        int max = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (i == j) continue;
                String word1 = words[i];
                String word2 = words[j];
                int product = word1.length() * word2.length();
                if (product <= max)
                    continue;
                Set<Character> temp = new HashSet<>();
                temp.addAll(sets[i]);
                temp.addAll(sets[j]);
                if (temp.size() == sets[i].size() + sets[j].size()) {
                    max = product;
                }
            }
        }
        return max;
    }
}
