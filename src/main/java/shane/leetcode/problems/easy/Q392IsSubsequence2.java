package shane.leetcode.problems.easy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Runtime Details 1ms Beats 89.69%of users with Java
 * Memory Details 40.65MB Beats 27.44%of users with Java
 */
public class Q392IsSubsequence2 {

    @Test
    void test() {
        Assertions.assertThat(isSubsequence("abc", "ahbgdc")).isTrue();
        Assertions.assertThat(isSubsequence("axc", "ahbgdc")).isFalse();
    }

    public boolean isSubsequence(String s, String t) {
        int tIndex = 0;
        for (int i = 0; i < s.length(); i++) {
            char target = s.charAt(i);
            while (tIndex < t.length() && t.charAt(tIndex) != target) {
                tIndex++;
            }
            if (tIndex == t.length() || t.charAt(tIndex) != target)
                return false;
            tIndex++;
        }
        return true;
    }

}
