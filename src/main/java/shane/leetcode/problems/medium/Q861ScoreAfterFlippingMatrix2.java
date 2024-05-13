package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q861ScoreAfterFlippingMatrix2 {

    @Test
    public void test() {
        assertThat(matrixScore(Ps.intArray("[[0,0,1,1],[1,0,1,0],[1,1,0,0]]"))).isEqualTo(39);
        assertThat(matrixScore(Ps.intArray("[[0]]"))).isEqualTo(1);
    }

    public int matrixScore(int[][] grid) {
        for (int[] ints : grid) {
            if (ints[0] == 0) {
                flip(ints);
            }
        }
        int HEIGHT = grid.length;
        int WIDTH = grid[0].length;
        int answer = 0;
        for (int j = 0; j < WIDTH; j++) {
            int bitCnt = 0;
            for (int[] ints : grid) {
                bitCnt += ints[j];
            }
            bitCnt = Math.max(bitCnt, HEIGHT - bitCnt);
            int exp = WIDTH - j - 1;
            answer += (int) Math.pow(2, exp) * bitCnt;
        }
        return answer;
    }

    private void flip(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            ints[i] = (ints[i] + 1) % 2;
        }
    }

}
