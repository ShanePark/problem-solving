package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 61
 * ms
 * Beats
 * 6.38%
 */
public class Q3085MinimumDeletionsToMakeStringKSpecial {

    @Test
    public void test() {
        assertThat(minimumDeletions("aaabaaa", 2)).isEqualTo(1);
        assertThat(minimumDeletions("dabdcbdcdcd", 2)).isEqualTo(2);
        assertThat(minimumDeletions("aabcaba", 0)).isEqualTo(3);
    }

    @Test
    public void test2() {
        assertThat(minimumDeletions("inn", 3)).isEqualTo(0);
        assertThat(minimumDeletions("k", 1000000)).isEqualTo(0);
        assertThat(minimumDeletions("ddwddddwdddw", 1)).isEqualTo(3);
    }

    public int minimumDeletions(String word, int k) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (Character c : word.toCharArray()) {
            cnt.merge(c, 1, Integer::sum);
        }
        if (cnt.size() == 1)
            return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (Integer value : cnt.values()) {
            max = Math.max(max, value);
            min = Math.min(min, value);
        }

        int answer = Integer.MAX_VALUE;
        for (int i = min; i <= max - k; i++) {
            int deletions = calc(i, cnt.values(), k);
            answer = Math.min(answer, deletions);
        }
        return answer % Integer.MAX_VALUE;
    }

    private int calc(int min, Collection<Integer> values, int k) {
        int deletions = 0;
        for (Integer v : values) {
            if (v < min) {
                deletions += v;
                continue;
            }
            if (Math.abs(min - v) <= k)
                continue;
            deletions += v - min - k;
        }
        return deletions;
    }

}

