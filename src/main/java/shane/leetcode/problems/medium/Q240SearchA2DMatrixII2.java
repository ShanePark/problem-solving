package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 11 ms, faster than 50.70% of Java online submissions for Search a 2D Matrix II.
 * Memory Usage: 53.7 MB, less than 81.56% of Java online submissions for Search a 2D Matrix II.
 */
public class Q240SearchA2DMatrixII2 {

    @Test
    public void test() {
        assertThat(searchMatrix(Ps.intArray("[[-5]]"), -5)).isTrue();
        assertThat(searchMatrix(Ps.intArray("[[5,6]]"), 6)).isTrue();
        assertThat(searchMatrix(Ps.intArray("[[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15],[16,17,18,19,20],[21,22,23,24,25]]"), 19)).isTrue();
        assertThat(searchMatrix(Ps.intArray("[[-1,3]]"), 3)).isTrue();
        assertThat(searchMatrix(Ps.intArray("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]"), 5)).isTrue();
        assertThat(searchMatrix(Ps.intArray("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]"), 20)).isFalse();
    }

    @Test
    public void test2() {
        assertThat(searchMatrix(Ps.intArray("[[1,3,5,7,9],[2,4,6,8,10],[11,13,15,17,19],[12,14,16,18,20],[21,22,23,24,25]]"), 13)).isTrue();
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        final int HEIGHT = matrix.length;
        final int WIDTH = matrix[0].length;

        for (int i = 0; i < HEIGHT; i++) {
            if (matrix[i][0] <= target && target <= matrix[i][WIDTH - 1]) {
                int left = 0;
                int right = WIDTH - 1;
                while (left < right) {
                    int mid = (left + right + 1) / 2;
                    int midNum = matrix[i][mid];
                    if (midNum == target) {
                        return true;
                    } else if (midNum < target) {
                        left = mid;
                    } else {
                        right = mid - 1;
                    }
                }
                if (matrix[i][left] == target) {
                    return true;
                }
            }
        }
        return false;
    }

}
