package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 2ms
 * Beats13.74%
 */
public class Q2185CountingWordsWithAGivenPrefix {

    @Test
    public void test() {
        assertThat(prefixCount(new String[]{"pay", "attention", "practice", "attend"}, "at")).isEqualTo(2);
        assertThat(prefixCount(new String[]{"leetcode", "win", "loops", "success"}, "code")).isEqualTo(0);
    }

    public int prefixCount(String[] words, String pref) {
        return (int)Arrays.stream(words)
                .filter(w -> w.startsWith(pref))
                .count();
    }

}
