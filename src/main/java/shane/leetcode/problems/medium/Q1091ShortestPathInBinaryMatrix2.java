package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1091ShortestPathInBinaryMatrix2 {

    @Test
    public void test() {
        assertThat(shortestPathBinaryMatrix(Ps.intArray("[[0,1,1,0,0,0],[0,1,0,1,1,0],[0,1,1,0,1,0],[0,0,0,1,1,0],[1,1,1,1,1,0],[1,1,1,1,1,0]]")))
                .isEqualTo(14);
        assertThat(shortestPathBinaryMatrix(Ps.intArray("[[0,0,0],[1,0,0],[1,1,0]]"))).isEqualTo(3);
        assertThat(shortestPathBinaryMatrix(Ps.intArray("[[0,0,0],[1,1,0],[1,1,0]]"))).isEqualTo(4);
        assertThat(shortestPathBinaryMatrix(Ps.intArray("[[0,1],[1,0]]"))).isEqualTo(2);
        assertThat(shortestPathBinaryMatrix(Ps.intArray("[[1,0,0],[1,1,0],[1,1,0]]"))).isEqualTo(-1);
        assertThat(shortestPathBinaryMatrix(Ps.intArray("[[0,0,0],[1,1,0],[1,1,1]]"))).isEqualTo(-1);
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        final int HEIGHT = grid.length;
        final int WIDTH = grid[0].length;
        final int[][] DIRS = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, 0}, {1, 1}, {1, -1}};

        if (grid[0][0] == 1 || grid[HEIGHT - 1][WIDTH - 1] == 1)
            return -1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});

        int cnt = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                int y = poll[0];
                int x = poll[1];
                if (y == HEIGHT - 1 && x == WIDTH - 1) {
                    return cnt;
                }
                for (int[] dir : DIRS) {
                    int y2 = y + dir[0];
                    int x2 = x + dir[1];

                    if (0 <= x2 && x2 < WIDTH && 0 <= y2 && y2 < HEIGHT && grid[y2][x2] == 0) {
                        grid[y2][x2] = 1;
                        q.offer(new int[]{y2, x2});
                    }
                }
            }
            cnt++;
        }
        return -1;
    }
}
