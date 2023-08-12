package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details -ms Beats 100.00%of users with Java
 * Memory Details 40.52mb Beats 72.53%of users with Java
 */
public class Q63UniquePathsII2 {

    @Test
    public void test() {
        assertThat(uniquePathsWithObstacles(Ps.intArray("[[0,0,0],[0,1,0],[0,0,0]]"))).isEqualTo(2);
        assertThat(uniquePathsWithObstacles(Ps.intArray("[[0,1],[0,0]]"))).isEqualTo(1);
        assertThat(uniquePathsWithObstacles(Ps.intArray("[[0]]"))).isEqualTo(1);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int HEIGHT = obstacleGrid.length;
        final int WIDTH = obstacleGrid[0].length;
        Integer[][] dp = new Integer[HEIGHT][WIDTH];
        dp[HEIGHT - 1][WIDTH - 1] = 1;

        return dfs(obstacleGrid, dp, 0, 0, HEIGHT, WIDTH);
    }

    private int dfs(int[][] obstacleGrid, Integer[][] dp, int i, int j, int HEIGHT, int WIDTH) {
        if (obstacleGrid[i][j] == 1)
            return 0;
        if (dp[i][j] != null)
            return dp[i][j];
        int sum = 0;
        // down
        if (i < HEIGHT - 1) {
            sum += dfs(obstacleGrid, dp, i + 1, j, HEIGHT, WIDTH);
        }
        // right
        if (j < WIDTH - 1) {
            sum += dfs(obstacleGrid, dp, i, j + 1, HEIGHT, WIDTH);
        }
        dp[i][j] = sum;
        return sum;
    }

}
