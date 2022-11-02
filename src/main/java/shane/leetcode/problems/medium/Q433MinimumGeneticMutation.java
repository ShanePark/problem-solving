package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 1 ms, faster than 92.51% of Java online submissions for Minimum Genetic Mutation.
 * Memory Usage: 41.6 MB, less than 71.12% of Java online submissions for Minimum Genetic Mutation.
 */
public class Q433MinimumGeneticMutation {

    @Test
    public void test() {
        assertThat(minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"})).isEqualTo(1);
        assertThat(minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"})).isEqualTo(2);
        assertThat(minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"})).isEqualTo(3);
        assertThat(minMutation("AACCGGTT", "AACCGGTA", new String[]{})).isEqualTo(-1);
    }

    @Test
    public void testDiffOne() {
        assertThat(diffOne("AACCGGTT", "AACCGGTA")).isTrue();
    }

    int min;

    public int minMutation(String start, String end, String[] bank) {
        min = Integer.MAX_VALUE;
        dfs(start, end, 0, bank, new boolean[bank.length]);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void dfs(String cur, String target, int cnt, String[] bank, boolean[] booleans) {
        if (cur.equals(target)) {
            min = Math.min(min, cnt);
            return;
        }
        for (int i = 0; i < bank.length; i++) {
            if (booleans[i])
                continue;
            String s = bank[i];
            if (diffOne(cur, s)) {
                booleans[i] = true;
                dfs(s, target, cnt + 1, bank, booleans);
                booleans[i] = false;
            }
        }
    }

    private boolean diffOne(String cur, String s) {
        boolean different = false;
        for (int i = 0; i < cur.length(); i++) {
            if (cur.charAt(i) != s.charAt(i)) {
                if (different)
                    return false;
                different = true;
            }
        }
        return true;
    }
}
