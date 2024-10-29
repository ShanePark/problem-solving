package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime15msBeats50.00%
 * This problem is very tricky
 */
public class Q2684MaximumNumberOfMovesInAGrid {

    @Test
    public void test() {
        assertThat(maxMoves(Ps.intArray("[" +
                "[187,167,209,251,152,236,263,128,135]," +
                "[267,249,251,285, 73,204, 70,207, 74]," +
                "[189,159,235, 66, 84, 89,153,111,189]," +
                "[120, 81,210,  7,  2,231, 92,128,218]," +
                "[193,131,244,293,284,175,226,205,245]]"))).isEqualTo(3);
        assertThat(maxMoves(Ps.intArray("[[3,2,4],[2,1,9],[1,1,7]]"))).isEqualTo(0);
        assertThat(maxMoves(Ps.intArray("[[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]"))).isEqualTo(3);
    }

    public int maxMoves(int[][] grid) {
        final int HEIGHT = grid.length;
        final int WIDTH = grid[0].length;
        int[][] dp = new int[HEIGHT][WIDTH];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }
        for (int[] ints : dp) {
            ints[0] = 0;
        }
        int max = 0;
        for (int j = 1; j < WIDTH; j++) {
            for (int i = 0; i < HEIGHT; i++) {
                int cur = grid[i][j];
                if (i > 0 && grid[i - 1][j - 1] < cur) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
                }
                if (grid[i][j - 1] < cur) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - 1] + 1);
                }
                if (i < HEIGHT - 1 && grid[i + 1][j - 1] < cur) {
                    dp[i][j] = Math.max(dp[i][j], dp[i + 1][j - 1] + 1);
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

}
