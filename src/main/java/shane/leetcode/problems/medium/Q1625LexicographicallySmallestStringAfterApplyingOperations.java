package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 62
 * ms
 * Beats
 * 80.90%
 */
public class Q1625LexicographicallySmallestStringAfterApplyingOperations {

    @Test
    public void test() {
        assertThat(findLexSmallestString("5525", 9, 2)).isEqualTo("2050");
        assertThat(findLexSmallestString("74", 5, 1)).isEqualTo("24");
        assertThat(findLexSmallestString("0011", 4, 2)).isEqualTo("0011");
    }

    public String findLexSmallestString(String s, int a, int b) {
        HashSet<String> visited = new HashSet<>();
        String[] result = {s};
        dfs(visited, s, a, b, result);
        return result[0];
    }

    private void dfs(HashSet<String> visited, String s, int a, int b, String[] result) {
        if (!visited.add(s))
            return;

        if (s.compareTo(result[0]) < 0) {
            result[0] = s;
        }

        // do b
        dfs(visited, s.substring(b) + s.substring(0, b), a, b, result);

        // do a
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i += 2) {
            int n = (chars[i] - '0' + a) % 10;
            chars[i] = (char) ('0' + n);
        }
        dfs(visited, new String(chars), a, b, result);
    }

}
