package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q329LongestIncreasingPathInAMatrix {

    @Test
    public void test() {
        assertThat(longestIncreasingPath(Ps.intArray("[[9,9,4],[6,6,8],[2,1,1]]"))).isEqualTo(4);
        assertThat(longestIncreasingPath(Ps.intArray("[[3,4,5],[3,2,6],[2,2,1]]"))).isEqualTo(4);
        assertThat(longestIncreasingPath(Ps.intArray("[[1]]"))).isEqualTo(1);
        assertThat(longestIncreasingPath(Ps.intArray("[[0,1,2,3,4,5,6,7,8,9],[19,18,17,16,15,14,13,12,11,10],[20,21,22,23,24,25,26,27,28,29],[39,38,37,36,35,34,33,32,31,30],[40,41,42,43,44,45,46,47,48,49],[59,58,57,56,55,54,53,52,51,50],[60,61,62,63,64,65,66,67,68,69],[79,78,77,76,75,74,73,72,71,70],[80,81,82,83,84,85,86,87,88,89],[99,98,97,96,95,94,93,92,91,90],[100,101,102,103,104,105,106,107,108,109],[119,118,117,116,115,114,113,112,111,110],[120,121,122,123,124,125,126,127,128,129],[139,138,137,136,135,134,133,132,131,130],[0,0,0,0,0,0,0,0,0,0]]")))
                .isEqualTo(140);
    }

    public int longestIncreasingPath(int[][] matrix) {
        final int HEIGHT = matrix.length;
        final int WIDTH = matrix[0].length;

        int[][] dp = new int[HEIGHT][WIDTH];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }

        int max = 0;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                max = Math.max(max, dfs(i, j, matrix, dp));
            }
        }

        return max;

    }

    private int dfs(int y, int x, int[][] matrix, int[][] dp) {
        if (dp[y][x] >= 0)
            return dp[y][x];

        int up = 0, down = 0, left = 0, right = 0;
        // up
        if (y > 0 && matrix[y - 1][x] > matrix[y][x]) {
            if (dp[y - 1][x] >= 0) {
                up = dp[y - 1][x];
            } else {
                up = dfs(y - 1, x, matrix, dp);
            }
        }

        // down
        if (y < matrix.length - 1 && matrix[y + 1][x] > matrix[y][x]) {
            if (dp[y + 1][x] >= 0) {
                down = dp[y + 1][x];
            } else {
                down = dfs(y + 1, x, matrix, dp);
            }
        }

        // left
        if (x > 0 && matrix[y][x - 1] > matrix[y][x]) {
            if (dp[y][x - 1] >= 0) {
                left = dp[y][x - 1];
            } else {
                left = dfs(y, x - 1, matrix, dp);
            }
        }

        // right
        if (x < matrix[0].length - 1 && matrix[y][x + 1] > matrix[y][x]) {
            if (dp[y][x + 1] >= 0) {
                right = dp[y][x + 1];
            } else {
                right = dfs(y, x + 1, matrix, dp);
            }
        }

        dp[y][x] = Math.max(Math.max(left, right), Math.max(up, down)) + 1;
        return dp[y][x];
    }
}
