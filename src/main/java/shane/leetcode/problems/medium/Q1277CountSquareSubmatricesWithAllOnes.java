package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1277CountSquareSubmatricesWithAllOnes {

    @Test
    public void test() {
        assertThat(countSquares(STool.convertToIntArray("[\n" +
                "  [0,1,1,1],\n" +
                "  [1,1,1,1],\n" +
                "  [0,1,1,1]\n" +
                "]"))).isEqualTo(15);
        assertThat(countSquares(STool.convertToIntArray("[\n" +
                "  [1,0,1],\n" +
                "  [1,1,0],\n" +
                "  [1,1,0]\n" +
                "]"))).isEqualTo(7);
    }

    public int countSquares(int[][] matrix) {
        final int HEIGHT = matrix.length;
        final int WIDTH = matrix[0].length;

        int cnt = 0;
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                cnt += count(matrix, i, j);
            }
        }
        return cnt;
    }

    private int count(int[][] matrix, int i, int j) {
        int cnt = 0;
        for (int m = 0; ; m++) { // length
            if (i + m >= matrix.length || j + m >= matrix[0].length)
                return cnt;
            for (int n = 0; n <= m; n++) {
                if (matrix[i + m][j + n] == 0 || matrix[i + n][j + m] == 0)
                    return cnt;
            }
            cnt++;
        }
    }
}
