package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q3197FindTheMinimumAreaToCoverAllOnesII {

    @Test
    public void test() {
        assertThat(minimumSum(Ps.intArray("[[1,0,1],[1,1,1]]"))).isEqualTo(5);
        assertThat(minimumSum(Ps.intArray("[[1,0,1,0],[0,1,0,1]]"))).isEqualTo(5);
    }

    public int minimumSum(int[][] grid) {
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < grid.length - 1; i++) {
            result = Math.min(result, oneRect(grid, 0, 0, i, grid[0].length - 1) + twoRects(grid, i + 1, 0, grid.length - 1, grid[0].length - 1));
            result = Math.min(result, twoRects(grid, 0, 0, i, grid[0].length - 1) + oneRect(grid, i + 1, 0, grid.length - 1, grid[0].length - 1));
        }

        for (int j = 0; j < grid[0].length - 1; j++) {
            result = Math.min(result, oneRect(grid, 0, 0, grid.length - 1, j) + twoRects(grid, 0, j + 1, grid.length - 1, grid[0].length - 1));
            result = Math.min(result, twoRects(grid, 0, 0, grid.length - 1, j) + oneRect(grid, 0, j + 1, grid.length - 1, grid[0].length - 1));
        }

        return result;
    }

    int twoRects(int[][] grid, int r1, int c1, int r2, int c2) {
        int min = Integer.MAX_VALUE;
        for (int i = r1; i < r2; i++) {
            min = Math.min(min, oneRect(grid, r1, c1, i, c2) + oneRect(grid, i + 1, c1, r2, c2));
        }
        for (int j = c1; j < c2; j++) {
            min = Math.min(min, oneRect(grid, r1, c1, r2, j) + oneRect(grid, r1, j + 1, r2, c2));
        }
        return min;
    }

    int oneRect(int[][] grid, int r1, int c1, int r2, int c2) {
        int minR = r2, maxR = r1, minC = c2, maxC = c1;
        boolean found = false;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i][j] == 1) {
                    found = true;
                    minR = Math.min(minR, i);
                    maxR = Math.max(maxR, i);
                    minC = Math.min(minC, j);
                    maxC = Math.max(maxC, j);
                }
            }
        }
        return found ? (maxR - minR + 1) * (maxC - minC + 1) : Integer.MAX_VALUE / 4;
    }

}
