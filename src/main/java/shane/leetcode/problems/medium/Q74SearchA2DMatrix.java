package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q74SearchA2DMatrix {

    @Test
    public void test() {
        assertThat(searchMatrix(Ps.intArray("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]"), 3)).isTrue();
        assertThat(searchMatrix(Ps.intArray("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]"), 13)).isFalse();
        assertThat(searchMatrix(Ps.intArray("[[1]]"), 1)).isTrue();
        assertThat(searchMatrix(Ps.intArray("[[1,1]]"), 2)).isFalse();
        assertThat(searchMatrix(Ps.intArray("[[1,3]]"), 3)).isTrue();
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (left < right) {
            int mid = (left + right) / 2 + 1;
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        int y = left;

        left = 0;
        right = matrix[0].length - 1;
        while (left < right) {
            int mid = (left + right) / 2 + 1;
            if (matrix[y][mid] == target) {
                return true;
            } else if (matrix[y][mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }

        return matrix[y][left] == target;
    }

}
