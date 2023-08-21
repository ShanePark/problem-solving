package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 7ms Beats 95.07%of users with Java
 * Memory Details 43.89MB Beats 91.05%of users with Java
 */
public class Q459RepeatedSubstringPattern {

    @Test
    public void test() {
        assertThat(repeatedSubstringPattern("aba")).isFalse();
        assertThat(repeatedSubstringPattern("abab")).isTrue();
        assertThat(repeatedSubstringPattern("abcabcabcabc")).isTrue();
    }

    public boolean repeatedSubstringPattern(String s) {
        int cur = s.length() - 1;
        loop:
        while (cur > 0) {
            if (s.length() % cur != 0) {
                cur--;
                continue;
            }
            String sub = s.substring(0, cur);
            for (int i = 0; i < s.length(); i += cur) {
                String str = s.substring(i, i + cur);
                if (!str.equals(sub)) {
                    cur--;
                    continue loop;
                }
            }
            return true;
        }
        return false;
    }

}
