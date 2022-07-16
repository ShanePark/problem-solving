package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 8 ms, faster than 65.00% of Java online submissions for Out of Boundary Paths.
 * Memory Usage: 42.1 MB, less than 80.83% of Java online submissions for Out of Boundary Paths.
 * Next challenges:
 */
@SuppressWarnings("ALL")
public class Q576OutOfBoundaryPaths3 {

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
        final int MOD = 1000000007;
        final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        long sum = 0;
        for (int move = maxMove; move > 0; move--) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    long moves = dp[i][j][move] %= MOD;
                    if (moves == 0)
                        continue;
                    for (int[] dir : DIRS) {
                        int y = i + dir[0];
                        int x = j + dir[1];
                        if (y < 0 || x < 0 || y == m || x == n) {
                            sum += moves;
                        } else {
                            dp[y][x][move - 1] += moves;
                        }
                    }
                }
            }
            sum %= MOD;
        }
        return (int) sum;
    }
}
