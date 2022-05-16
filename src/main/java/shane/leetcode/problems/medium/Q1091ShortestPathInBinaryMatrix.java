package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1091ShortestPathInBinaryMatrix {

    @Test
    public void test() {
        assertThat(shortestPathBinaryMatrix(STool.convertToIntArray("[[0,1,1,0,0,0],[0,1,0,1,1,0],[0,1,1,0,1,0],[0,0,0,1,1,0],[1,1,1,1,1,0],[1,1,1,1,1,0]]")))
                .isEqualTo(14);
        assertThat(shortestPathBinaryMatrix(STool.convertToIntArray("[[0,0,0],[1,0,0],[1,1,0]]"))).isEqualTo(3);
        assertThat(shortestPathBinaryMatrix(STool.convertToIntArray("[[0,0,0],[1,1,0],[1,1,0]]"))).isEqualTo(4);
        assertThat(shortestPathBinaryMatrix(STool.convertToIntArray("[[0,1],[1,0]]"))).isEqualTo(2);
        assertThat(shortestPathBinaryMatrix(STool.convertToIntArray("[[1,0,0],[1,1,0],[1,1,0]]"))).isEqualTo(-1);
        assertThat(shortestPathBinaryMatrix(STool.convertToIntArray("[[0,0,0],[1,1,0],[1,1,1]]"))).isEqualTo(-1);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        if (grid[0][0] == 1)
            return -1;

        final int HEIGHT = grid.length;
        final int WIDTH = grid[0].length;
        final int INF = Integer.MAX_VALUE;

        int[][] distances = new int[HEIGHT][WIDTH];
        for (int[] distance : distances) {
            Arrays.fill(distance, INF);
        }
        distances[0][0] = 1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int y = poll[0];
            int x = poll[1];


            // left
            if (x > 0 && grid[y][x - 1] == 0 && distances[y][x - 1] > distances[y][x] + 1) {
                q.offer(new int[]{y, x - 1});
                distances[y][x - 1] = distances[y][x] + 1;
            }

            // right
            if (x < WIDTH - 1 && grid[y][x + 1] == 0 && distances[y][x + 1] > distances[y][x] + 1) {
                q.offer(new int[]{y, x + 1});
                distances[y][x + 1] = distances[y][x] + 1;
            }

            // up
            if (y > 0 && grid[y - 1][x] == 0 && distances[y - 1][x] > distances[y][x] + 1) {
                q.offer(new int[]{y - 1, x});
                distances[y - 1][x] = distances[y][x] + 1;
            }

            // down
            if (y < HEIGHT - 1 && grid[y + 1][x] == 0 && distances[y + 1][x] > distances[y][x] + 1) {
                q.offer(new int[]{y + 1, x});
                distances[y + 1][x] = distances[y][x] + 1;
            }

            // leftup
            if (y > 0 && x > 0 && grid[y - 1][x - 1] == 0 && distances[y - 1][x - 1] > distances[y][x] + 1) {
                q.offer(new int[]{y - 1, x - 1});
                distances[y - 1][x - 1] = distances[y][x] + 1;
            }

            // rightup
            if (y > 0 && x < WIDTH - 1 && grid[y - 1][x + 1] == 0 && distances[y - 1][x + 1] > distances[y][x] + 1) {
                q.offer(new int[]{y - 1, x + 1});
                distances[y - 1][x + 1] = distances[y][x] + 1;
            }

            // rightdown
            if (y < HEIGHT - 1 && x < WIDTH - 1 && grid[y + 1][x + 1] == 0 && distances[y + 1][x + 1] > distances[y][x] + 1) {
                q.offer(new int[]{y + 1, x + 1});
                distances[y + 1][x + 1] = distances[y][x] + 1;
            }

            // leftdown
            if (y < HEIGHT - 1 && x > 0 && grid[y + 1][x - 1] == 0 && distances[y + 1][x - 1] > distances[y][x] + 1) {
                q.offer(new int[]{y + 1, x - 1});
                distances[y + 1][x - 1] = distances[y][x] + 1;
            }
        }

        return distances[HEIGHT - 1][WIDTH - 1] == INF ? -1 : distances[HEIGHT - 1][WIDTH - 1];
    }
}
