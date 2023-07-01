package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 * 96 / 118 testcases passed
 */
public class Q1970LastDayWhereYouCanStillCross {

    @Test
    public void test() {
        assertThat(latestDayToCross(2, 2, Ps.intArray("[[1,1],[2,1],[1,2],[2,2]]"))).isEqualTo(2);
        assertThat(latestDayToCross(2, 2, Ps.intArray("[[1,1],[1,2],[2,1],[2,2]]"))).isEqualTo(1);
        assertThat(latestDayToCross(3, 3, Ps.intArray("[[1,2],[2,1],[3,3],[2,2],[1,1],[1,3],[2,3],[3,2],[3,1]]"))).isEqualTo(3);
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        boolean[][] water = new boolean[row][col];
        Set<String> lastWayToWater = null;
        for (int i = 0; i < cells.length; i++) {
            int[] cell = cells[i];
            int y = cell[0] - 1;
            int x = cell[1] - 1;
            water[y][x] = true;
            if (lastWayToWater == null || lastWayToWater.contains(y + "," + x)) {
                lastWayToWater = wayToEnd(water);
                if (lastWayToWater == null) {
                    return i;
                }
            }
        }
        return cells.length;
    }

    private Set<String> wayToEnd(boolean[][] water) {
        int rows = water.length;
        int cols = water[0].length;
        for (int col = 0; col < cols; col++) {
            if (!water[0][col]) {
                Set<String> visited = new HashSet<>();
                if (dfs(water, 0, col, visited)) {
                    return visited;
                }
            }
        }
        return null;
    }

    private boolean dfs(boolean[][] water, int row, int col, Set<String> visited) {
        if (row < 0 || row >= water.length || col < 0 || col >= water[0].length || water[row][col] || visited.contains(row + "," + col)) {
            return false;
        }
        visited.add(row + "," + col);
        if (row == water.length - 1) {
            return true;
        }
        return dfs(water, row - 1, col, visited) || dfs(water, row + 1, col, visited) || dfs(water, row, col - 1, visited) || dfs(water, row, col + 1, visited);
    }

}
