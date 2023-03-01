package shane.leetcode.contest.weekly.w289;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2245MaximumTrailingZerosInACorneredPath {

    @Test
    public void test() {
        assertThat(maxTrailingZeros(Ps.intArray("[[23,17,15,3,20],[8,1,20,27,11],[9,4,6,2,21],[40,9,1,10,6],[22,7,4,5,3]]"))).isEqualTo(3);
        assertThat(maxTrailingZeros(Ps.intArray("[[3,3,5],[3,3,5],[2,2,10]]"))).isEqualTo(3);
    }

    public int maxTrailingZeros(int[][] grid) {
        final int HEIGHT = grid.length;
        final int WIDTH = grid[0].length;

        // [][][0] = count of 2, [][][1] = count of 5
        int[][][] toRight = new int[HEIGHT][WIDTH][2];
        int[][][] toDown = new int[HEIGHT][WIDTH][2];

        for (int i = 0; i < HEIGHT; i++) {
            int count2 = 0;
            int count5 = 0;
            for (int j = 0; j < WIDTH; j++) {
                count5 += countN(grid[i][j], 5);
                count2 += countN(grid[i][j], 2);
                toRight[i][j][0] = count2;
                toRight[i][j][1] = count5;
            }
        }

        for (int j = 0; j < WIDTH; j++) {
            int count2 = 0;
            int count5 = 0;
            for (int i = 0; i < HEIGHT; i++) {
                count5 += countN(grid[i][j], 5);
                count2 += countN(grid[i][j], 2);
                toDown[i][j][0] = count2;
                toDown[i][j][1] = count5;
            }
        }

        int max = 0;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                int[] cur = {countN(grid[i][j], 2), countN(grid[i][j], 5)};
                int leftTop = Math.min(
                        toRight[i][j][0] + toDown[i][j][0] - cur[0],
                        toRight[i][j][1] + toDown[i][j][1] - cur[1]
                );
                int rightTop = Math.min(
                        toRight[i][WIDTH - 1][0] - (j == 0 ? 0 : toRight[i][j - 1][0]) + toDown[i][j][0] - cur[0],
                        toRight[i][WIDTH - 1][1] - (j == 0 ? 0 : toRight[i][j - 1][1]) + toDown[i][j][1] - cur[1]
                );
                int leftBottom = Math.min(
                        toRight[i][j][0] + toDown[HEIGHT - 1][j][0] - (i == 0 ? 0 : toDown[i - 1][j][0]) - cur[0],
                        toRight[i][j][1] + toDown[HEIGHT - 1][j][1] - (i == 0 ? 0 : toDown[i - 1][j][1]) - cur[1]
                );
                int rightBottom = Math.min(
                        toRight[i][WIDTH - 1][0] + toDown[HEIGHT - 1][j][0] - (i == 0 ? 0 : toDown[i - 1][j][0]) - (j == 0 ? 0 : toRight[i][j - 1][0]) - cur[0],
                        toRight[i][WIDTH - 1][1] + toDown[HEIGHT - 1][j][1] - (i == 0 ? 0 : toDown[i - 1][j][1]) - (j == 0 ? 0 : toRight[i][j - 1][1]) - cur[1]
                );
                max = Math.max(max, leftTop);
                max = Math.max(max, rightTop);
                max = Math.max(max, leftBottom);
                max = Math.max(max, rightBottom);
            }
        }

        return max;
    }

    private int countN(int i, int n) {
        int cnt = 0;
        while (i % n == 0) {
            cnt++;
            i /= n;
        }
        return cnt;
    }

}
