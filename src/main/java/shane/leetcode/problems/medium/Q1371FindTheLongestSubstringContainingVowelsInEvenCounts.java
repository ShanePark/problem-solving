package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not My Solution
 */
public class Q1371FindTheLongestSubstringContainingVowelsInEvenCounts {

    @Test
    public void test() {
        assertThat(findTheLongestSubstring("eleetminicoworoep")).isEqualTo(13);
        assertThat(findTheLongestSubstring("leetcodeisgreat")).isEqualTo(5);
        assertThat(findTheLongestSubstring("bcbcbc")).isEqualTo(6);
    }

    final Map<Character, Integer> VOWELS = Map.of('a', 1, 'e', 2, 'i', 4, 'o', 8, 'u', 16);

    public int findTheLongestSubstring(String s) {
        HashMap<Integer, Integer> min = new HashMap<>();
        min.put(0, -1);
        int cur = 0;
        int answer = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (VOWELS.containsKey(c)) {
                cur ^= VOWELS.get(c);
            }
            min.putIfAbsent(cur, i);
            answer = Math.max(answer, i - min.get(cur));
        }

        return answer;
    }

}
