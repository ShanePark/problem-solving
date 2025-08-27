package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not mine
 */
public class Q3459LengthOfLongestVShapedDiagonalSegment {

    @Test
    public void test() {
        assertThat(lenOfVDiagonal(Ps.intArray("[[2,2,1,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]"))).isEqualTo(5);
        assertThat(lenOfVDiagonal(Ps.intArray("[[2,2,2,2,2],[2,0,2,2,0],[2,0,1,1,0],[1,0,2,2,2],[2,0,0,2,2]]"))).isEqualTo(4);
    }

    final int[][] DIRS = {{-1, 1}, {1, 1}, {1, -1}, {-1, -1}};

    public int lenOfVDiagonal(int[][] grid) {
        final int HEIGHT = grid.length;
        final int WIDTH = grid[0].length;

        int maxLength = 0;
        for (int row = 0; row < HEIGHT; row++) {
            for (int col = 0; col < WIDTH; col++) {
                if (grid[row][col] == 1) {
                    maxLength = Math.max(maxLength, 1);
                    for (int dir = 0; dir < DIRS.length; dir++) {
                        maxLength = Math.max(maxLength, dfs(grid, row, col, dir, 2, false));
                    }
                }
            }
        }
        return maxLength;
    }

    private int dfs(int[][] grid, int row, int col, int direction, int target, boolean hasTurned) {
        int y = row + DIRS[direction][0];
        int x = col + DIRS[direction][1];

        if (isOutOfBounds(grid, y, x) || grid[y][x] != target) {
            return 1;
        }

        int nextTarget = (target == 2) ? 0 : 2;
        int straightPath = 1 + dfs(grid, y, x, direction, nextTarget, hasTurned);

        if (hasTurned) {
            return straightPath;
        }

        return Math.max(straightPath, 1 + dfs(grid, y, x, (direction + 1) % 4, nextTarget, true));
    }

    private boolean isOutOfBounds(int[][] grid, int row, int col) {
        return row < 0 || row >= grid.length || col < 0 || col >= grid[0].length;
    }

}
