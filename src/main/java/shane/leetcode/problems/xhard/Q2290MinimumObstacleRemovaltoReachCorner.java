package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 176ms Beats15.00%
 */
public class Q2290MinimumObstacleRemovaltoReachCorner {

    @Test
    public void test() {
        assertThat(minimumObstacles(Ps.intArray("[[0,1,1],[1,1,0],[1,1,0]]"))).isEqualTo(2);
        assertThat(minimumObstacles(Ps.intArray("[[0,1,0,0,0],[0,1,0,1,0],[0,0,0,1,0]]"))).isEqualTo(0);
    }

    public int minimumObstacles(int[][] grid) {
        int HEIGHT = grid.length;
        int WIDTH = grid[0].length;
        int[][] min = new int[HEIGHT][WIDTH];
        for (int[] ints : min) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }
        min[0][0] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                for (int[] dir : DIRS) {
                    int y = poll[0] + dir[0];
                    int x = poll[1] + dir[1];
                    if (y < 0 || y == HEIGHT || x < 0 || x == WIDTH) {
                        continue;
                    }
                    int next = min[poll[0]][poll[1]] + grid[y][x];
                    if (min[y][x] <= next) {
                        continue;
                    }
                    min[y][x] = next;
                    q.offer(new int[]{y, x});
                }
            }
        }

        return min[HEIGHT - 1][WIDTH - 1];
    }

}
