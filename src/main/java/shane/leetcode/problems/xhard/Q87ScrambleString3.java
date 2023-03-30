package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 14 ms Beats 42.91%
 * Memory 43.6 MB Beats 18.97%
 */
public class Q87ScrambleString3 {

    @Test
    public void test() {
        assertThat(isScramble("abcde", "caebd")).isFalse();
        assertThat(isScramble("abc", "cba")).isTrue();
        assertThat(isScramble("abca", "caba")).isTrue();
        assertThat(isScramble("abcdbdacbdac", "bdacabcdbdac")).isTrue();
        assertThat(isScramble("great", "rgeat")).isTrue();
        assertThat(isScramble("a", "a")).isTrue();
    }

    @Test
    public void tle() {
        assertThat(isScramble("abcdefghijklmnopq", "efghijklmnopqcadb")).isEqualTo(false);
    }

    @Test
    public void tle2() {
        assertThat(isScramble("eebaacbcbcadaaedceaaacadccd", "eadcaacabaddaceacbceaabeccd")).isEqualTo(false);
    }

    Map<String, Boolean> map = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        String str = s1 + " " + s2;
        if (map.containsKey(str)) {
            return map.get(str);
        }

        if (s1.equals(s2)) {
            return putOnMapAndReturn(str, true);
        }
        if (!containsSameChars(s1, s2)) {
            return putOnMapAndReturn(str, false);
        }

        int length = s1.length();
        for (int i = 1; i < length; i++) {
            String s1Head = s1.substring(0, i);
            String s1Tail = s1.substring(i);
            String s2Head = s2.substring(0, i);
            String s2Tail = s2.substring(i);
            if (isScramble(s1Head, s2Head) && isScramble(s1Tail, s2Tail)) {
                return putOnMapAndReturn(str, true);
            }
            String s2cut2Head = s2.substring(0, length - i);
            String s2cut2Tail = s2.substring(length - i);
            if (isScramble(s1Head, s2cut2Tail) && isScramble(s1Tail, s2cut2Head)) {
                return putOnMapAndReturn(str, true);
            }
        }
        return putOnMapAndReturn(str, false);
    }

    private boolean putOnMapAndReturn(String str, boolean result) {
        map.put(str, result);
        return result;
    }

    private static boolean containsSameChars(String s1, String s2) {
        int length = s1.length();
        int arr[] = new int[26];
        for (int i = 0; i < length; i++) {
            arr[s1.charAt(i) - 'a']++;
            arr[s2.charAt(i) - 'a']--;
        }
        return Arrays.stream(arr).filter(i -> i != 0).findAny().isEmpty();
    }

}
