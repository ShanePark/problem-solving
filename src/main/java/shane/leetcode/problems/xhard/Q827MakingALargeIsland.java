package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 232
 * ms
 * Beats
 * 6.91%
 */
public class Q827MakingALargeIsland {

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
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                countByIndex.merge(grid[i][j], 1, Integer::sum);
            }
        }

        int max = countByIndex.values().stream().mapToInt(Integer::valueOf).max().orElse(1);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0)
                    continue;
                Set<Integer> adjacent = new HashSet<>();
                for (int[] dir : DIRS) {
                    int y = dir[0] + i;
                    int x = dir[1] + j;
                    if (y < 0 || y == grid.length || x < 0 || x == grid[0].length || grid[y][x] == 0)
                        continue;
                    adjacent.add(grid[y][x]);
                }
                if (adjacent.isEmpty())
                    continue;
                int sumOfAdjacent = adjacent.stream()
                        .map(countByIndex::get)
                        .sorted(Comparator.reverseOrder())
                        .mapToInt(Integer::valueOf)
                        .sum();
                max = Math.max(max, sumOfAdjacent + 1);
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
