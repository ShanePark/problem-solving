package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q304RangeSumQuery2DImmutable {

    @Test
    public void test() {
        NumMatrix numMatrix = new NumMatrix(Ps.intArray("[[3, 0, 1, 4, 2], [5, 6, 3, 2, 1], [1, 2, 0, 1, 5], [4, 1, 0, 1, 7], [1, 0, 3, 0, 5]]"));
        assertThat(numMatrix.sumRegion(0, 0, 4, 4)).isEqualTo(58);
        assertThat(numMatrix.sumRegion(0, 0, 1, 4)).isEqualTo(27);
        assertThat(numMatrix.sumRegion(2, 1, 4, 3)).isEqualTo(8);
        assertThat(numMatrix.sumRegion(1, 1, 2, 2)).isEqualTo(11);
        assertThat(numMatrix.sumRegion(1, 2, 2, 4)).isEqualTo(12);
    }

    class NumMatrix {

        int[][] matrix;

        public NumMatrix(int[][] input) {
            final int HEIGHT = input.length;
            final int WIDTH = input[0].length;
            matrix = new int[HEIGHT][WIDTH];
            matrix[0][0] = input[0][0];
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    if (i > 0 && j > 0) {
                        matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j] - matrix[i - 1][j - 1] + input[i][j];
                    } else if (i > 0) {
                        matrix[i][j] = matrix[i - 1][j] + input[i][j];
                    } else if (j > 0) {
                        matrix[i][j] = matrix[i][j - 1] + input[i][j];
                    }
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            int answer = matrix[row2][col2];
            if (row1 > 0) {
                answer -= matrix[row1 - 1][col2];
            }
            if (col1 > 0) {
                answer -= matrix[row2][col1 - 1];
            }
            if (row1 > 0 && col1 > 0) {
                answer += matrix[row1 - 1][col1 - 1];
            }
            return answer;
        }
    }

}
