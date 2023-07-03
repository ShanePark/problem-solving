package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 4 ms Beats 50.57%
 * Memory 41.6 MB Beats 57.51%
 */
public class Q859BuddyStrings {

    @Test
    public void test() {
        assertThat(buddyStrings("ab", "ba")).isTrue();
        assertThat(buddyStrings("abc", "acd")).isFalse();
        assertThat(buddyStrings("abcaa", "abcbb")).isFalse();
        assertThat(buddyStrings("ab", "ab")).isFalse();
        assertThat(buddyStrings("aa", "aa")).isTrue();
    }

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length())
            return false;
        Character diffCharA = null;
        Character diffCharB = null;
        Set<Character> chars = new HashSet<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            char c1 = s.charAt(i);
            chars.add(c1);
            char c2 = goal.charAt(i);
            if (c1 != c2) {
                if (diffCharA == null) {
                    diffCharA = c1;
                    diffCharB = c2;
                } else {
                    if (diffCharA != c2 || diffCharB != c1) {
                        return false;
                    }
                    diffCharA = ' ';
                    diffCharB = ' ';
                }
            }
        }
        if (diffCharA == null && chars.size() == s.length()) {
            return false;
        }
        return diffCharA == null || diffCharA == ' ';
    }

}
