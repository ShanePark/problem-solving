package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q87ScrambleString {

    @Test
    public void test() {
        assertThat(isScramble("abc", "cba")).isTrue();
        assertThat(isScramble("abca", "caba")).isTrue();
        assertThat(isScramble("abcdbdacbdac", "bdacabcdbdac")).isTrue();
        assertThat(isScramble("great", "rgeat")).isTrue();
        assertThat(isScramble("abcde", "caebd")).isFalse();
        assertThat(isScramble("a", "a")).isTrue();
    }

    /**
     * 2 sec 862 ms
     */
    @Test
    public void tle() {
        assertThat(isScramble("abcdefghijklmnopq", "efghijklmnopqcadb")).isEqualTo(false);
    }

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2))
            return true;
        int length = s1.length();
        for (int i = 1; i < length; i++) {
            String s1Head = s1.substring(0, i);
            String s1Tail = s1.substring(i);
            String s2Head = s2.substring(0, i);
            String s2Tail = s2.substring(i);
            if (isScramble(s1Head, s2Head) && isScramble(s1Tail, s2Tail)) {
                return true;
            }
            String s2cut2Head = s2.substring(0, length - i);
            String s2cut2Tail = s2.substring(length - i);
            if (isScramble(s1Head, s2cut2Tail) && isScramble(s1Tail, s2cut2Head))
                return true;
        }
        return false;
    }

}
