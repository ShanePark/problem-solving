package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime139msBeats5.04%
 */
public class Q1905CountSubIslands {

    @Test
    public void test() {
        int[][] grid1 = Ps.intArray("[[1,1,1,0,0],[0,1,1,1,1],[0,0,0,0,0],[1,0,0,0,0],[1,1,0,1,1]]");
        int[][] grid2 = Ps.intArray("[[1,1,1,0,0],[0,0,1,1,1],[0,1,0,0,0],[1,0,1,1,0],[0,1,0,1,0]]");
        assertThat(countSubIslands(grid1, grid2)).isEqualTo(3);
    }

    @Test
    public void test2() {
        int[][] grid1 = Ps.intArray("[[1,0,1,0,1],[1,1,1,1,1],[0,0,0,0,0],[1,1,1,1,1],[1,0,1,0,1]]");
        int[][] grid2 = Ps.intArray("[[0,0,0,0,0],[1,1,1,1,1],[0,1,0,1,0],[0,1,0,1,0],[1,0,0,0,1]]");
        assertThat(countSubIslands(grid1, grid2)).isEqualTo(2);
    }

    @Test
    public void test3() {
        int[][] grid1 = Ps.intArray("[[1,1,1,1,0,0],[1,1,0,1,0,0],[1,0,0,1,1,1],[1,1,1,0,0,1],[1,1,1,1,1,0],[1,0,1,0,1,0],[0,1,1,1,0,1],[1,0,0,0,1,1],[1,0,0,0,1,0],[1,1,1,1,1,0]]");
        int[][] grid2 = Ps.intArray("[[1,1,1,1,0,1],[0,0,1,0,1,0],[1,1,1,1,1,1],[0,1,1,1,1,1],[1,1,1,0,1,0],[0,1,1,1,1,1],[1,1,0,1,1,1],[1,0,0,1,0,1],[1,1,1,1,1,1],[1,0,0,1,0,0]]");
        assertThat(countSubIslands(grid1, grid2)).isEqualTo(0);
    }

    int answer = 0;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        this.answer = 0;

        final int HEIGHT = grid1.length;
        final int WIDTH = grid1[0].length;

        int[][] islandNumber = new int[HEIGHT][WIDTH];
        markIslandNumber(grid1, islandNumber);

        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                int islandIndex = islandNumber[i][j];
                if (grid2[i][j] == 0 || islandIndex == 0) {
                    continue;
                }
                if (valid(islandNumber, grid2, islandIndex, i, j)) {
                    System.err.println();
                    answer++;
                }
            }
        }

        return answer;
    }

    private boolean valid(int[][] islandNumber, int[][] grid, int islandIndex, int i, int j) {
        grid[i][j] = 0;
        boolean flag = true;
        if (islandNumber[i][j] != islandIndex) {
            flag = false;
        }
        for (int[] dir : DIRS) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (y < 0 || x < 0 || y == grid.length || x == grid[0].length || grid[y][x] == 0) {
                continue;
            }
            flag &= valid(islandNumber, grid, islandIndex, y, x);
        }
        return flag;
    }

    private void markIslandNumber(int[][] grid, int[][] islandNumber) {
        int islandIndex = 1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int cur = grid[i][j];
                if (cur == 0) {
                    continue;
                }
                markIsland(grid, islandNumber, i, j, islandIndex++);
            }
        }
    }

    int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void markIsland(int[][] grid, int[][] islandNumber, int i, int j, int islandIndex) {
        islandNumber[i][j] = islandIndex;
        grid[i][j] = 0;
        for (int[] dir : DIRS) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (y < 0 || x < 0 || y == grid.length || x == grid[0].length || grid[y][x] == 0) {
                continue;
            }
            markIsland(grid, islandNumber, y, x, islandIndex);
        }
    }

}
