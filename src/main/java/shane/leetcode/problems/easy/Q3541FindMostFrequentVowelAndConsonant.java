package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 7
 * ms
 * Beats
 * 7.64%
 */
public class Q3541FindMostFrequentVowelAndConsonant {

    @Test
    public void test() {
        assertThat(maxFreqSum("successes")).isEqualTo(6);
        assertThat(maxFreqSum("aeiaeia")).isEqualTo(3);
    }

    public int maxFreqSum(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            cnt.merge(c, 1, Integer::sum);
        }
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        int answer = 0;
        for (char vowel : vowels) {
            answer = Math.max(answer, cnt.getOrDefault(vowel, 0));
            cnt.remove(vowel);
        }
        return answer + cnt.values().stream().max(Comparator.naturalOrder()).orElse(0);
    }

}
