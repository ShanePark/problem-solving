package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 7ms
 * Beats40.76%
 */
public class Q1277CountSquareSubmatricesWithAllOnes3 {

    @Test
    public void test() {
        assertThat(countSquares(Ps.intArray("[\n" +
                "  [0,1,1,1],\n" +
                "  [1,1,1,1],\n" +
                "  [0,1,1,1]\n" +
                "]"))).isEqualTo(15);
        assertThat(countSquares(Ps.intArray("[\n" +
                "  [1,0,1],\n" +
                "  [1,1,0],\n" +
                "  [1,1,0]\n" +
                "]"))).isEqualTo(7);
    }

    @Test
    public void test2() {
        assertThat(countSquares(Ps.intArray("[" +
                "[1,1,0,0,1]," +
                "[1,0,1,1,1]," +
                "[1,1,1,1,1]," +
                "[1,0,1,0,1]," +
                "[0,0,1,0,1]]"))).isEqualTo(19);
        assertThat(countSquares(Ps.intArray("[" +
                "[0,0,0]," +
                "[0,1,0]," +
                "[0,1,0]," +
                "[1,1,1]," +
                "[1,1,0]]"))).isEqualTo(8);
    }

    public int countSquares(int[][] matrix) {
        final int HEIGHT = matrix.length;
        final int WIDTH = matrix[0].length;
        int cnt = 0;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (matrix[i][j] == 0)
                    continue;
                cnt++;
                for (int n = 1; (i + n) < HEIGHT && (j + n) < WIDTH; n++) {
                    if (isOk(matrix, i, j, n)) {
                        cnt++;
                        continue;
                    }
                    break;
                }
            }
        }
        return cnt;
    }

    private boolean isOk(int[][] matrix, int i, int j, int n) {
        for (int k = 0; k <= n; k++) {
            if (matrix[i + n][j + k] == 0)
                return false;
        }
        for (int k = 0; k <= n; k++) {
            if (matrix[i + k][j + n] == 0)
                return false;
        }
        return true;
    }

}
