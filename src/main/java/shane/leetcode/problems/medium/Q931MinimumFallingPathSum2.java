package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 7 ms Beats 54.05% of users with Java
 */
public class Q931MinimumFallingPathSum2 {

    @Test
    public void test() {
        assertThat(minFallingPathSum(Ps.intArray("[[2,1,3],[6,5,4],[7,8,9]]"))).isEqualTo(13);
        assertThat(minFallingPathSum(Ps.intArray("[[-19,57],[-40,-5]]"))).isEqualTo(-59);
    }

    public int minFallingPathSum(int[][] matrix) {
        final int HEIGHT = matrix.length;
        final int WIDTH = matrix[0].length;
        for (int i = 1; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                int minBefore = matrix[i - 1][j];
                if (j > 0) {
                    minBefore = Math.min(minBefore, matrix[i - 1][j - 1]);
                }
                if (j < WIDTH - 1) {
                    minBefore = Math.min(minBefore, matrix[i - 1][j + 1]);
                }
                matrix[i][j] += minBefore;
            }
        }
        return Arrays.stream(matrix[HEIGHT - 1]).min().getAsInt();
    }

}
