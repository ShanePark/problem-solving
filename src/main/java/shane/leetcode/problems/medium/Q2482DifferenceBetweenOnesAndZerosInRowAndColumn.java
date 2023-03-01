package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 48 ms Beats 18.45%
 * Memory 145.4 MB Beats 71.79%
 */
public class Q2482DifferenceBetweenOnesAndZerosInRowAndColumn {

    @Test
    public void test() {
        assertThat(onesMinusZeros(Ps.intArray("[[0,1,1],[1,0,1],[0,0,1]]"))).isDeepEqualTo(Ps.intArray("[[0,0,4],[0,0,4],[-2,-2,2]]"));
        assertThat(onesMinusZeros(Ps.intArray("[[1,1,1],[1,1,1]]"))).isDeepEqualTo(Ps.intArray("[[5,5,5],[5,5,5]]"));

    }

    public int[][] onesMinusZeros(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[][] answer = new int[height][width];
        int[] rows = new int[height];
        int[] cols = new int[width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                rows[i] += grid[i][j] == 1 ? 1 : -1;
                cols[j] += grid[i][j] == 1 ? 1 : -1;
            }
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                answer[i][j] += cols[j] + rows[i];
            }
        }

        return answer;
    }

}
