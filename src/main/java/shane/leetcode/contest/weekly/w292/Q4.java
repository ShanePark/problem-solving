package shane.leetcode.contest.weekly.w292;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q4 {

    @Test
    public void test() {
        assertThat(hasValidPath(Ps.charArray("[[\"(\",\"(\",\"(\",\"(\",\"(\"],[\"(\",\"(\",\")\",\")\",\")\"],[\")\",\"(\",\")\",\")\",\"(\"],[\"(\",\"(\",\")\",\")\",\")\"]]"))).isTrue();
        assertThat(hasValidPath(Ps.charArray("[[\"(\",\"(\",\"(\"],[\")\",\"(\",\")\"],[\"(\",\"(\",\")\"],[\"(\",\"(\",\")\"]]"))).isTrue();
        assertThat(hasValidPath(Ps.charArray("[[\"(\",\"(\"],[\"(\",\"(\"]]"))).isFalse();
        assertThat(hasValidPath(Ps.charArray("[[\")\",\")\"],[\"(\",\"(\"]]"))).isFalse();
    }

    boolean[][][] memo;

    public boolean hasValidPath(char[][] grid) {
        int HEIGHT = grid.length;
        int WIDTH = grid[0].length;
        if ((HEIGHT + WIDTH) % 2 == 0)
            return false;

        memo = new boolean[HEIGHT][WIDTH][(HEIGHT + WIDTH - 1) / 2 + 1];
        if (grid[0][0] != '(' || grid[HEIGHT - 1][WIDTH - 1] != ')')
            return false;
        return dfs(0, grid, 0, 0);
    }

    private boolean dfs(int count, char[][] grid, int i, int j) {
        if (memo[i][j][count])
            return false;

        if (grid[i][j] == '(') {
            count++;
        } else if (count == 0) {
            memo[i][j][count] = true;
            return false;
        } else {
            count--;
        }

        if (count > (grid.length + grid[0].length - i - j - 2)) {
            return false;
        }

        if (i == grid.length - 1 && j == grid[0].length - 1) {
            boolean result = (count == 0);
            if (result == false)
                memo[i][j][count] = true;
            return result;
        }

        boolean result = ((j < grid[0].length - 1) && dfs(count, grid, i, j + 1)) || (i < grid.length - 1 && dfs(count, grid, i + 1, j));
        if (result == false)
            memo[i][j][count] = true;
        return result;
    }
}
