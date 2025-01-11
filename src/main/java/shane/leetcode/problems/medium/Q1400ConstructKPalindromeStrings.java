package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 3
 * ms
 * Beats
 * 100.00%
 */
public class Q1400ConstructKPalindromeStrings {

    @Test
    public void test() {
        assertThat(canConstruct("leetcode", 3)).isFalse();
        assertThat(canConstruct("annabelle", 2)).isTrue();
        assertThat(canConstruct("true", 4)).isTrue();
        assertThat(canConstruct("aabb", 6)).isFalse();
    }

    public boolean canConstruct(String s, int k) {
        if (s.length() < k)
            return false;
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        int cntOdd = 0;
        for (int i : cnt) {
            cntOdd += i % 2;
        }
        return k >= cntOdd;
    }

}
