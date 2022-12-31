package shane.leetcode.problems.xhard;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 85.48%
 * Memory 39.5 MB Beats 89.46%
 */
public class Q980UniquePathsIII2 {

    @Test
    public void test() {
        assertThat(uniquePathsIII(STool.convertToIntArray("[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]"))).isEqualTo(2);
        assertThat(uniquePathsIII(STool.convertToIntArray("[[1,0,0,0],[0,0,0,0],[0,0,0,2]]"))).isEqualTo(4);
        assertThat(uniquePathsIII(STool.convertToIntArray("[[0,1],[2,0]]"))).isEqualTo(0);
    }

    int cnt = 0;
    final int[][] DIRS = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public int uniquePathsIII(int[][] grid) {
        this.cnt = 0;
        int length = 1;
        int startY = -1;
        int startX = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0)
                    length++;
                if (grid[i][j] == 1) {
                    startY = i;
                    startX = j;
                }
            }
        }

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[startY][startX] = true;
        dfs(startY, startX, grid, visited, 0, length);
        return cnt;
    }

    private void dfs(int y, int x, int[][] grid, boolean[][] visited, int cur, long target) {
        if (grid[y][x] == 2) {
            if (cur == target) {
                cnt++;
            }
            return;
        }

        for (int[] dir : DIRS) {
            int nextY = y + dir[0];
            int nextX = x + dir[1];
            if (0 <= nextY && 0 <= nextX && nextY < grid.length && nextX < grid[0].length && !visited[nextY][nextX] && grid[nextY][nextX] != -1) {
                visited[nextY][nextX] = true;
                dfs(nextY, nextX, grid, visited, cur + 1, target);
                visited[nextY][nextX] = false;
            }
        }

    }

}
