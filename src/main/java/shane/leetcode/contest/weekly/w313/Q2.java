package shane.leetcode.contest.weekly.w313;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2 {

    @Test
    public void test() {
        assertThat(maxSum(Ps.intArray("[[6,2,1,3],[4,2,1,5],[9,2,8,7],[4,1,2,9]]"))).isEqualTo(30);
        assertThat(maxSum(Ps.intArray("[[1,2,3],[4,5,6],[7,8,9]]"))).isEqualTo(35);
    }

    public int maxSum(int[][] grid) {
        int HEIGHT = grid.length;
        int WIDTH = grid[0].length;
        int max = 0;
        for (int i = 0; i <= HEIGHT - 3; i++) {
            for (int j = 0; j <= WIDTH - 3; j++) {
                max = Math.max(max, calc(i, j, grid));
            }
        }
        return max;
    }

    private int calc(int i, int j, int[][] grid) {
        return grid[i][j] + grid[i + 2][j] + grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1] + grid[i][j + 2] + grid[i + 2][j + 2];
    }

}
