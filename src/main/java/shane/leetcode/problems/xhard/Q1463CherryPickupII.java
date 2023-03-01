package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 40 ms Beats 82.11%
 * Memory 53.1 MB Beats 10.39%
 */
public class Q1463CherryPickupII {

    @Test
    public void test() {
        assertThat(cherryPickup(Ps.intArray("[[1,0,0,3],[0,0,0,3],[0,0,3,3],[9,0,3,3]]"))).isEqualTo(22);
        assertThat(cherryPickup(Ps.intArray("[[3,1,1],[2,5,1],[1,5,5],[2,1,1]]"))).isEqualTo(24);
        assertThat(cherryPickup(Ps.intArray("[[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]"))).isEqualTo(28);
    }

    public int cherryPickup(int[][] grid) {
        Integer[][][] dp = new Integer[grid.length][grid[0].length][grid[0].length];
        int result = dfs(grid, 0, 0, grid[0].length - 1, dp);
        return result;
    }

    private int dfs(int[][] grid, int i, int j1, int j2, Integer[][][] dp) {
        if (i == grid.length)
            return 0;
        if (dp[i][j1][j2] == null) {
            int maxNext = 0;
            for (int move1 = j1 - 1; move1 <= j1 + 1; move1++) {
                for (int move2 = j2 - 1; move2 <= j2 + 1; move2++) {
                    if (0 <= move1 && move1 < grid[0].length && 0 <= move2 && move2 < grid[0].length) {
                        maxNext = Math.max(maxNext, dfs(grid, i + 1, move1, move2, dp));
                    }
                }
            }
            int cherries = grid[i][j1] + grid[i][j2];
            if (j1 == j2) {
                cherries /= 2;
            }
            dp[i][j1][j2] = cherries + maxNext;
        }
        return dp[i][j1][j2];
    }

}
