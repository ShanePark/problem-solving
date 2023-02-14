package shane.leetcode.problems.xhard;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q980UniquePathsIII {

    @Test
    public void test() {
        assertThat(uniquePathsIII(Ps.intArray("[[1,0,0,0],[0,0,0,0],[0,0,2,-1]]"))).isEqualTo(2);
        assertThat(uniquePathsIII(Ps.intArray("[[1,0,0,0],[0,0,0,0],[0,0,0,2]]"))).isEqualTo(4);
        assertThat(uniquePathsIII(Ps.intArray("[[0,1],[2,0]]"))).isEqualTo(0);
    }

    int cnt;

    public int uniquePathsIII(int[][] grid) {
        cnt = 0;
        int countZero = 0;
        int currentY = -1;
        int currentX = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    countZero++;
                } else if (grid[i][j] == 1) {
                    currentX = j;
                    currentY = i;
                }
            }
        }

        dfs(grid, currentY, currentX, 0, countZero);

        return cnt;

    }

    private void dfs(int[][] grid, int y, int x, int passed, int countZero) {
        int currentPlace = grid[y][x];
        if (currentPlace == 2) {
            if (passed == countZero + 1)
                cnt++;
            return;
        }

        grid[y][x] = 1;

        // up
        if (y > 0 && grid[y - 1][x] % 2 == 0) {
            dfs(grid, y - 1, x, passed + 1, countZero);
        }

        // down
        if (y < grid.length - 1 && grid[y + 1][x] % 2 == 0) {
            dfs(grid, y + 1, x, passed + 1, countZero);
        }

        // left
        if (x > 0 && grid[y][x - 1] % 2 == 0) {
            dfs(grid, y, x - 1, passed + 1, countZero);
        }

        // right
        if (x < grid[0].length - 1 && grid[y][x + 1] % 2 == 0) {
            dfs(grid, y, x + 1, passed + 1, countZero);
        }

        grid[y][x] = 0;

    }

}
