package shane.leetcode.problems.medium;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 3 ms, faster than 97.77% of Java online submissions for Number of Islands.
 * Memory Usage: 50.7 MB, less than 93.80% of Java online submissions for Number of Islands.
 */
public class Q200NumberOfIslands {

    @Test
    public void test() {
        assertThat(numIslands(Ps.charArray("[\n" +
                "  [\"1\",\"1\",\"1\",\"1\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"1\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"0\",\"0\",\"0\"]\n" +
                "]"))).isEqualTo(1);
        assertThat(numIslands(Ps.charArray("[\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"1\",\"1\",\"0\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"1\",\"0\",\"0\"],\n" +
                "  [\"0\",\"0\",\"0\",\"1\",\"1\"]\n" +
                "]"))).isEqualTo(3);
    }

    public int numIslands(char[][] grid) {
        final int HEIGHT = grid.length;
        final int WIDTH = grid[0].length;
        int cnt = 0;

        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (dfs(i, j, grid))
                    cnt++;
            }
        }
        return cnt;
    }

    private boolean dfs(int i, int j, char[][] grid) {
        if (0 <= i && i < grid.length && 0 <= j && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(i - 1, j, grid);
            dfs(i + 1, j, grid);
            dfs(i, j - 1, grid);
            dfs(i, j + 1, grid);
            return true;
        }
        return false;
    }
}
