package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 3ms Beats 37.34%of users with Java
 * Memory Details 41.41MB Beats 11.53%of users with Java
 */
public class Q1624LargestSubstringBetweenTwoEqualCharacters {

    @Test
    public void test() {
        assertThat(maxLengthBetweenEqualCharacters("aa")).isEqualTo(0);
        assertThat(maxLengthBetweenEqualCharacters("abca")).isEqualTo(2);
        assertThat(maxLengthBetweenEqualCharacters("cbzxy")).isEqualTo(-1);
        assertThat(maxLengthBetweenEqualCharacters("scayofdzca")).isEqualTo(6);
    }

    public int maxLengthBetweenEqualCharacters(String s) {
        Map<Character, Integer> firstIndex = new HashMap<>();
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!firstIndex.containsKey(c)) {
                firstIndex.put(c, i);
                continue;
            }
            int left = firstIndex.get(c);
            max = Math.max(i - left - 1, max);
        }
        return max;
    }

}
