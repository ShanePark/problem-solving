package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q695MaxAreaOfIsland2 {

    @Test
    public void test() {
        assertThat(maxAreaOfIsland(Ps.intArray("[[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]")))
                .isEqualTo(6);
        assertThat(maxAreaOfIsland(Ps.intArray("[[0,0,0,0,0,0,0,0]]"))).isEqualTo(0);
    }

    public int maxAreaOfIsland(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int size = getSize(grid, i, j, visited);
                max = Math.max(max, size);
            }
        }
        return max;
    }

    private int getSize(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0 || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + getSize(grid, i + 1, j, visited)
                + getSize(grid, i - 1, j, visited)
                + getSize(grid, i, j + 1, visited)
                + getSize(grid, i, j - 1, visited);
    }

}
