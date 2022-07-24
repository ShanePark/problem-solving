package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q240SearchA2DMatrixII {

    @Test
    public void test() {
        assertThat(searchMatrix(STool.convertToIntArray("[[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15],[16,17,18,19,20],[21,22,23,24,25]]"), 19)).isTrue();
        assertThat(searchMatrix(STool.convertToIntArray("[[-1,3]]"), 3)).isTrue();
        assertThat(searchMatrix(STool.convertToIntArray("[[-5]]"), -5)).isTrue();
        assertThat(searchMatrix(STool.convertToIntArray("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]"), 5)).isTrue();
        assertThat(searchMatrix(STool.convertToIntArray("[[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]]"), 20)).isFalse();
    }

    /**
     * CAN NOT PASS THIS CASE
     */
    @Test
    public void test2() {
        assertThat(searchMatrix(STool.convertToIntArray("[[1,3,5,7,9],[2,4,6,8,10],[11,13,15,17,19],[12,14,16,18,20],[21,22,23,24,25]]"), 13)).isTrue();
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        final int HEIGHT = matrix.length;
        final int WIDTH = matrix[0].length;

        int left = 0;
        int right = WIDTH - 1;
        int top = 0;
        int bottom = HEIGHT - 1;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            int midNum = matrix[top][mid];
            if (midNum == target) {
                return true;
            } else if (midNum < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        while (top < bottom) {
            int mid = (top + bottom + 1) / 2;
            int midNum = matrix[mid][left];
            if (midNum == target) {
                return true;
            } else if (midNum < target) {
                top = mid;
            } else {
                bottom = mid - 1;
            }
        }

        left = 0;
        right = WIDTH - 1;
        top = 0;
        bottom = HEIGHT - 1;

        while (top < bottom) {
            int mid = (top + bottom + 1) / 2;
            int midNum = matrix[mid][left];
            if (midNum == target) {
                return true;
            } else if (midNum < target) {
                top = mid;
            } else {
                bottom = mid - 1;
            }
        }

        while (left < right) {
            int mid = (left + right + 1) / 2;
            int midNum = matrix[top][mid];
            if (midNum == target) {
                return true;
            } else if (midNum < target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return matrix[top][left] == target;
    }

}
