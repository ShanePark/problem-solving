package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1314MatrixBlockSum {

    @Test
    public void test() {
        assertThat(matrixBlockSum(STool.convertToIntArray("[[1,2,3],[4,5,6],[7,8,9]]"), 1)).isDeepEqualTo(STool.convertToIntArray("[[12,21,16],[27,45,33],[24,39,28]]"));
        assertThat(matrixBlockSum(STool.convertToIntArray("[[1,2,3],[4,5,6],[7,8,9]]"), 2)).isDeepEqualTo(STool.convertToIntArray("[[45,45,45],[45,45,45],[45,45,45]]"));
        assertThat(matrixBlockSum(STool.convertToIntArray("[[1]]"), 1)).isDeepEqualTo(STool.convertToIntArray("[[1]]"));
    }

    public int[][] matrixBlockSum(int[][] mat, int k) {
        final int HEIGHT = mat.length;
        final int WIDTH = mat[0].length;

        int[][] answer = new int[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                int sum = 0;
                for (int i2 = Math.max(0, i - k); i2 < Math.min(HEIGHT, i + k + 1); i2++) {
                    for (int j2 = Math.max(0, j - k); j2 < Math.min(WIDTH, j + k + 1); j2++) {
                        sum += mat[i2][j2];
                    }
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
