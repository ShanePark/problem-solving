package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 1494ms
 * Beats5.85%
 */
public class Q2435PathsInMatrixWhoseSumIsDivisibleByK {

    @Test
    public void test() {
        assertThat(numberOfPaths(Ps.intArray("[[5,2,4],[3,0,5],[0,7,2]]"), 3)).isEqualTo(2);
        assertThat(numberOfPaths(Ps.intArray("[[0,0]]"), 5)).isEqualTo(1);
        assertThat(numberOfPaths(Ps.intArray("[[7,3,4,9],[2,3,6,2],[2,3,7,0]]"), 1)).isEqualTo(10);
    }

    final int MOD = (int) 1e9 + 7;

    public int numberOfPaths(int[][] grid, int k) {
        int HEIGHT = grid.length;
        int WIDTH = grid[0].length;
        int[][][] cnt = new int[HEIGHT][WIDTH][k];
        cnt[0][0][grid[0][0] % k] = 1;
        for (int distance = 1; distance < HEIGHT + WIDTH - 1; distance++) {
            int yDistanceMax = Math.min(HEIGHT - 1, distance);
            for (int i = 0; i <= yDistanceMax; i++) {
                int j = distance - i;
                if (WIDTH <= j)
                    continue;
                int cur = grid[i][j];
                for (int mod = 0; mod < k; mod++) {
                    int newMod = (cur + mod) % k;
                    // from up
                    if (0 < i) {
                        cnt[i][j][newMod] = (cnt[i][j][newMod] + cnt[i - 1][j][mod]) % MOD;
                    }
                    // from left
                    if (0 < j) {
                        cnt[i][j][newMod] = (cnt[i][j][newMod] + cnt[i][j - 1][mod]) % MOD;
                    }
                }

            }
        }
        return cnt[HEIGHT - 1][WIDTH - 1][0];
    }


}
