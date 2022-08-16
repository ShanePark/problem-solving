package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 8 ms, faster than 15.32% of Java online submissions for Substrings of Size Three with Distinct Characters.
 * Memory Usage: 42.4 MB, less than 49.87% of Java online submissions for Substrings of Size Three with Distinct Characters.
 */
public class Q1876SubstringsOfSizeThreeWithDistinctCharacters {

    @Test
    public void test() {
        assertThat(countGoodSubstrings("xyzzaz")).isEqualTo(1);
        assertThat(countGoodSubstrings("aababcabc")).isEqualTo(4);
    }

    public int countGoodSubstrings(String s) {
        final int LENGTH = s.length();
        if (LENGTH < 3)
            return 0;

        HashMap<Character, Integer> exceedMap = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            char c = s.charAt(i);
            if (!set.add(c)) {
                exceedMap.merge(c, 1, Integer::sum);
            }
        }

        int cnt = exceedMap.isEmpty() ? 1 : 0;

        for (int i = 3; i < LENGTH; i++) {
            char before = s.charAt(i - 3);
            Integer beforeCnt = exceedMap.get(before);
            if (beforeCnt == null) {
                set.remove(before);
            } else if (beforeCnt == 1) {
                exceedMap.remove(before);
            } else {
                exceedMap.merge(before, -1, Integer::sum);
            }
            char next = s.charAt(i);
            if (!set.add(next)) {
                exceedMap.merge(next, 1, Integer::sum);
            }
            if (exceedMap.isEmpty()) {
                cnt++;
            }
        }
        return cnt;
    }
}
