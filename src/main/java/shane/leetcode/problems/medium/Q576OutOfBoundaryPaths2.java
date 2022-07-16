package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 11 ms, faster than 46.25% of Java online submissions for Out of Boundary Paths.
 * Memory Usage: 44.6 MB, less than 11.88% of Java online submissions for Out of Boundary Paths.
 */
public class Q576OutOfBoundaryPaths2 {

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
                        if (i > 0) {
                            dp[i - 1][j][move - 1] += moves;
                        } else {
                            sum += moves;
                        }
                        if (i < m - 1) {
                            dp[i + 1][j][move - 1] += moves;
                        } else {
                            sum += moves;
                        }
                        if (j > 0) {
                            dp[i][j - 1][move - 1] += moves;
                        } else {
                            sum += moves;
                        }
                        if (j < n - 1) {
                            dp[i][j + 1][move - 1] += moves;
                        } else {
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
