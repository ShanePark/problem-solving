package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 175
 * ms
 * Beats
 * 6.74%
 */
public class Q1625LexicographicallySmallestStringAfterApplyingOperations {

    @Test
    public void test() {
        assertThat(findLexSmallestString("5525", 9, 2)).isEqualTo("2050");
        assertThat(findLexSmallestString("74", 5, 1)).isEqualTo("24");
        assertThat(findLexSmallestString("0011", 4, 2)).isEqualTo("0011");
    }

    public String findLexSmallestString(String s, int a, int b) {
        TreeSet<String> visited = new TreeSet<>();
        dfs(visited, s, a, b);
        return visited.first();
    }

    private void dfs(TreeSet<String> visited, String s, int a, int b) {
        if (!visited.add(s))
            return;
        // do b
        dfs(visited, s.substring(b) + s.substring(0, b), a, b);

        // do a
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int n = s.charAt(i) - '0';
            if (i % 2 == 1) {
                n = (n + a) % 10;
            }
            sb.append(n);
        }
        dfs(visited, sb.toString(), a, b);
    }

}
