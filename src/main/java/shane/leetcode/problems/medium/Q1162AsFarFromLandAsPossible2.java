package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 15 ms Beats 72.46%
 * Memory 43.1 MB Beats 85.67%
 */
public class Q1162AsFarFromLandAsPossible2 {

    @Test
    public void test() {
        assertThat(maxDistance(STool.convertToIntArray("[[1,0,1],[0,0,0],[1,0,1]]"))).isEqualTo(2);
        assertThat(maxDistance(STool.convertToIntArray("[[1,0,0],[0,0,0],[0,0,0]]"))).isEqualTo(4);
    }

    int[][] DIRS = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    public int maxDistance(int[][] grid) {
        int width = grid[0].length;
        int height = grid.length;
        int[][] distances = new int[height][width];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    distances[i][j] = 0;
                    q.offer(new int[]{i, j});
                } else {
                    distances[i][j] = -1;
                }
            }
        }

        if (q.size() == 0 || q.size() == width * height) {
            return -1;
        }

        int distance = 1;
        int max = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] poll = q.poll();
                for (int[] dir : DIRS) {
                    int y = dir[0] + poll[0];
                    int x = dir[1] + poll[1];
                    if (y < 0 || y == height || x < 0 || x == width)
                        continue;
                    if (distances[y][x] == -1 || distance < distances[y][x]) {
                        max = Math.max(max, distances[y][x] = distance);
                        q.offer(new int[]{y, x});
                    }
                }
            }
            distance++;
        }

        return max;
    }

}
