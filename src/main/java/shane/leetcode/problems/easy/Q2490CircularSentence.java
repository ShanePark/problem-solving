package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime1msBeats96.81%
 */
public class Q2490CircularSentence {

    @Test
    public void test() {
        assertThat(isCircularSentence("leetcode exercises sound delightful")).isTrue();
        assertThat(isCircularSentence("eetcode")).isTrue();
        assertThat(isCircularSentence("Leetcode is cool")).isFalse();
    }

    public boolean isCircularSentence(String sentence) {
        String[] split = sentence.split(" ");
        for (int i = 1; i < split.length; i++) {
            String before = split[i - 1];
            String cur = split[i];
            if (before.charAt(before.length() - 1) != cur.charAt(0)) {
                return false;
            }
        }
        String first = split[0];
        String last = split[split.length - 1];
        return first.charAt(0) == last.charAt(last.length() - 1);
    }

}
