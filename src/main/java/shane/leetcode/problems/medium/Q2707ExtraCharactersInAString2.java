package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2707ExtraCharactersInAString2 {

    @Test
    public void test() {
        assertThat(minExtraChar("leetscode", new String[]{"leet", "code", "leetcode"})).isEqualTo(1);
        assertThat(minExtraChar("sayhelloworld", new String[]{"hello", "world"})).isEqualTo(3);
    }

    public int minExtraChar(String s, String[] dictionary) {
        return dfs(new Integer[s.length()], new HashSet<>(Arrays.asList(dictionary)), s, 0);
    }

    private int dfs(Integer[] dp, Set<String> dict, String s, int i) {
        if (s.length() == i)
            return 0;
        if (dp[i] != null)
            return dp[i];

        String leftOver = s.substring(i);
        int min = 1 + dfs(dp, dict, s, i + 1);

        for (String word : dict) {
            if (leftOver.startsWith(word)) {
                min = Math.min(min, dfs(dp, dict, s, i + word.length()));
            }
        }

        return dp[i] = min;
    }

}
