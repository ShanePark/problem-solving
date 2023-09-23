package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Java Runtime 24 ms Beats 96.25%
 * Memory 43.8 MB Beats 27.48%
 */
public class Q1048LongestStringChain4 {

    @Test
    public void test() {
        assertThat(longestStrChain(new String[]{"qyssedya", "pabouk", "mjwdrbqwp", "vylodpmwp", "nfyqeowa", "pu", "paboukc", "qssedya", "lopmw", "nfyqowa", "vlodpmw", "mwdrqwp", "opmw", "qsda", "neo", "qyssedhyac", "pmw", "lodpmw", "mjwdrqwp", "eo", "nfqwa", "pabuk", "nfyqwa", "qssdya", "qsdya", "qyssedhya", "pabu", "nqwa", "pabqoukc", "pbu", "mw", "vlodpmwp", "x", "xr"}))
                .isEqualTo(8);
        assertThat(longestStrChain(new String[]{"a", "ab", "ac", "bd", "abc", "abd", "abdd"})).isEqualTo(4);
        assertThat(longestStrChain(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"})).isEqualTo(5);
        assertThat(longestStrChain(new String[]{"abcd", "dbqca"})).isEqualTo(1);
    }

    public int longestStrChain(String[] words) {
        Map<Integer, List<String>> map = new HashMap<>();
        int longest = 0;
        for (String word : words) {
            int length = word.length();
            longest = Math.max(longest, length);
            map.compute(length, (k, v) -> {
                if (v == null) {
                    v = new ArrayList<>();
                }
                v.add(word);
                return v;
            });
        }

        Map<String, Integer> lengthMap = new HashMap<>();
        int max = 0;
        for (int i = 1; i <= longest; i++) {
            for (String cur : map.getOrDefault(i, Collections.emptyList())) {
                int curLength = lengthMap.getOrDefault(cur, 1);
                max = Math.max(max, curLength);
                for (String next : map.getOrDefault(i + 1, Collections.emptyList())) {
                    int nextLength = lengthMap.getOrDefault(next, 1);
                    if (curLength + 1 <= nextLength)
                        continue;
                    if (isPredecessor(cur, next)) {
                        lengthMap.put(next, curLength + 1);
                    }
                }
            }
        }

        return max;
    }

    private boolean isPredecessor(String cur, String next) {
        boolean flag = false;
        for (int i = 0; i < cur.length(); i++) {
            char c1 = cur.charAt(i);
            char c2 = next.charAt(flag ? i + 1 : i);
            if (c1 != c2) {
                if (flag)
                    return false;
                flag = true;
                i--;
            }
        }
        return true;
    }

}
