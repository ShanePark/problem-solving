package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

public class Q1605FindValidMatrixGivenRowAndColumnSums {

    @Test
    public void test() {
        STool.printDeepArray(restoreMatrix(new int[]{3, 8}, new int[]{4, 7}));
        STool.printDeepArray(restoreMatrix(new int[]{5, 7, 10}, new int[]{8, 6, 8}));
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
