package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 41.4 MB Beats 17.14%
 */
public class Q74SearchA2DMatrix2 {

    @Test
    public void test() {
        assertThat(searchMatrix(Ps.intArray("[[1,3,5,7],[10,11,16,20],[23,30,34,50]]"), 11)).isTrue();
        assertThat(searchMatrix(Ps.intArray("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]"), 3)).isTrue();
        assertThat(searchMatrix(Ps.intArray("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]"), 13)).isFalse();
        assertThat(searchMatrix(Ps.intArray("[[1]]"), 1)).isTrue();
        assertThat(searchMatrix(Ps.intArray("[[1,1]]"), 2)).isFalse();
        assertThat(searchMatrix(Ps.intArray("[[1,3]]"), 3)).isTrue();
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int height = matrix.length;
        int width = matrix[0].length;
        int top = 0;
        int bottom = height - 1;
        int left = 0;
        int right = width - 1;

        while (top < bottom) {
            int mid = top + (bottom - top) / 2 + 1;
            int val = matrix[mid][0];
            if (val > target) {
                bottom = mid - 1;
                continue;
            }
            top = mid;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            int val = matrix[top][mid];
            if (val > target) {
                right = mid - 1;
                continue;
            }
            if (val == target)
                return true;
            left = mid + 1;
        }

        return matrix[top][left] == target;
    }

}
