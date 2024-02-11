package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 23 ms Beats 80.35% of users with Java
 */
public class Q1463CherryPickupII2 {

    @Test
    public void test() {
        assertThat(cherryPickup(Ps.intArray("[[3,1,1],[2,5,1],[1,5,5],[2,1,1]]"))).isEqualTo(24);
        assertThat(cherryPickup(Ps.intArray("[[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,0,9,0,0,0,0],[0,3,0,5,4,0,0],[1,0,2,3,0,0,6]]"))).isEqualTo(28);
    }

    public int cherryPickup(int[][] grid) {
        final int HEIGHT = grid.length;
        final int WIDTH = grid[0].length;
        Integer[][][] dp = new Integer[HEIGHT][WIDTH][WIDTH];
        return max(grid, dp, 0, 0, WIDTH - 1);
    }

    private int max(int[][] grid, Integer[][][] dp, int row, int robot1, int robot2) {
        if (dp[row][robot1][robot2] != null)
            return dp[row][robot1][robot2];
        int sum = grid[row][robot1] + grid[row][robot2];
        if (robot1 == robot2) {
            sum -= grid[row][robot1];
        }
        if (row == grid.length - 1) {
            return dp[row][robot1][robot2] = sum;
        }
        int max = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int robot1Next = robot1 + i;
                int robot2Next = robot2 + j;
                if (robot1Next < 0 || robot1Next == grid[0].length || robot2Next < 0 || robot2Next == grid[0].length) {
                    continue;
                }
                max = Math.max(max, max(grid, dp, row + 1, robot1Next, robot2Next));
            }
        }
        return dp[row][robot1][robot2] = sum + max;
    }

}
