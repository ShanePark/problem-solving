package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 0
 * ms
 * Beats
 * 100.00%
 */
public class Q1790CheckIfOneStringSwapCanMakeStringsEqual {

    @Test
    public void test() {
        assertThat(areAlmostEqual("bank", "kanb")).isTrue();
        assertThat(areAlmostEqual("attack", "defend")).isFalse();
        assertThat(areAlmostEqual("kelb", "kelb")).isTrue();
        assertThat(areAlmostEqual("aa", "ac")).isFalse();
    }

    public boolean areAlmostEqual(String s1, String s2) {
        final int LENGTH = s1.length();
        int diffIndex = -1;
        for (int i = 0; i < LENGTH; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 == c2)
                continue;
            if (diffIndex == -1) {
                diffIndex = i;
                continue;
            }
            if (diffIndex == -2)
                return false;
            if (c2 != s1.charAt(diffIndex) || c1 != s2.charAt(diffIndex))
                return false;
            diffIndex = -2;
        }
        return diffIndex < 0;
    }

}
