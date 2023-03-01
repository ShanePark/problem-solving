package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q885SpiralMatrixIII {

    @Test
    public void test() {
        assertThat(spiralMatrixIII(1, 4, 0, 0)).isDeepEqualTo(Ps.intArray("[[0,0],[0,1],[0,2],[0,3]]"));
        assertThat(spiralMatrixIII(5, 6, 1, 4)).isDeepEqualTo(Ps.intArray("[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]"));
    }

    public int[][] spiralMatrixIII(int rows, int cols, int y, int x) {
        int[][] answer = new int[rows * cols][2];
        answer[0] = new int[]{y, x};
        int index = 1;
        int width = 1;
        while (index < rows * cols) {
            for (int i = 0; i < width && index < rows * cols; i++) {
                x++;
                if (0 <= x && x < cols && 0 <= y && y < rows) {
                    answer[index++] = new int[]{y, x};
                }
            }
            for (int i = 0; i < width && index < rows * cols; i++) {
                y++;
                if (0 <= x && x < cols && 0 <= y && y < rows) {
                    answer[index++] = new int[]{y, x};
                }
            }
            width++;
            for (int i = 0; i < width && index < rows * cols; i++) {
                x--;
                if (0 <= x && x < cols && 0 <= y && y < rows) {
                    answer[index++] = new int[]{y, x};

                }
            }
            for (int i = 0; i < width && index < rows * cols; i++) {
                y--;
                if (0 <= x && x < cols && 0 <= y && y < rows) {
                    answer[index++] = new int[]{y, x};
                }
            }
            width++;
        }
        return answer;
    }
}
