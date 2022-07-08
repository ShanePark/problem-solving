package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q695MaxAreaOfIsland {

    @Test
    public void test() {
        assertThat(maxAreaOfIsland(STool.convertToIntArray("[[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]")))
                .isEqualTo(6);
        assertThat(maxAreaOfIsland(STool.convertToIntArray("[[0,0,0,0,0,0,0,0]]"))).isEqualTo(0);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    int size = getSize(i, j, grid);
                    max = Math.max(max, size);
                }
            }
        }
        return max;
    }

    private int getSize(int i, int j, int[][] grid) {
        grid[i][j] = -1;
        int size = 1;

        // left
        if (j > 0 && grid[i][j - 1] == 1) {
            size += getSize(i, j - 1, grid);
        }

        // right
        if (j < grid[0].length - 1 && grid[i][j + 1] == 1) {
            size += getSize(i, j + 1, grid);
        }

        // up
        if (i > 0 && grid[i - 1][j] == 1) {
            size += getSize(i - 1, j, grid);
        }

        // down
        if (i < grid.length - 1 && grid[i + 1][j] == 1) {
            size += getSize(i + 1, j, grid);
        }
        return size;
    }

}
