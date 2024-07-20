package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime7msBeats52.59%
 */
public class Q1605FindValidMatrixGivenRowAndColumnSums2 {

    @Test
    public void test() {
        assertThat(restoreMatrix(new int[]{3, 8}, new int[]{4, 7}))
                .isEqualTo(Ps.intArray("[[3,0],[1,7]]"));
        assertThat(restoreMatrix(new int[]{5, 7, 10}, new int[]{8, 6, 8}))
                .isEqualTo(Ps.intArray("[[5, 0, 0], [3, 4, 0], [0, 2, 8]]"));
    }

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] answer = new int[rowSum.length][colSum.length];
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                answer[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= answer[i][j];
                colSum[j] -= answer[i][j];
            }
        }
        return answer;
    }
}
