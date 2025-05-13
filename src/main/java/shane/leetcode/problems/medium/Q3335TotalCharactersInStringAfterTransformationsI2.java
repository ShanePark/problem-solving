package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 56ms
 * Beats82.28%
 */
public class Q3335TotalCharactersInStringAfterTransformationsI2 {

    @Test
    public void test() {
        assertThat(lengthAfterTransformations("cu", 5)).isEqualTo(2);
        assertThat(lengthAfterTransformations("abcyy", 2)).isEqualTo(7);
        assertThat(lengthAfterTransformations("azbk", 1)).isEqualTo(5);
    }

    @Test
    public void test2() {
        assertThat(lengthAfterTransformations("jqktcurgdvlibczdsvnsg", 7517)).isEqualTo(79033769);
    }

    @Test
    public void edgeCase() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 100_000; i++) {
            sb.append((char) ('a' + (i % 26)));
        }
        assertThat(lengthAfterTransformations(sb.toString(), 100_000)).isEqualTo(926463126);
    }

    final int MOD = (int) 1e9 + 7;

    public int lengthAfterTransformations(String s, int t) {
        int answer = 0;
        int[][] dp = new int[26][t + 1];
        for (char c : s.toCharArray()) {
            answer = (answer + getLength(c, t, dp)) % MOD;

        }
        return answer;
    }

    private int getLength(char c, int t, int[][] dp) {
        if (dp[c - 'a'][t] > 0)
            return dp[c - 'a'][t];
        int split = 'z' - c + 1;
        if (t < split)
            return dp[c - 'a'][t] = 1;
        int answer = (getLength('a', t - split, dp) + getLength('b', t - split, dp)) % MOD;
        return dp[c - 'a'][t] = answer;
    }

}
