package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 5ms
 * Beats94.31%
 */
public class Q3195FindTheMinimumAreaToCoverAllOnesI {

    @Test
    public void test() {
        assertThat(minimumArea(Ps.intArray("[[0,1,0],[1,0,1]]"))).isEqualTo(6);
        assertThat(minimumArea(Ps.intArray("[[1,0],[0,0]]"))).isEqualTo(1);
    }

    public int minimumArea(int[][] grid) {
        int minY = grid.length;
        int maxY = -1;
        int minX = grid[0].length;
        int maxX = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                minY = Math.min(minY, i);
                maxY = Math.max(maxY, i);
                minX = Math.min(minX, j);
                maxX = Math.max(maxX, j);
            }
        }
        if (maxY == -1)
            return 0;
        return (maxY - minY + 1) * (maxX - minX + 1);
    }

}
