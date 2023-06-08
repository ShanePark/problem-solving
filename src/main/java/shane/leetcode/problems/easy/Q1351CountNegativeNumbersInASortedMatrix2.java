package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 44.7 MB Beats 5.53%
 */
public class Q1351CountNegativeNumbersInASortedMatrix2 {

    @Test
    public void test() {
        assertThat(countNegatives(Ps.intArray("[" +
                "[4,3,2,-1]," +
                "[3,2,1,-1]," +
                "[1,1,-1,-2]," +
                "[-1,-1,-2,-3]]")))
                .isEqualTo(8);
        assertThat(countNegatives(Ps.intArray("[[3,2],[1,0]]"))).isEqualTo(0);
    }

    public int countNegatives(int[][] grid) {
        return grid.length * grid[0].length - dfs(grid, 0, 0);
    }

    private int dfs(int[][] grid, int i, int j) {
        if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] >= 0) {
            grid[i][j] = -1;
            return 1 + dfs(grid, i + 1, j) + dfs(grid, i, j + 1);
        }
        return 0;
    }

}
