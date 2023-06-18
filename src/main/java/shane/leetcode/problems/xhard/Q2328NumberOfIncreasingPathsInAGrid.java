package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 52 ms Beats 60.43%
 * Memory 69.7 MB Beats 8.63%
 */
public class Q2328NumberOfIncreasingPathsInAGrid {

    @Test
    void test() {
        assertThat(countPaths(Ps.intArray("[[1,1],[3,4]]"))).isEqualTo(8);
        assertThat(countPaths(Ps.intArray("[[1],[2]]"))).isEqualTo(3);
    }

    final int MOD = (int) 1e9 + 7;
    final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int countPaths(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[][] dp = new int[height][width];

        int result = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result = (result + dfs(grid, i, j, dp)) % MOD;
            }
        }
        return result;

    }

    private int dfs(int[][] grid, int i, int j, int[][] dp) {
        if (dp[i][j] > 0)
            return dp[i][j];
        int result = 1;
        int curValue = grid[i][j];
        for (int[] dir : DIRS) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (0 <= y && y < grid.length && 0 <= x && x < grid[0].length && curValue < grid[y][x]) {
                result = (result + dfs(grid, y, x, dp)) % MOD;
            }
        }
        dp[i][j] = result;
        return dp[i][j];
    }

}
