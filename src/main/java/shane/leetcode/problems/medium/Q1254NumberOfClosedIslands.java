package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3 ms Beats 30.78%
 * Memory 43.4 MB Beats 16.44%
 */
public class Q1254NumberOfClosedIslands {

    @Test
    public void test() {
        assertThat(closedIsland(Ps.intArray("[[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]")))
                .isEqualTo(2);
        assertThat(closedIsland(Ps.intArray("[[0,0,1,0,0],[0,1,0,1,0],[0,1,1,1,0]]")))
                .isEqualTo(1);
        assertThat(closedIsland(Ps.intArray("[[1,1,1,1,1,1,1],\n" +
                "               [1,0,0,0,0,0,1],\n" +
                "               [1,0,1,1,1,0,1],\n" +
                "               [1,0,1,0,1,0,1],\n" +
                "               [1,0,1,1,1,0,1],\n" +
                "               [1,0,0,0,0,0,1],\n" +
                "               [1,1,1,1,1,1,1]]"))).isEqualTo(2);
    }

    public int closedIsland(int[][] grid) {
        int landCount = 0;
        Set<Integer> openLands = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    int landNumber = ++landCount;
                    dfs(grid, i, j, openLands, landNumber);
                }
            }
        }
        return landCount - openLands.size();
    }

    int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void dfs(int[][] grid, int i, int j, Set<Integer> openLands, int landNumber) {
        grid[i][j] = 1;
        if (i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1) {
            openLands.add(landNumber);
        }
        for (int[] dir : DIRS) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (0 <= y && y < grid.length && 0 <= x && x < grid[0].length && grid[y][x] == 0) {
                dfs(grid, y, x, openLands, landNumber);
            }
        }
    }

}
