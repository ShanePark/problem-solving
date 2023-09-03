package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 0ms Beats 100.00%of users with Java
 * Memory Details 39.81MB Beats 8.49%of users with Java
 */
public class Q62UniquePaths2 {

    @Test
    public void test() {
        assertThat(uniquePaths(3, 7)).isEqualTo(28);
        assertThat(uniquePaths(3, 2)).isEqualTo(3);
        assertThat(uniquePaths(1, 1)).isEqualTo(1);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[m - 1][n - 1] = 1;
        return dfs(0, 0, dp);
    }

    private int dfs(int i, int j, int[][] dp) {
        if (dp[i][j] != 0)
            return dp[i][j];
        int answer = 0;
        if (i < dp.length - 1) {
            answer += dfs(i + 1, j, dp);
        }
        if (j < dp[0].length - 1) {
            answer += dfs(i, j + 1, dp);
        }
        return dp[i][j] = answer;
    }

}
