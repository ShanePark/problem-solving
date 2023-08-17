package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q54201Matrix2 {

    @Test
    public void test() {
        assertThat(updateMatrix(Ps.intArray("[[0,0,0],[0,1,0],[1,1,1]]"))).isEqualTo(Ps.intArray("[[0,0,0],[0,1,0],[1,2,1]]"));
        assertThat(updateMatrix(Ps.intArray("[[0,0,0],[0,1,0],[0,0,0]]"))).isEqualTo(Ps.intArray("[[0,0,0],[0,1,0],[0,0,0]]"));
    }

    public int[][] updateMatrix(int[][] mat) {
        int HEIGHT = mat.length;
        int WIDTH = mat[0].length;
        int INF = WIDTH + HEIGHT;

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (mat[i][j] == 0)
                    continue;
                int top = (i > 0) ? mat[i - 1][j] : INF;
                int left = (j > 0) ? mat[i][j - 1] : INF;
                mat[i][j] = Math.min(top, left) + 1;
            }
        }

        for (int i = HEIGHT - 1; i >= 0; i--) {
            for (int j = WIDTH - 1; j >= 0; j--) {
                if (mat[i][j] == 0)
                    continue;
                int bottom = (i < HEIGHT - 1) ? mat[i + 1][j] : INF;
                int right = (j < WIDTH - 1) ? mat[i][j + 1] : INF;
                mat[i][j] = Math.min(mat[i][j], Math.min(bottom, right) + 1);
            }
        }
        return mat;
    }

}
