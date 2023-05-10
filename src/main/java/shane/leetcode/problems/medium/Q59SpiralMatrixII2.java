package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 40.8 MB Beats 43.43%
 */
public class Q59SpiralMatrixII2 {

    @Test
    public void test() {
        assertThat(generateMatrix(3)).isDeepEqualTo(Ps.intArray("[[1,2,3],[8,9,4],[7,6,5]]"));
        assertThat(generateMatrix(1)).isDeepEqualTo(Ps.intArray("[[1]]"));
    }

    int y;
    int x;
    int cur;
    int[][] answer;
    int target;

    public int[][] generateMatrix(int n) {
        answer = new int[n][n];
        y = 0;
        x = 0;
        cur = 1;
        answer[0][0] = cur++;
        target = n * n;
        final int[][] DIRS = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while (cur <= target) {
            for (int[] dir : DIRS) {
                move(dir);
            }
        }
        return answer;
    }

    private void move(int[] dir) {
        while (true) {
            int nextY = y + dir[0];
            int nextX = x + dir[1];
            if (nextY < 0 || nextY == answer.length || nextX < 0 || nextX == answer[0].length || answer[nextY][nextX] > 0) {
                break;
            }
            y = nextY;
            x = nextX;
            answer[y][x] = cur++;
        }
    }

}
