package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 82
 * ms
 * Beats
 * 80.04%
 */
public class Q827MakingALargeIsland2 {

    @Test
    public void test() {
        assertThat(largestIsland(Ps.intArray("[[1,1],[1,1]]"))).isEqualTo(4);
        assertThat(largestIsland(Ps.intArray("[[1,1],[1,0]]"))).isEqualTo(4);
        assertThat(largestIsland(Ps.intArray("[[1,0],[0,1]]"))).isEqualTo(3);
    }

    @Test
    public void test2() {
        assertThat(largestIsland(Ps.intArray("[" +
                "[0,0,0,0,0,0,0]," +
                "[0,1,1,1,1,0,0]," +
                "[0,1,0,0,1,0,0]," +
                "[1,0,1,0,1,0,0]," +
                "[0,1,0,0,1,0,0]," +
                "[0,1,0,0,1,0,0]," +
                "[0,1,1,1,1,0,0]]"))).isEqualTo(18);
        assertThat(largestIsland(Ps.intArray("[[0,0],[0,0]]"))).isEqualTo(1);
    }

    int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int largestIsland(int[][] grid) {
        int index = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    fill(grid, i, j, --index);
                }
            }
        }
        Map<Integer, Integer> countByIndex = new HashMap<>();
        int max = 1;
        for (int[] ints : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                if (ints[j] == 0)
                    continue;
                max = Math.max(max, countByIndex.merge(ints[j], 1, Integer::sum));
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0)
                    continue;
                Set<Integer> visited = new HashSet<>();
                int sum = 1;
                for (int[] dir : DIRS) {
                    int y = dir[0] + i;
                    int x = dir[1] + j;
                    if (y < 0 || y == grid.length || x < 0 || x == grid[0].length || grid[y][x] == 0)
                        continue;
                    if (visited.add(grid[y][x])) {
                        sum += countByIndex.get(grid[y][x]);
                    }
                }

                max = Math.max(max, sum);
            }
        }
        return max;
    }

    private void fill(int[][] grid, int i, int j, int index) {
        grid[i][j] = index;
        for (int[] dir : DIRS) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (y < 0 || y == grid.length || x < 0 || x == grid[0].length || grid[y][x] < 1) {
                continue;
            }
            fill(grid, y, x, index);
        }
    }

}
