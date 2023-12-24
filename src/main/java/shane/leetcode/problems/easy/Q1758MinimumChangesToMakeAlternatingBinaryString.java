package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 3ms Beats 92.13%of users with Java
 * Memory Details 42.16MB Beats 9.18%of users with Java
 */
public class Q1758MinimumChangesToMakeAlternatingBinaryString {

    @Test
    public void test() {
        assertThat(minOperations("0100")).isEqualTo(1);
        assertThat(minOperations("10")).isEqualTo(0);
        assertThat(minOperations("1111")).isEqualTo(2);
    }

    public int minOperations(String s) {
        int cnt1 = 0;
        int cnt2 = 0;
        final int LENGTH = s.length();
        for (int i = 0; i < LENGTH; i++) {
            char c = s.charAt(i);
            if (c - '0' == i % 2) {
                cnt1++;
            } else {
                cnt2++;
            }
        }
        return Math.min(cnt1, cnt2);
    }

}
