package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Can't pass test2
 */
public class Q2017GridGame {

    @Test
    public void test() {
        assertThat(gridGame(Ps.intArray("[[2,5,4],[1,5,1]]"))).isEqualTo(4);
        assertThat(gridGame(Ps.intArray("[[3,3,1],[8,5,2]]"))).isEqualTo(4);
    }

    @Test
    public void test2() {
        assertThat(gridGame(Ps.intArray("[" +
                "[20, 3,20,17, 2,12,15,17, 4,15]," +
                "[20,10,13,14,15, 5, 2, 3,14, 3]]"))).isEqualTo(63);
    }

    public long gridGame(int[][] grid) {
        final int HEIGHT = grid.length;
        int WIDTH = grid[0].length;
        long[][] dp = new long[HEIGHT][WIDTH];
        Map<String, int[]> beforeMap = new HashMap<>();

        Queue<int[]> q = new LinkedList<>();
        dp[0][0] = grid[0][0];
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            long cur = dp[y][x];
            // right
            if (x + 1 < WIDTH && dp[y][x + 1] < cur + grid[y][x + 1]) {
                dp[y][x + 1] = cur + grid[y][x + 1];
                int[] next = {y, x + 1};
                beforeMap.put(y + " " + (x + 1), poll);
                q.offer(next);
            }

            // down
            if (y + 1 < HEIGHT && dp[y + 1][x] < cur + grid[y + 1][x]) {
                dp[y + 1][x] = cur + grid[y + 1][x];
                int[] next = {y + 1, x};
                beforeMap.put((y + 1) + " " + x, poll);
                q.offer(next);
            }
        }

        int[] before = new int[]{HEIGHT - 1, WIDTH - 1};

        while (before != null) {
            int y = before[0];
            int x = before[1];
            grid[y][x] = 0;
            before = beforeMap.get(y + " " + x);
        }

        // Second robot start
        dp = new long[HEIGHT][WIDTH];
        boolean[][] visited = new boolean[HEIGHT][WIDTH];
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];
            long cur = dp[y][x];
            // right
            if (x + 1 < WIDTH && (!visited[y][x + 1] || dp[y][x + 1] < cur + grid[y][x + 1])) {
                visited[y][x + 1] = true;
                dp[y][x + 1] = cur + grid[y][x + 1];
                int[] next = {y, x + 1};
                q.offer(next);
            }

            // down
            if (y + 1 < HEIGHT && (!visited[y + 1][x] || dp[y + 1][x] < cur + grid[y + 1][x])) {
                visited[y + 1][x] = true;
                dp[y + 1][x] = cur + grid[y + 1][x];
                int[] next = {y + 1, x};
                q.offer(next);
            }
        }
        return dp[HEIGHT - 1][WIDTH - 1];
    }

}
