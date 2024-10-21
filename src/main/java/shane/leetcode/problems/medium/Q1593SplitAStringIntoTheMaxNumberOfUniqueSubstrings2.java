package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime117msBeats6.86%
 */
public class Q1593SplitAStringIntoTheMaxNumberOfUniqueSubstrings2 {

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
        dfs(s, 0, "", new HashSet<>());
        return max;
    }

    private void dfs(String s, int i, String cur, Set<String> set) {
        if (s.length() == i) {
            if (!cur.isEmpty() && set.contains(cur)) {
                return;
            }
            if (!cur.isEmpty()) {
                set.add(cur);
            }
            max = Math.max(max, set.size());
            set.remove(cur);
            return;
        }
        char c = s.charAt(i);
        dfs(s, i + 1, cur + c, set);
        if (set.add(cur + c)) {
            dfs(s, i + 1, "", set);
            set.remove(cur + c);
        }
    }

}
