package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class Q576OutOfBoundaryPaths4 {

    @Test
    public void test() {
        assertThat(findPaths(2, 2, 2, 0, 0)).isEqualTo(6);
        assertThat(findPaths(1, 3, 3, 0, 1)).isEqualTo(12);
    }

    final int MOD = (int) (1e9) + 7;
    final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        dp[startRow][startColumn][maxMove] = 1;

        int answer = 0;
        while (maxMove > 0) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    for (int[] dir : DIRS) {
                        int y = i + dir[0];
                        int x = j + dir[1];
                        if (y < 0 || x < 0 || y == m || x == n) {
                            answer = (answer + dp[i][j][maxMove]) % MOD;
                            continue;
                        }
                        dp[y][x][maxMove - 1] = (dp[y][x][maxMove - 1] + dp[i][j][maxMove]) % MOD;
                    }
                }
            }
            maxMove--;
        }
        return answer;
    }

}
