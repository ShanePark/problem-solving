package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1568MinimumNumberOfDaysToDisconnectIsland {

    @Test
    public void test() {
        assertThat(minDays(Ps.intArray("[[0,1,1,0],[0,1,1,0],[0,0,0,0]]"))).isEqualTo(2);
        assertThat(minDays(Ps.intArray("[[1,1]]"))).isEqualTo(2);
    }

    public int minDays(int[][] grid) {
        if (isDisconnected(grid)) {
            return 0;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                grid[i][j] = 0;
                if (isDisconnected(grid))
                    return 1;
                grid[i][j] = 1;
            }
        }
        return 2;
    }

    private boolean isDisconnected(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int landCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    visitLands(grid, i, j, visited);
                    landCount++;
                    if (landCount == 2)
                        return true;
                }
            }
        }
        return landCount == 0;
    }

    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0},};

    private void visitLands(int[][] grid, int row, int col, boolean[][] visited) {
        visited[row][col] = true;
        for (int[] direction : DIRS) {
            int i = row + direction[0];
            int j = col + direction[1];
            if ((i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1 && !visited[i][j])) {
                visitLands(grid, i, j, visited);
            }
        }
    }

}
