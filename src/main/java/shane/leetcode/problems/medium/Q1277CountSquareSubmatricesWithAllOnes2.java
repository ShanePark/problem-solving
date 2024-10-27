package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime6msBeats70.73%
 */
public class Q1277CountSquareSubmatricesWithAllOnes2 {

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

    public int countSquares(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    sum += findLen(i, j, matrix);
                }
            }
        }
        return sum;
    }

    private int findLen(int y, int x, int[][] matrix) {
        int len = 1;
        while (y + len < matrix.length && x + len < matrix[0].length) {
            len++;
            for (int i = y; i < y + len; i++) {
                if (matrix[i][x + len - 1] != 1)
                    return len - 1;
            }
            for (int j = x; j < x + len; j++) {
                if (matrix[y + len - 1][j] != 1)
                    return len - 1;
            }
        }
        return len;
    }

}
