package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q576OutOfBoundaryPaths {

    @Test
    public void test() {
        assertThat(findPaths(36, 5, 50, 15, 3)).isEqualTo(390153306);
        assertThat(findPaths(1, 1, 5, 0, 0)).isEqualTo(4);
        assertThat(findPaths(2, 3, 8, 1, 0)).isEqualTo(1104);
        assertThat(findPaths(1, 3, 3, 0, 1)).isEqualTo(12);
        assertThat(findPaths(2, 2, 2, 0, 0)).isEqualTo(6);
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        if (m == 1 && n == 1)
            return 4;
        long[][][] dp = new long[m][n][maxMove + 1];
        dp[startRow][startColumn][maxMove] = 1;
        long sum = 0;
        for (int move = maxMove; move > 0; move--) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    long moves = dp[i][j][move] %= 1000000007;
                    if (moves > 0) {
                        try {
                            dp[i - 1][j][move - 1] += moves;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            sum += moves;
                        }
                        try {
                            dp[i + 1][j][move - 1] += moves;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            sum += moves;
                        }
                        try {
                            dp[i][j - 1][move - 1] += moves;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            sum += moves;
                        }
                        try {
                            dp[i][j + 1][move - 1] += moves;
                        } catch (ArrayIndexOutOfBoundsException e) {
                            sum += moves;
                        }
                    }
                }
            }
            sum %= 1000000007;
        }
        return (int) sum;
    }
}
