package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1208 ms Beats 5.55% of users with Java
 */
public class Q2370LongestIdealSubsequence {

    @Test
    public void test() {
        assertThat(longestIdealString("lkpkxcigcs", 6)).isEqualTo(7);
        assertThat(longestIdealString("acfgdb", 2)).isEqualTo(4);
        assertThat(longestIdealString("abcd", 3)).isEqualTo(4);
    }

    public int longestIdealString(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();
        for (char cur : s.toCharArray()) {
            Map<Character, Integer> nextMap = new HashMap<>();
            for (Map.Entry<Character, Integer> e : map.entrySet()) {
                // skip
                nextMap.put(e.getKey(), Math.max(nextMap.getOrDefault(e.getKey(), 0), e.getValue()));

                // add
                if (k < Math.abs(cur - e.getKey())) {
                    continue;
                }
                int curOld = nextMap.getOrDefault(cur, 0);
                nextMap.put(cur, Math.max(curOld, e.getValue() + 1));
            }
            if (!nextMap.containsKey(cur)) {
                nextMap.put(cur, 1);
            }
            map = nextMap;
        }
        return map.values().stream().mapToInt(Integer::valueOf).max().getAsInt();
    }

}
