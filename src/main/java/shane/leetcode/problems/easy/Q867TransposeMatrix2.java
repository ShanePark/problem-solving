package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 0ms Beats 100.00%of users with Java
 * Memory Details 45.13MB Beats 8.58%of users with Java
 */
public class Q867TransposeMatrix2 {

    @Test
    public void test() {
        assertThat(transpose(Ps.intArray("[[1,2,3],[4,5,6],[7,8,9]]"))).isDeepEqualTo(Ps.intArray("[[1,4,7],[2,5,8],[3,6,9]]"));
        assertThat(transpose(Ps.intArray("[[1,2,3],[4,5,6]]"))).isDeepEqualTo(Ps.intArray("[[1,4],[2,5],[3,6]]"));
    }

    public int[][] transpose(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] arr = new int[width][height];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                arr[j][i] = matrix[i][j];
            }
        }
        return arr;
    }

}
