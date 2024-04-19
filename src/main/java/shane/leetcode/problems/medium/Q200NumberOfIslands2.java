package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3 ms Beats 86.63% of users with Java
 */
public class Q200NumberOfIslands2 {

    @Test
    public void test() {
        assertThat(numIslands(Ps.charArray("[\n" +
                "  [\"1\",\"1\",\"1\",\"1\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"1\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"0\",\"0\",\"0\"]\n" +
                "]"))).isEqualTo(1);
        assertThat(numIslands(Ps.charArray("[\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"1\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"0\",\"1\",\"1\"]\n" +
                "]"))).isEqualTo(3);
    }

    public int numIslands(char[][] grid) {
        final int HEIGHT = grid.length;
        final int WIDTH = grid[0].length;
        int cnt = 0;

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    removeIsland(grid, i, j);
                }
            }
        }

        return cnt;
    }

    final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void removeIsland(char[][] grid, int i, int j) {
        grid[i][j] = '0';
        for (int[] dir : DIRS) {
            int y = dir[0] + i;
            int x = dir[1] + j;
            if (0 <= y && y < grid.length && 0 <= x && x < grid[0].length && grid[y][x] == '1') {
                removeIsland(grid, y, x);
            }
        }
    }

}
