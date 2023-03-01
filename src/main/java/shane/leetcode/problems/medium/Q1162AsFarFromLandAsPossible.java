package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1741 ms Beats 5.1%
 * Memory 43.6 MB Beats 45.20%
 */
public class Q1162AsFarFromLandAsPossible {

    @Test
    public void test() {
        assertThat(maxDistance(Ps.intArray("[[1,0,1],[0,0,0],[1,0,1]]"))).isEqualTo(2);
        assertThat(maxDistance(Ps.intArray("[[1,0,0],[0,0,0],[0,0,0]]"))).isEqualTo(4);
    }

    public int maxDistance(int[][] grid) {
        int width = grid[0].length;
        int height = grid.length;
        int[][] distances = new int[height][width];

        boolean hasLand = false;
        boolean hasWater = false;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    distances[i][j] = 0;
                    hasLand = true;
                } else {
                    distances[i][j] = -1;
                    hasWater = true;
                }
            }
        }

        if (!hasLand || !hasWater) {
            return -1;
        }

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (distances[i][j] == 0) {
                    dfs(i, j, distances);
                }
            }
        }
        int max = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                max = Math.max(max, distances[i][j]);
            }
        }
        return max;
    }

    int[][] DIRS = new int[][]{{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    private void dfs(int i, int j, int[][] distances) {
        int myDistance = distances[i][j];
        int height = distances.length;
        int width = distances[0].length;
        for (int[] dir : DIRS) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (0 <= y && y < height && 0 <= x && x < width) {
                int distance = distances[y][x];
                if (distance == -1 || myDistance + 1 < distance) {
                    distances[y][x] = myDistance + 1;
                    dfs(y, x, distances);
                }
            }
        }
    }

}
