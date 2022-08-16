package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 2 ms, faster than 68.48% of Java online submissions for Substrings of Size Three with Distinct Characters.
 * Memory Usage: 42.1 MB, less than 70.63% of Java online submissions for Substrings of Size Three with Distinct Characters.
 */
public class Q1876SubstringsOfSizeThreeWithDistinctCharacters2 {

    @Test
    public void test() {
        assertThat(countGoodSubstrings("xyzzaz")).isEqualTo(1);
        assertThat(countGoodSubstrings("aababcabc")).isEqualTo(4);
    }

    public int countGoodSubstrings(String s) {
        int cnt = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            char first = s.charAt(i);
            char second = s.charAt(i + 1);
            char third = s.charAt(i + 2);
            if (first != second && second != third && third != first) {
                cnt++;
            }
        }
        return cnt;
    }
}
