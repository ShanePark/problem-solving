package shane.leetcode.problems.medium;

public class Q1605FindValidMatrixGivenRowAndColumnSums {

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
