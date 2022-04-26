package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q861ScoreAfterFlippingMatrix {

    @Test
    public void test() {
        assertThat(matrixScore(STool.convertToIntArray("[[0,0,1,1],[1,0,1,0],[1,1,0,0]]"))).isEqualTo(39);
        assertThat(matrixScore(STool.convertToIntArray("[[0]]"))).isEqualTo(1);
    }

    public int matrixScore(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        for (int i = 0; i < height; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < width; j++) {
                    grid[i][j] = grid[i][j] == 0 ? 1 : 0;
                }
            }
        }

        for (int j = 0; j < width; j++) {
            int sum = 0;
            for (int i = 0; i < height; i++) {
                sum += grid[i][j];
            }

            if (sum < height / 2.0) {
                for (int i = 0; i < height; i++) {
                    grid[i][j] = grid[i][j] == 0 ? 1 : 0;
                }
            }
        }

        int answer = 0;
        for (int[] ints : grid) {
            int d = 1;
            for (int i = width - 1; i >= 0; i--) {
                answer += ints[i] * d;
                d *= 2;
            }
        }

        return answer;
    }
}
