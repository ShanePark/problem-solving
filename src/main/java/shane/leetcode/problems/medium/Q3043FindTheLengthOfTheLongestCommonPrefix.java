package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime174msBeats25.82%
 */
public class Q3043FindTheLengthOfTheLongestCommonPrefix {

    @Test
    public void est() {
        assertThat(longestCommonPrefix(new int[]{1, 10, 100}, new int[]{100000000})).isEqualTo(3);
        assertThat(longestCommonPrefix(new int[]{1, 10, 100}, new int[]{1000})).isEqualTo(3);
        assertThat(longestCommonPrefix(new int[]{1, 2, 3}, new int[]{4, 4, 4})).isEqualTo(0);
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        final int DIGITS = 9;
        Set<Integer>[] sets1 = new Set[DIGITS];
        Set<Integer>[] sets2 = new Set[DIGITS];
        for (int i = 0; i < sets1.length; i++) {
            sets1[i] = new HashSet<>();
            sets2[i] = new HashSet<>();
        }
        for (int i : arr1) {
            while (i > 0) {
                int length = getLength(i);
                sets1[length - 1].add(i);
                i /= 10;
            }
        }
        for (int i : arr2) {
            while (i > 0) {
                int length = getLength(i);
                sets2[length - 1].add(i);
                i /= 10;
            }
        }
        for (int i = DIGITS - 1; i >= 0; i--) {
            sets1[i].retainAll(sets2[i]);
            if (!sets1[i].isEmpty()) {
                return i + 1;
            }
        }
        return 0;
    }

    private static int getLength(int i) {
        return (int) Math.log10(i) + 1;
    }

}
