package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1631PathWithMinimumEffort {

    @Test
    public void test() {
        assertThat(minimumEffortPath(STool.convertToIntArray("[[1,2,2],[3,8,2],[5,3,5]]"))).isEqualTo(2);
        assertThat(minimumEffortPath(STool.convertToIntArray("[[1,2,3],[3,8,4],[5,3,5]]"))).isEqualTo(1);
        assertThat(minimumEffortPath(STool.convertToIntArray("[[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]]"))).isEqualTo(0);
    }

    int result;

    public int minimumEffortPath(int[][] heights) {
        result = Integer.MAX_VALUE;

        final int HEIGHT = heights.length;
        final int WIDTH = heights[0].length;

        boolean[][] visited = new boolean[HEIGHT][WIDTH];
        visited[0][0] = true;

        dfs(0, 0, heights, visited, 0);
        return result;
    }

    void dfs(int y, int x, int[][] heights, boolean[][] visited, int curMax) {
        if (result <= curMax)
            return;

        if ((y == visited.length - 1) && (x == visited[0].length - 1)) {
            result = curMax;
        }

        if (x > 0 && !visited[y][x - 1]) {
            visited[y][x - 1] = true;
            dfs(y, x - 1, heights, visited, Math.max(curMax, Math.abs(heights[y][x] - heights[y][x - 1])));
            visited[y][x - 1] = false;
        }
        if (y > 0 && !visited[y - 1][x]) {
            visited[y - 1][x] = true;
            dfs(y - 1, x, heights, visited, Math.max(curMax, Math.abs(heights[y][x] - heights[y - 1][x])));
            visited[y - 1][x] = false;

        }
        if (y < visited.length - 1 && !visited[y + 1][x]) {
            visited[y + 1][x] = true;
            dfs(y + 1, x, heights, visited, Math.max(curMax, Math.abs(heights[y][x] - heights[y + 1][x])));
            visited[y + 1][x] = false;

        }
        if (x < visited[0].length - 1 && !visited[y][x + 1]) {
            visited[y][x + 1] = true;
            dfs(y, x + 1, heights, visited, Math.max(curMax, Math.abs(heights[y][x] - heights[y][x + 1])));
            visited[y][x + 1] = false;
        }

    }
}
