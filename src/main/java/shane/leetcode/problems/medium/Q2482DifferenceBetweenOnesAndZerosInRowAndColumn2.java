package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 3ms Beats 100.00%of users with Java
 * Memory Details 72.91MB Beats 53.40%of users with Java
 */
public class Q2482DifferenceBetweenOnesAndZerosInRowAndColumn2 {

    @Test
    public void test() {
        assertThat(onesMinusZeros(Ps.intArray("[[0,1,1],[1,0,1],[0,0,1]]"))).isDeepEqualTo(Ps.intArray("[[0,0,4],[0,0,4],[-2,-2,2]]"));
        assertThat(onesMinusZeros(Ps.intArray("[[1,1,1],[1,1,1]]"))).isDeepEqualTo(Ps.intArray("[[5,5,5],[5,5,5]]"));

    }

    public int[][] onesMinusZeros(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[] rows = new int[height];
        int[] cols = new int[width];
        for (int i = 0; i < height; i++) {
            int sum = 0;
            for (int j = 0; j < width; j++) {
                sum += grid[i][j];
            }
            rows[i] = sum - (height - sum);
        }
        for (int j = 0; j < width; j++) {
            int sum = 0;
            for (int i = 0; i < height; i++) {
                sum += grid[i][j];
            }
            cols[j] = sum - (width - sum);
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j] = rows[i] + cols[j];
            }
        }
        return grid;
    }

}
