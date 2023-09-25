package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Runtime Details 9ms Beats 17.15%of users with Java
 * Memory Details 40.96MB Beats 29.39%of users with Java
 */
public class Q389FindtheDifference3 {

    @Test
    void test() {
        Assertions.assertThat(findTheDifference("abcd", "abcde")).isEqualTo('e');
        Assertions.assertThat(findTheDifference("", "y")).isEqualTo('y');
    }

    public char findTheDifference(String s, String t) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            cnt.merge(s.charAt(i), 1, Integer::sum);
            cnt.merge(t.charAt(i), -1, Integer::sum);
        }
        cnt.merge(t.charAt(s.length()), -1, Integer::sum);
        return cnt.entrySet()
                .stream()
                .filter((e) -> e.getValue() == -1)
                .findAny()
                .get()
                .getKey();
    }

}
