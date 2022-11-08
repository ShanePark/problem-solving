package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3 ms Beats 93.8%
 * Memory 42.7 MB Beats 64.62%
 */
public class Q1544MakeTheStringGreat {

    @Test
    public void test() {
        assertThat(makeGood("leEeetcode")).isEqualTo("leetcode");
        assertThat(makeGood("abBAcC")).isEqualTo("");
        assertThat(makeGood("s")).isEqualTo("s");
    }

    public String makeGood(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < sb.length() - 1; i++) {
            char c1 = sb.charAt(i);
            char c2 = sb.charAt(i + 1);
            if (Math.abs(c1 - c2) == 32) {
                sb.deleteCharAt(i);
                sb.deleteCharAt(i);
                i = Math.max(-1, i - 2);
            }
        }
        return sb.toString();
    }
}
