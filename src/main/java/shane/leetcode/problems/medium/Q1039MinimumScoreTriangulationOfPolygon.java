package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1039MinimumScoreTriangulationOfPolygon {

    @Test
    public void test() {
        assertThat(minScoreTriangulation(new int[]{1, 2, 3})).isEqualTo(6);
        assertThat(minScoreTriangulation(new int[]{3, 7, 4, 5})).isEqualTo(144);
        assertThat(minScoreTriangulation(new int[]{1, 3, 1, 4, 1, 5})).isEqualTo(13);
    }

    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int length = 3; length <= n; length++) {
            for (int start = 0; start <= n - length; start++) {
                int end = start + length - 1;
                dp[start][end] = Integer.MAX_VALUE;
                for (int mid = start + 1; mid < end; mid++) {
                    int triangleScore = values[start] * values[mid] * values[end];
                    int totalScore = dp[start][mid] + dp[mid][end] + triangleScore;
                    dp[start][end] = Math.min(dp[start][end], totalScore);
                }
            }
        }
        return dp[0][n - 1];
    }

}
