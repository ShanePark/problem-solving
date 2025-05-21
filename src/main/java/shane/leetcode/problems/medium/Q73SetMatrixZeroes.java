package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 2ms
 * Beats18.74%
 */
public class Q73SetMatrixZeroes {

    @Test
    public void test() {
        int[][] matrix = Ps.intArray("[[1,1,1],[1,0,1],[1,1,1]]");
        setZeroes(matrix);
        assertThat(matrix).isEqualTo(Ps.intArray("[[1,0,1],[0,0,0],[1,0,1]]"));
    }

    @Test
    public void test2() {
        int[][] matrix = Ps.intArray("[[0,1,2,0],[3,4,5,2],[1,3,1,5]]");
        setZeroes(matrix);
        assertThat(matrix).isEqualTo(Ps.intArray("[[0,0,0,0],[0,4,5,0],[0,3,1,0]]"));
    }

    public void setZeroes(int[][] matrix) {
        final int HEIGHT = matrix.length;
        final int WIDTH = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (Integer row : rows) {
            for (int j = 0; j < WIDTH; j++) {
                matrix[row][j] = 0;
            }
        }
        for (Integer col : cols) {
            for (int i = 0; i < HEIGHT; i++) {
                matrix[i][col] = 0;
            }
        }
    }

}
