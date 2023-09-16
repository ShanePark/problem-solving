package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE 75 / 75 testcases passed
 */
@SuppressWarnings("ALL")
public class Q1631PathWithMinimumEffort5 {

    @Test
    public void test() {
        assertThat(minimumEffortPath(Ps.intArray("[[1,2,2],[3,8,2],[5,3,5]]"))).isEqualTo(2);
        assertThat(minimumEffortPath(Ps.intArray("[[1,2,3],[3,8,4],[5,3,5]]"))).isEqualTo(1);
        assertThat(minimumEffortPath(Ps.intArray("[[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]"))).isEqualTo(0);
    }

    public int minimumEffortPath(int[][] heights) {
        int HEIGHT = heights.length;
        int WIDTH = heights[0].length;
        int[][] dp = new int[HEIGHT][WIDTH];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        move(0, 0, 0, heights, dp);

        return dp[HEIGHT - 1][WIDTH - 1];
    }

    final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    private void move(int i, int j, int currentMax, int[][] heights, int[][] dp) {
        dp[i][j] = currentMax;
        for (int[] dir : DIRS) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (0 <= y && y < heights.length && 0 <= x && x < heights[0].length) {
                int next = Math.max(currentMax, Math.abs(heights[i][j] - heights[y][x]));
                if (next < dp[y][x]) {
                    move(y, x, next, heights, dp);
                }
            }
        }
    }

}
