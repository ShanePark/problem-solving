package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 10ms
 * Beats82.12%
 */
public class Q3223MinimumLengthOfStringAfterOperations {

    @Test
    public void test() {
        assertThat(minimumLength("abaacbcbb")).isEqualTo(5);
        assertThat(minimumLength("aa")).isEqualTo(2);
    }

    public int minimumLength(String s) {
        int[] cnt = new int[26];
        for (char c : s.toCharArray()) {
            cnt[c - 'a']++;
        }
        int answer = 0;
        for (int i : cnt) {
            if (i >= 3)
                i = (i + 1) % 2 + 1;
            answer += i;
        }
        return answer;
    }

}
