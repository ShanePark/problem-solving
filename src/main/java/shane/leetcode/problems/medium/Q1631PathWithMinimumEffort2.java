package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
@SuppressWarnings("ALL")
public class Q1631PathWithMinimumEffort2 {

    @Test
    public void test() {
        assertThat(minimumEffortPath(Ps.intArray("[[1,2,2],[3,8,2],[5,3,5]]"))).isEqualTo(2);
        assertThat(minimumEffortPath(Ps.intArray("[[1,2,3],[3,8,4],[5,3,5]]"))).isEqualTo(1);
        assertThat(minimumEffortPath(Ps.intArray("[[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]"))).isEqualTo(0);
    }

    int result;

    public int minimumEffortPath(int[][] heights) {
        result = Integer.MAX_VALUE;

        final int HEIGHT = heights.length;
        final int WIDTH = heights[0].length;

        int[][] visited = new int[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                visited[i][j] = Integer.MAX_VALUE;
            }
        }

        dfs(0, 0, heights, visited, 0);
        return result;
    }

    void dfs(int y, int x, int[][] heights, int[][] visited, int curMax) {
        if (result <= curMax || visited[y][x] <= curMax)
            return;
        visited[y][x] = curMax;

        if ((y == visited.length - 1) && (x == visited[0].length - 1)) {
            result = curMax;
        }

        if (x > 0) {
            dfs(y, x - 1, heights, visited, Math.max(curMax, Math.abs(heights[y][x] - heights[y][x - 1])));
        }
        if (y > 0) {
            dfs(y - 1, x, heights, visited, Math.max(curMax, Math.abs(heights[y][x] - heights[y - 1][x])));
        }
        if (y < visited.length - 1) {
            dfs(y + 1, x, heights, visited, Math.max(curMax, Math.abs(heights[y][x] - heights[y + 1][x])));
        }
        if (x < visited[0].length - 1) {
            dfs(y, x + 1, heights, visited, Math.max(curMax, Math.abs(heights[y][x] - heights[y][x + 1])));
        }

    }
}
