package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 7 ms Beats 79.95%
 * Memory 43.4 MB Beats 28.73%
 */
public class Q688KnightProbabilityInChessboard {

    @Test
    void test() {
        assertThat(knightProbability(3, 2, 0, 0)).isEqualTo(0.0625);
        assertThat(knightProbability(1, 0, 0, 0)).isEqualTo(1);
    }

    public double knightProbability(int n, int k, int row, int column) {
        Double[][][] dp = new Double[n][n][k + 1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j][0] = 1d;
            }
        }

        return dfs(dp, row, column, n, k);
    }

    int[][] DIRS = new int[][]{{-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

    private double dfs(Double[][][] dp, int y, int x, int n, int k) {
        if (dp[y][x][k] != null) {
            return dp[y][x][k];
        }
        double sum = 0;
        for (int[] dir : DIRS) {
            int nextY = y + dir[0];
            int nextX = x + dir[1];
            if (0 <= nextY && nextY < n && 0 <= nextX && nextX < n) {
                sum += dfs(dp, nextY, nextX, n, k - 1);
            }
        }
        dp[y][x][k] = sum / 8;
        return dp[y][x][k];
    }

}
