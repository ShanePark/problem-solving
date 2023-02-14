package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate Image.
 * Memory Usage: 40.6 MB, less than 99.89% of Java online submissions for Rotate Image.
 */
public class Q48RotateImage {

    @Test
    public void test() {
        int[][] matrix = Ps.intArray("[[1,2,3],[4,5,6],[7,8,9]]");
        rotate(matrix);
        assertThat(matrix).isDeepEqualTo(Ps.intArray("[[7,4,1],[8,5,2],[9,6,3]]"));
    }

    @Test
    public void test2() {
        int[][] matrix = Ps.intArray("[[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]");
        rotate(matrix);
        assertThat(matrix).isDeepEqualTo(Ps.intArray("[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]"));
    }

    public void rotate(int[][] matrix) {
        final int LENGTH = matrix.length;
        int[][] clone = new int[LENGTH][LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                clone[i][j] = matrix[i][j];
            }
        }
        for (int i = 0; i < LENGTH; i++) {
            for (int j = 0; j < LENGTH; j++) {
                int newI = LENGTH - 1 - j;
                int newJ = i;
                matrix[i][j] = clone[newI][newJ];
            }
        }
    }
}
