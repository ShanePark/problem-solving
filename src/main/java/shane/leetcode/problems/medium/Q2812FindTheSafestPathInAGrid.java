package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2355 ms Beats 5.33% of users with Java
 */
public class Q2812FindTheSafestPathInAGrid {

    @Test
    public void test() {
        assertThat(maximumSafenessFactor(Ps.intList("[[1,1,1],[0,1,1],[0,0,0]]"))).isEqualTo(0);
        assertThat(maximumSafenessFactor(Ps.intList("[[1,1],[1,1]]"))).isEqualTo(0);
        assertThat(maximumSafenessFactor(Ps.intList("[[1]]"))).isEqualTo(0);
        assertThat(maximumSafenessFactor(Ps.intList("[[0,0,0,1],[0,0,0,0],[0,0,0,0],[1,0,0,0]]"))).isEqualTo(2);
        assertThat(maximumSafenessFactor(Ps.intList("[[1,0,0],[0,0,0],[0,0,1]]"))).isEqualTo(0);
        assertThat(maximumSafenessFactor(Ps.intList("[[0,0,1],[0,0,0],[0,0,0]]"))).isEqualTo(2);
    }

    @Test
    public void tle() {
        assertThat(maximumSafenessFactor(Ps.intList("[[0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1],[0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1],[0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1],[0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1],[0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1],[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1],[1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1],[1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1],[1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1],[1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0],[1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0],[1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0],[1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0],[1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0]]")))
                .isEqualTo(6);
    }

    @Test
    public void tle2() {
        assertThat(maximumSafenessFactor(Ps.intList("[[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0],[0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0]]")))
                .isEqualTo(22);
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        // 1. find the distance
        int HEIGHT = grid.size();
        int WIDTH = grid.get(0).size();
        int[][] distance = new int[grid.size()][grid.get(0).size()];
        for (int[] ints : distance) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (grid.get(i).get(j) == 1) {
                    q.offer(new int[]{i, j});
                }
            }
        }

        int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int curDistance = -1;
        while (!q.isEmpty()) {
            curDistance++;
            int size = q.size();
            for (int k = 0; k < size; k++) {
                int[] poll = q.poll();
                int i = poll[0];
                int j = poll[1];
                if (distance[i][j] <= curDistance)
                    continue;
                distance[i][j] = curDistance;
                for (int[] dir : DIRS) {
                    int y = i + dir[0];
                    int x = j + dir[1];
                    if (y < 0 || y == HEIGHT || x < 0 || x == WIDTH || distance[y][x] <= curDistance + 1) {
                        continue;
                    }
                    q.offer(new int[]{y, x});
                }
            }
        }

        // 2. find the min distance
        for (; curDistance > 0; curDistance--) {
            boolean[][] visited = new boolean[HEIGHT][WIDTH];
            visited[0][0] = true;
            if (distance[0][0] < curDistance)
                continue;
            q = new LinkedList<>();
            q.offer(new int[]{0, 0});
            while (!q.isEmpty()) {
                int size = q.size();
                for (int k = 0; k < size; k++) {
                    int[] poll = q.poll();
                    int i = poll[0];
                    int j = poll[1];
                    if (i == HEIGHT - 1 && j == WIDTH - 1) {
                        return curDistance;
                    }
                    for (int[] dir : DIRS) {
                        int y = i + dir[0];
                        int x = j + dir[1];
                        if (y < 0 || y == HEIGHT || x < 0 || x == WIDTH || distance[y][x] < curDistance || visited[y][x])
                            continue;
                        visited[y][x] = true;
                        q.offer(new int[]{y, x});
                    }
                }
            }
        }
        return 0;
    }

}
