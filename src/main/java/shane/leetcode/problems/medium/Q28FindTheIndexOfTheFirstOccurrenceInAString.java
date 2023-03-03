package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 40.5 MB Beats 37.26%
 */
public class Q28FindTheIndexOfTheFirstOccurrenceInAString {

    @Test
    public void test() {
        assertThat(strStr("mississippi", "issip")).isEqualTo(4);
        assertThat(strStr("sadbutsad", "sad")).isEqualTo(0);
        assertThat(strStr("leetcode", "leeto")).isEqualTo(-1);
        assertThat(strStr("aaa", "aaaa")).isEqualTo(-1);
        assertThat(strStr("a", "a")).isEqualTo(0);
    }

    public int strStr(String haystack, String needle) {
        final int HAYSTACK_LENGTH = haystack.length();
        final int NEEDLE_LENGTH = needle.length();
        for (int i = 0; i <= HAYSTACK_LENGTH - NEEDLE_LENGTH; i++) {
            boolean same = true;
            for (int j = 0; j < NEEDLE_LENGTH && i + j < HAYSTACK_LENGTH; j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    same = false;
                    break;
                }
            }
            if (same) return i;
        }
        return -1;
    }

}
