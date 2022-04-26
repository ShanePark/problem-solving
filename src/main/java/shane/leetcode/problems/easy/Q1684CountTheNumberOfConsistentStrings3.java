package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class Q1684CountTheNumberOfConsistentStrings3 {

    @Test
    void test() {
        Assertions.assertThat(countConsistentStrings("ab", new String[]{"ad", "bd", "aaab", "baa", "badab"})).isEqualTo(2);
        Assertions.assertThat(countConsistentStrings("abc", new String[]{"a", "b", "c", "ab", "ac", "bc", "abc"})).isEqualTo(7);
        Assertions.assertThat(countConsistentStrings("cad", new String[]{"cc", "acd", "b", "ba", "bac", "bad", "ac", "d"})).isEqualTo(4);
    }

    public int countConsistentStrings(String allowed, String[] words) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++)
            set.add(allowed.charAt(i));

        int cnt = 0;
        loop:
        for (String word : words) {
            final int LENGTH = word.length();
            for (int i = 0; i < LENGTH; i++) {
                if (!set.contains(word.charAt(i))) {
                    continue loop;
                }
            }
            cnt++;
        }
        return cnt;
    }
}
