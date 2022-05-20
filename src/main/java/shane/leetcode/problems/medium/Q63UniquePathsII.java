package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q63UniquePathsII {

    @Test
    public void test() {
        assertThat(uniquePathsWithObstacles(STool.convertToIntArray("[[0,0,0],[0,1,0],[0,0,0]]"))).isEqualTo(2);
        assertThat(uniquePathsWithObstacles(STool.convertToIntArray("[[0,1],[0,0]]"))).isEqualTo(1);
        assertThat(uniquePathsWithObstacles(STool.convertToIntArray("[[0]]"))).isEqualTo(1);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        final int HEIGHT = obstacleGrid.length;
        final int WIDTH = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[HEIGHT - 1][WIDTH - 1] == 1) {
            return 0;
        } else if (HEIGHT == 1 && WIDTH == 1) {
            return 1;
        }

        int[][] memo = new int[HEIGHT][WIDTH];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }

        dfs(0, 0, obstacleGrid, memo, HEIGHT, WIDTH);

        return memo[0][0];
    }

    private int dfs(int y, int x, int[][] obstacleGrid, int[][] memo, int HEIGHT, int WIDTH) {
        if (memo[y][x] >= 0) {
            return memo[y][x];
        }

        if (y == HEIGHT - 1 && x == WIDTH - 1) {
            return 1;
        }

        int down = 0, right = 0;

        // down
        if (y < HEIGHT - 1 && obstacleGrid[y + 1][x] == 0) {
            down = dfs(y + 1, x, obstacleGrid, memo, HEIGHT, WIDTH);
        }

        // right
        if (x < WIDTH - 1 && obstacleGrid[y][x + 1] == 0) {
            right = dfs(y, x + 1, obstacleGrid, memo, HEIGHT, WIDTH);
        }

        memo[y][x] = down + right;

        return memo[y][x];

    }

}
