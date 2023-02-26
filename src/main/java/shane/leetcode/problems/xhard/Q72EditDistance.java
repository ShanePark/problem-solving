package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 6 ms Beats 67.73% Memory 43.1 MB Beats 22.16%a
 * Not my own idea
 */
public class Q72EditDistance {

    @Test
    void test() {
        assertThat(minDistance("horse", "ros")).isEqualTo(3);
        assertThat(minDistance("intention", "execution")).isEqualTo(5);
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++)
            dp[i][0] = i;
        for (int j = 1; j <= word2.length(); j++)
            dp[0][j] = j;

        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                    continue;
                }
                dp[i + 1][j + 1] = Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j])) + 1;
            }
        }
        return dp[word1.length()][word2.length()];
    }

}
