package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 40.5 MB Beats 82.7%
 */
public class Q54SpiralMatrix {

    @Test
    public void test() {
        assertThat(spiralOrder(Ps.intArray("[[1,2,3],[4,5,6],[7,8,9]]"))).containsExactly(1, 2, 3, 6, 9, 8, 7, 4, 5);
        assertThat(spiralOrder(Ps.intArray("[[1,2,3,4],[5,6,7,8],[9,10,11,12]]"))).containsExactly(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7);
    }

    final int EMPTY = 101;

    public List<Integer> spiralOrder(int[][] matrix) {
        int y = 0;
        int x = 0;
        int dirIndex = 0;
        int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<Integer> answer = new ArrayList<>();
        int target = matrix.length * matrix[0].length;

        while (answer.size() < target) {
            answer.add(matrix[y][x]);
            matrix[y][x] = EMPTY;
            if (!valid(y, x, matrix, DIRS, dirIndex)) {
                dirIndex = (dirIndex + 1) % 4;
            }
            int[] dir = DIRS[dirIndex];
            y += dir[0];
            x += dir[1];
        }
        return answer;
    }

    private boolean valid(int y, int x, int[][] matrix, int[][] dirs, int dirIndex) {
        int[] dir = dirs[dirIndex];
        y += dir[0];
        x += dir[1];
        return !(y < 0 || y == matrix.length || x < 0 || x == matrix[0].length || matrix[y][x] == EMPTY);
    }

}
