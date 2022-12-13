package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 5 ms Beats 64.90%
 * Memory 42.8 MB Beats 88.88%
 */
public class Q931MinimumFallingPathSum {

    @Test
    public void test() {
        assertThat(minFallingPathSum(STool.convertToIntArray("[[2,1,3],[6,5,4],[7,8,9]]"))).isEqualTo(13);
        assertThat(minFallingPathSum(STool.convertToIntArray("[[-19,57],[-40,-5]]"))).isEqualTo(-59);
    }

    public int minFallingPathSum(int[][] matrix) {
        int height = matrix.length;
        int width = matrix[0].length;
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int min = matrix[i - 1][j];
                if (0 < j) {
                    min = Math.min(min, matrix[i - 1][j - 1]);
                }
                if (j + 1 < width) {
                    min = Math.min(min, matrix[i - 1][j + 1]);
                }
                matrix[i][j] += min;
            }
        }
        return Arrays.stream(matrix[height - 1]).min().getAsInt();
    }

}
