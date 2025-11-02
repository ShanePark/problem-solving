package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2257CountUnguardedCellsintheGrid2 {

    @Test
    public void test() {
        assertThat(countUnguarded(4, 6, Ps.intArray("[[0,0],[1,1],[2,3]]"), Ps.intArray("[[0,1],[2,2],[1,4]]"))).isEqualTo(7);
        assertThat(countUnguarded(3, 3, Ps.intArray("[[1,1]]"), Ps.intArray("[[0,1],[1,0],[2,1],[1,2]]"))).isEqualTo(4);
    }

    final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int answer = m * n - guards.length - walls.length;
        char[][] grid = new char[m][n];
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 'w';
        }
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 'g';
        }

        for (int[] point : guards) {
            for (int[] dir : DIRS) {
                int x = point[0] + dir[0];
                int y = point[1] + dir[1];
                while (!(x < 0 || y < 0 || x >= m || y >= n || grid[x][y] == 'g' || 'w' == grid[x][y])) {
                    if (grid[x][y] != 'p')
                        answer--;
                    grid[x][y] = 'p';
                    x += dir[0];
                    y += dir[1];
                }
            }
        }
        return answer;
    }

}
