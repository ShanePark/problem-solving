package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 43.2 MB Beats 6.74%
 */
public class Q1572MatrixDiagonalSum2 {

    @Test
    public void test() {
        assertThat(diagonalSum(Ps.intArray("[[1,2,3],\n" +
                "              [4,5,6],\n" +
                "              [7,8,9]]"))).isEqualTo(25);
        assertThat(diagonalSum(Ps.intArray("[[1,1,1,1],\n" +
                "              [1,1,1,1],\n" +
                "              [1,1,1,1],\n" +
                "              [1,1,1,1]]"))).isEqualTo(8);
        assertThat(diagonalSum(Ps.intArray("[[5]]"))).isEqualTo(5);
    }

    public int diagonalSum(int[][] mat) {
        int length = mat.length;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum += mat[i][i] + mat[i][length - i - 1];
        }
        if (length % 2 == 1) {
            sum -= mat[length / 2][length / 2];
        }
        return sum;
    }
}
