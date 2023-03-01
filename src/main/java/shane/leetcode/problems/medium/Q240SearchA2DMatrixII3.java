package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * implement idea from the community
 * <p>
 * Runtime: 10 ms, faster than 64.73% of Java online submissions for Search a 2D Matrix II.
 * Memory Usage: 58.4 MB, less than 9.70% of Java online submissions for Search a 2D Matrix II.
 */
public class Q240SearchA2DMatrixII3 {

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
        int y = HEIGHT - 1;
        int x = 0;
        while (x < WIDTH && y >= 0) {
            int num = matrix[y][x];
            if (num == target) {
                return true;
            } else if (num < target) {
                x++;
            } else {
                y--;
            }
        }
        return false;
    }

}
