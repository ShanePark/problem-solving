package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 80ms Beats 20.85%of users with Java
 * Memory Details 43.99MB Beats 78.04%of users with Java
 */
@SuppressWarnings("ALL")
public class Q1631PathWithMinimumEffort6 {

    @Test
    public void test() {
        assertThat(minimumEffortPath(Ps.intArray("[[1,10,6,7,9,10,4,9]]"))).isEqualTo(9);
        assertThat(minimumEffortPath(Ps.intArray("[[1,2,2],[3,8,2],[5,3,5]]"))).isEqualTo(2);
        assertThat(minimumEffortPath(Ps.intArray("[[1,2,3],[3,8,4],[5,3,5]]"))).isEqualTo(1);
        assertThat(minimumEffortPath(Ps.intArray("[[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]"))).isEqualTo(0);
    }

    @Test
    public void stackOverflow() {
        int[][] arr = new int[200][200];
        for (int[] ints : arr) {
            Arrays.fill(ints, 1);
        }
        assertThat(minimumEffortPath(arr)).isEqualTo(0);
    }

    public int minimumEffortPath(int[][] heights) {
        final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        final int HEIGHT = heights.length;
        final int WIDTH = heights[0].length;
        int[][] dp = new int[HEIGHT][WIDTH];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();
        dp[0][0] = 0;
        q.offer(new int[]{0, 0});

        int curMax = 0;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int i = poll[0];
            int j = poll[1];
            for (int[] dir : DIRS) {
                int y = i + dir[0];
                int x = j + dir[1];
                if (0 <= y && y < HEIGHT && 0 <= x && x < WIDTH) {
                    int next = Math.max(dp[i][j], Math.abs(heights[i][j] - heights[y][x]));
                    if (next < dp[y][x]) {
                        dp[y][x] = next;
                        q.offer(new int[]{y, x});
                    }
                }
            }
        }
        return dp[HEIGHT - 1][WIDTH - 1];
    }

}
