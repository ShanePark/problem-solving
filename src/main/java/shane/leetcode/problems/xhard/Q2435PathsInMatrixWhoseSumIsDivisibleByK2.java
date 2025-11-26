package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2435PathsInMatrixWhoseSumIsDivisibleByK2 {

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
        int[][] prev = new int[WIDTH][k];
        prev[0][grid[0][0] % k] = 1;

        for (int j = 1; j < WIDTH; j++) {
            int cur = grid[0][j];
            for (int mod = 0; mod < k; mod++) {
                prev[j][(cur + mod) % k] = prev[j - 1][mod];
            }
        }

        for (int i = 1; i < HEIGHT; i++) {
            int[][] row = new int[WIDTH][k];
            for (int j = 0; j < WIDTH; j++) {
                int cur = grid[i][j];
                for (int mod = 0; mod < k; mod++) {
                    int newMod = (cur + mod) % k;
                    if (j > 0)
                        row[j][newMod] = (row[j][newMod] + row[j - 1][mod]) % MOD;
                    row[j][newMod] = (row[j][newMod] + prev[j][mod]) % MOD;
                }
            }
            prev = row;
        }
        return prev[WIDTH - 1][0];
    }


}
