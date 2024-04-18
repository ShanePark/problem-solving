package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 5 ms Beats 51.43% of users with Java
 */
public class Q463IslandPerimeter2 {

    @Test
    public void test() {
        assertThat(islandPerimeter(Ps.intArray("[[0,1,0,0],[1,1,1,0],[0,1,0,0],[1,1,0,0]]"))).isEqualTo(16);
        assertThat(islandPerimeter(Ps.intArray("[[1]]"))).isEqualTo(4);
        assertThat(islandPerimeter(Ps.intArray("[[1,0]]"))).isEqualTo(4);
    }

    public int islandPerimeter(int[][] grid) {
        int HEIGHT = grid.length;
        int WIDTH = grid[0].length;
        int answer = 0;
        int[][] DIRS = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                int cur = grid[i][j];
                if (cur == 0)
                    continue;
                for (int[] dir : DIRS) {
                    int y = i + dir[0];
                    int x = j + dir[1];
                    if (x < 0 || y < 0 || x == WIDTH || y == HEIGHT || grid[y][x] == 0) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }

}
