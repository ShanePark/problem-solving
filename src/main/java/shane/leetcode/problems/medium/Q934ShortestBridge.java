package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 68 ms Beats 9.94%
 * Memory 44.5 MB Beats 5.97%
 */
public class Q934ShortestBridge {

    @Test
    void test() {
        assertThat(shortestBridge(Ps.intArray("[[0,1],[1,0]]"))).isEqualTo(1);
        assertThat(shortestBridge(Ps.intArray("[[0,1,0],[0,0,0],[0,0,1]]"))).isEqualTo(2);
        assertThat(shortestBridge(Ps.intArray("[[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]"))).isEqualTo(1);
    }

    final int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int shortestBridge(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;

        findOneIslandAndChangeColor(grid);

        int[][][] distances = initDistances(height, width);
        calcDistance(grid, distances);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                min = Math.min(min, distances[i][j][0] + distances[i][j][1]);
            }
        }
        return min - 1;
    }

    private int[][][] initDistances(int height, int width) {
        int[][][] distances = new int[height][width][2];
        for (int[][] distance : distances) {
            for (int[] ints : distance) {
                Arrays.fill(ints, Integer.MAX_VALUE);
            }
        }
        return distances;
    }

    private void calcDistance(int[][] grid, int[][][] distances) {
        Queue<int[]> land1 = new LinkedList<>();
        Queue<int[]> land2 = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    land1.offer(new int[]{i, j});
                    continue;
                }
                if (grid[i][j] == 2) {
                    land2.offer(new int[]{i, j});
                }
            }
        }
        markDistance(distances, land1, 0);
        markDistance(distances, land2, 1);
    }

    private void markDistance(int[][][] distances, Queue<int[]> q, int index) {
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                int y = poll[0];
                int x = poll[1];
                if (0 <= y && y < distances.length && 0 <= x && x < distances[0].length && distance < distances[y][x][index]) {
                    distances[y][x][index] = distance;
                    for (int[] dir : DIRS) {
                        q.offer(new int[]{y + dir[0], x + dir[1]});
                    }
                }
            }
            distance++;
        }
    }

    private void findOneIslandAndChangeColor(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 1) {
                    fillColor(grid, i, j);
                    return;
                }
            }
        }
    }

    private void fillColor(int[][] grid, int i, int j) {
        grid[i][j] = 2;
        for (int[] dir : DIRS) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (0 <= y && y < grid.length && 0 <= x && x < grid[0].length && grid[y][x] == 1) {
                fillColor(grid, y, x);
            }
        }
    }

}
