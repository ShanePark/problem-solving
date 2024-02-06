package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 22 ms Beats 56.63% of users with Java
 */
public class Q387FirstUniqueCharacterInAString3 {

    @Test
    public void test() {
        assertThat(firstUniqChar("leetcode")).isEqualTo(0);
        assertThat(firstUniqChar("loveleetcode")).isEqualTo(2);
        assertThat(firstUniqChar("aabb")).isEqualTo(-1);
    }

    public int firstUniqChar(String s) {
        LinkedHashMap<Character, Integer> cnt = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            cnt.merge(c, 1, Integer::sum);
        }
        for (Map.Entry<Character, Integer> e : cnt.entrySet()) {
            if (e.getValue() == 1) {
                return s.indexOf(e.getKey());
            }
        }
        return -1;
    }

}
