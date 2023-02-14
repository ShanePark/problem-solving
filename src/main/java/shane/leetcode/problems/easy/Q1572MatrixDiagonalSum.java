package shane.leetcode.problems.easy;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1572MatrixDiagonalSum {

    @Test
    public void test() {
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
            sum += mat[i][i] + mat[i][length - 1 - i];
        }
        if (length % 2 == 1) {
            sum -= mat[length / 2][length / 2];
        }
        return sum;
    }
}
