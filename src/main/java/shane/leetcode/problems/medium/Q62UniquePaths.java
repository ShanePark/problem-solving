package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
 * Memory Usage: 40.6 MB, less than 76.55% of Java online submissions for Unique Paths.
 */
public class Q62UniquePaths {

    @Test
    public void test() {
        assertThat(uniquePaths(3, 7)).isEqualTo(28);
        assertThat(uniquePaths(3, 2)).isEqualTo(3);
        assertThat(uniquePaths(1, 1)).isEqualTo(1);
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

}
