package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q1662CheckIfTwoStringArraysAreEquivalent {

    @Test
    void test() {
        Assertions.assertThat(arrayStringsAreEqual(new String[]{"ab", "c"}, new String[]{"a", "bc"})).isTrue();
        Assertions.assertThat(arrayStringsAreEqual(new String[]{"a", "cb"}, new String[]{"ab", "c"})).isFalse();
    }

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer();
        for (String s : word1) {
            sb1.append(s);
        }
        for (String s : word2) {
            sb2.append(s);
        }
        return sb1.toString().equals(sb2.toString());
    }

}
