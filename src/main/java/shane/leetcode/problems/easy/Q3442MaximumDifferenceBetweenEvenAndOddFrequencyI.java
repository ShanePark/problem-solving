package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 3ms
 * Beats54.69%
 */
public class Q3442MaximumDifferenceBetweenEvenAndOddFrequencyI {

    @Test
    public void test() {
        assertThat(maxDifference("aaaaabbc")).isEqualTo(3);
        assertThat(maxDifference("abcabcab")).isEqualTo(1);
        assertThat(maxDifference("tzt")).isEqualTo(-1);
    }

    public int maxDifference(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            cnt.merge(c, 1, Integer::sum);
        }
        int maxOdd = 0;
        int minEven = Integer.MAX_VALUE;
        for (Integer v : cnt.values()) {
            if (v % 2 == 1) {
                maxOdd = Math.max(maxOdd, v);
                continue;
            }
            minEven = Math.min(minEven, v);
        }
        return maxOdd - minEven;
    }

}
