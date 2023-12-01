package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Runtime Details 4ms Beats 7.87%of users with Java
 * Memory Details 40.63MB Beats 28.67%of users with Java
 */
public class Q1662CheckIfTwoStringArraysAreEquivalent2 {

    @Test
    void test() {
        Assertions.assertThat(arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"})).isTrue();
        Assertions.assertThat(arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"ab", "c"})).isFalse();
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i1 = 0;
        int j1 = 0;
        int i2 = 0;
        int j2 = 0;

        while (i1 < word1.length && j1 < word1[i1].length() && i2 < word2.length && j2 < word2[i2].length()) {
            char c1 = word1[i1].charAt(j1);
            char c2 = word2[i2].charAt(j2);
            if (c1 != c2)
                return false;
            j1++;
            j2++;
            if (word1[i1].length() == j1) {
                i1++;
                j1 = 0;
            }
            if (word2[i2].length() == j2) {
                i2++;
                j2 = 0;
            }
        }

        return word1.length == i1 && word2.length == i2;
    }

}
