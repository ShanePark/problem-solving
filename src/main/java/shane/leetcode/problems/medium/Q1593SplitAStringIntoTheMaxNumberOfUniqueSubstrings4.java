package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime10msBeats90.85%
 */
public class Q1593SplitAStringIntoTheMaxNumberOfUniqueSubstrings4 {

    @Test
    public void test() {
        assertThat(maxUniqueSplit("wwwzfvedwfvhsww")).isEqualTo(11);
        assertThat(maxUniqueSplit("ababccc")).isEqualTo(5);
        assertThat(maxUniqueSplit("aba")).isEqualTo(2);
        assertThat(maxUniqueSplit("aa")).isEqualTo(1);
    }

    int max = 0;

    public int maxUniqueSplit(String s) {
        max = 0;
        dfs(s, 0, new StringBuilder(), new HashSet<>());
        return max;
    }

    private void dfs(String s, int i, StringBuilder cur, Set<String> set) {
        if (s.length() - i + set.size() < max)
            return;
        if (s.length() == i) {
            max = Math.max(max, set.size());
            return;
        }
        char c = s.charAt(i);
        cur.append(c);
        dfs(s, i + 1, cur, set);
        if (set.add(cur.toString())) {
            dfs(s, i + 1, new StringBuilder(), set);
            set.remove(cur.toString());
        }
        cur.deleteCharAt(cur.length() - 1);
    }

}
