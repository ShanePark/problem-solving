package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Runtime11msBeats75.18%
 */
public class Q1684CountTheNumberOfConsistentStrings4 {

    @Test
    void test() {
        Assertions.assertThat(countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"})).isEqualTo(2);
        Assertions.assertThat(countConsistentStrings("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"})).isEqualTo(7);
        Assertions.assertThat(countConsistentStrings("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"})).isEqualTo(4);
    }

    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> allows = new HashSet<>();
        for (char c : allowed.toCharArray()) {
            allows.add(c);
        }
        int cnt = 0;
        for (String word : words) {
            if (possible(word, allows)) {
                cnt++;
            }
        }
        return cnt;
    }

    private boolean possible(String word, Set<Character> allows) {
        for (Character c : word.toCharArray()) {
            if (!allows.contains(c)) {
                return false;
            }
        }
        return true;
    }

}
