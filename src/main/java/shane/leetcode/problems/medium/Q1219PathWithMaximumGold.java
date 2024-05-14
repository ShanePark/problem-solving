package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 73 ms Beats 52.13% of users with Java
 */
public class Q1219PathWithMaximumGold {

    @Test
    public void test() {
        assertThat(getMaximumGold(new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}})).isEqualTo(24);
        assertThat(getMaximumGold(new int[][]{{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}})).isEqualTo(28);
    }

    int max = 0;

    public int getMaximumGold(int[][] grid) {
        max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                dfs(grid, i, j, 0);
            }
        }
        return max;
    }

    int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void dfs(int[][] grid, int i, int j, int gold) {
        int cur = grid[i][j];
        grid[i][j] = 0;
        gold += cur;

        max = Math.max(max, gold);
        for (int[] dir : DIRS) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (x < 0 || y < 0 || y == grid.length || x == grid[0].length || grid[y][x] == 0)
                continue;
            dfs(grid, y, x, gold);
        }
        grid[i][j] = cur;
    }

}
