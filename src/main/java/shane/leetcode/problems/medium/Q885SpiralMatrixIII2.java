package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime4msBeats81.31%
 */
public class Q885SpiralMatrixIII2 {

    @Test
    public void test() {
        assertThat(spiralMatrixIII(1, 4, 0, 0)).isDeepEqualTo(Ps.intArray("[[0,0],[0,1],[0,2],[0,3]]"));
        assertThat(spiralMatrixIII(5, 6, 1, 4)).isDeepEqualTo(Ps.intArray("[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]"));
    }

    public int[][] spiralMatrixIII(int rows, int cols, int y, int x) {
        List<int[]> answer = new ArrayList<>();
        answer.add(new int[]{y, x});
        int move = 1;
        while (answer.size() < rows * cols) {
            // right
            for (int i = 0; i < move; i++) {
                check(answer, rows, cols, y, ++x);
            }
            // down
            for (int i = 0; i < move; i++) {
                check(answer, rows, cols, ++y, x);
            }
            move++;

            // left
            for (int i = 0; i < move; i++) {
                check(answer, rows, cols, y, --x);
            }
            // up
            for (int i = 0; i < move; i++) {
                check(answer, rows, cols, --y, x);
            }
            move++;
        }
        return answer.toArray(a -> new int[][]{});
    }

    private void check(List<int[]> answer, int rows, int cols, int y, int x) {
        if (0 <= y && y < rows && 0 <= x && x < cols) {
            answer.add(new int[]{y, x});
        }
    }

}
