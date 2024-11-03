package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime0msBeats100.00%
 */
public class Q796RotateString {

    @Test
    public void test() {
        assertThat(rotateString("abcde", "cdeab")).isTrue();
        assertThat(rotateString("abcdee", "abced")).isFalse();
    }

    public boolean rotateString(String s, String goal) {
        int goalLength = goal.length();
        if (s.length() != goalLength)
            return false;
        s = s + s;
        for (int i = 0; i < goalLength; i++) {
            String str = s.substring(i, i + goalLength);
            if (str.equals(goal)) {
                return true;
            }
        }
        return false;
    }

}
