package shane.leetcode.problems.easy;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 1 ms, faster than 93.83% of Java online submissions for Toeplitz Matrix.
 * Memory Usage: 46.3 MB, less than 11.91% of Java online submissions for Toeplitz Matrix.
 */
public class Q766ToeplitzMatrix {

    @Test
    public void test() {
        assertThat(isToeplitzMatrix(STool.convertToIntArray("[[1,2,3,4],[5,1,2,3],[9,5,1,2]]"))).isTrue();
        assertThat(isToeplitzMatrix(STool.convertToIntArray("[[1,2],[2,2]]"))).isFalse();
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        final int HEIGHT = matrix.length;
        final int WIDTH = matrix[0].length;
        for (int i = 0; i < WIDTH; i++) {
            if (!check(matrix, HEIGHT, WIDTH, 0, i)) {
                return false;
            }
        }
        for (int i = 0; i < HEIGHT; i++) {
            if (!check(matrix, HEIGHT, WIDTH, i, 0)) {
                return false;
            }
        }
        return true;
    }

    private boolean check(int[][] matrix, int height, int width, int y, int x) {
        int value = matrix[y][x];
        while (y < height && x < width) {
            if (matrix[y++][x++] != value) {
                return false;
            }
        }
        return true;
    }

}
