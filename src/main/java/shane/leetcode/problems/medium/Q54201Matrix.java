package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 1149ms Beats 5.06%of users with Java
 * Memory Details 46.42mb Beats 23.14%of users with Java
 */
public class Q54201Matrix {

    @Test
    public void test() {
        assertThat(updateMatrix(Ps.intArray("[[0,0,0],[0,1,0],[1,1,1]]"))).isEqualTo(Ps.intArray("[[0,0,0],[0,1,0],[1,2,1]]"));
        assertThat(updateMatrix(Ps.intArray("[[0,0,0],[0,1,0],[0,0,0]]"))).isEqualTo(Ps.intArray("[[0,0,0],[0,1,0],[0,0,0]]"));
    }

    public int[][] updateMatrix(int[][] mat) {
        final int HEIGHT = mat.length;
        final int WIDTH = mat[0].length;
        int[][] answer = new int[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (mat[i][j] == 0) {
                    answer[i][j] = 0;
                    continue;
                }
                answer[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (answer[i][j] != 0) {
                    continue;
                }
                dfs(answer, i, j);
            }
        }
        return answer;
    }

    final int[][] DIRS = new int[][]{{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    private void dfs(int[][] answer, int i, int j) {
        for (int[] dir : DIRS) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (y < 0 || x < 0 || y >= answer.length || x >= answer[0].length) {
                continue;
            }
            int cur = answer[i][j];
            if (answer[y][x] > cur + 1) {
                answer[y][x] = cur + 1;
                dfs(answer, y, x);
            }
        }
    }

}
