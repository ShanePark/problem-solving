package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 22 ms Beats 13.56% of users with Java
 */
public class Q205IsomorphicStrings {

    @Test
    public void test() {
        assertThat(isIsomorphic("badc", "baba")).isFalse();
        assertThat(isIsomorphic("bbbaaaba", "aaabbbba")).isFalse();
        assertThat(isIsomorphic("egg", "add")).isTrue();
        assertThat(isIsomorphic("foo", "bar")).isFalse();
        assertThat(isIsomorphic("paper", "title")).isTrue();
    }

    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1) || map2.containsKey(c2)) {
                Character c2Excepted = map.get(c1);
                Character c1Expected = map2.get(c2);
                if (c1Expected == null || c2Excepted == null || c1Expected != c1 || c2Excepted != c2) {
                    return false;
                }
            }
            map.put(c1, c2);
            map2.put(c2, c1);
        }
        return true;
    }

}
