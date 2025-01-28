package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 13
 * ms
 * Beats
 * 10.92%
 */
public class Q2658MaximumNumberOfFishInAGrid {
    @Test
    public void test() {
        assertThat(findMaxFish(Ps.intArray("[[0,2,1,0],[4,0,0,3],[1,0,0,4],[0,3,2,0]]"))).isEqualTo(7);
        assertThat(findMaxFish(Ps.intArray("[[1,0,0,0],[0,0,0,0],[0,0,0,0],[0,0,0,1]]"))).isEqualTo(1);
        assertThat(findMaxFish(Ps.intArray("[[4,5,5],[0,10,0]]"))).isEqualTo(24);
    }

    int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int findMaxFish(int[][] grid) {
        Map<Integer, Integer> groupSum = new HashMap<>();
        int index = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    continue;
                dfs(grid, groupSum, i, j, index++);
            }
        }
        return groupSum.values().stream().mapToInt(Integer::valueOf).max().orElse(0);
    }

    private void dfs(int[][] grid, Map<Integer, Integer> groupSum, int i, int j, int index) {
        groupSum.merge(index, grid[i][j], Integer::sum);
        grid[i][j] = 0;
        for (int[] dir : DIRS) {
            int y = i + dir[0];
            int x = j + dir[1];
            if (y < 0 || y == grid.length || x < 0 || x == grid[0].length || grid[y][x] == 0)
                continue;
            dfs(grid, groupSum, y, x, index);
        }
    }

}
