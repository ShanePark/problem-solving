package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 14 ms Beats 18.40%
 * Memory 54.8 MB Beats 53.12%
 */
public class Q1020NumberOfEnclaves {

    @Test
    public void test() {
        assertThat(numEnclaves(Ps.intArray("[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]"))).isEqualTo(3);
        assertThat(numEnclaves(Ps.intArray("[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]"))).isEqualTo(0);
    }

    public int numEnclaves(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int answer = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    Land land = new Land(grid, i, j);
                    if (land.isIsolated) {
                        answer += land.size;
                    }
                }
            }
        }
        return answer;
    }

    static class Land {
        int size = 0;
        boolean isIsolated = true;
        static final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public Land(int[][] grid, int i, int j) {
            dfs(grid, i, j);
        }

        private void dfs(int[][] grid, int i, int j) {
            if (i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1)
                isIsolated = false;
            grid[i][j] = 0;
            this.size++;
            for (int[] dir : DIRS) {
                int y = i + dir[0];
                int x = j + dir[1];
                if (0 <= y && y < grid.length && 0 <= x && x < grid[0].length && grid[y][x] == 1) {
                    dfs(grid, y, x);
                }
            }
        }
    }

}
