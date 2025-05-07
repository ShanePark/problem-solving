package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 485ms
 * Beats5.61%
 */
public class Q3341FindMinimumTimeToReachLastRoomI {

    @Test
    public void test() {
        assertThat(minTimeToReach(Ps.intArray("[[0,4],[4,4]]"))).isEqualTo(6);
        assertThat(minTimeToReach(Ps.intArray("[[0,0,0],[0,0,0]]"))).isEqualTo(3);
    }

    public int minTimeToReach(int[][] moveTime) {
        final int WIDTH = moveTime[0].length;
        final int HEIGHT = moveTime.length;
        Integer[][] min = new Integer[HEIGHT][WIDTH];
        move(moveTime, min, 0, 0, 0);
        return min[HEIGHT - 1][WIDTH - 1];
    }

    int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private void move(int[][] moveTime, Integer[][] min, int i, int j, int cur) {
        min[i][j] = cur;
        for (int[] dir : DIRS) {
            int y = dir[0] + i;
            int x = dir[1] + j;
            if (y < 0 || y == moveTime.length || x < 0 || x == moveTime[0].length || (min[y][x] != null && min[y][x] <= cur + 1))
                continue;
            move(moveTime, min, y, x, Math.max(cur + 1, moveTime[y][x] + 1));
        }
    }

}
