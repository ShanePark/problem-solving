package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q64MinimumPathSum {

    @Test
    public void test() {
        assertThat(minPathSum(Ps.intArray("[[5,4,2,9,6,0,3,5,1,4,9,8,4,9,7,5,1],[3,4,9,2,9,9,0,9,7,9,4,7,8,4,4,5,8],[6,1,8,9,8,0,3,7,0,9,8,7,4,9,2,0,1],[4,0,0,5,1,7,4,7,6,4,1,0,1,0,6,2,8],[7,2,0,2,9,3,4,7,0,8,9,5,9,0,1,1,0],[8,2,9,4,9,7,9,3,7,0,3,6,5,3,5,9,6],[8,9,9,2,6,1,2,5,8,3,7,0,4,9,8,8,8],[5,8,5,4,1,5,6,6,3,3,1,8,3,9,6,4,8],[0,2,2,3,0,2,6,7,2,3,7,3,1,5,8,1,3],[4,4,0,2,0,3,8,4,1,3,3,0,7,4,2,9,8],[5,9,0,4,7,5,7,6,0,8,3,0,0,6,6,6,8],[0,7,1,8,3,5,1,8,7,0,2,9,2,2,7,1,5],[1,0,0,0,6,2,0,0,2,2,8,0,9,7,0,8,0],[1,1,7,2,9,6,5,4,8,7,8,5,0,3,8,1,5],[8,9,7,8,1,1,3,0,1,2,9,4,0,1,5,3,1],[9,2,7,4,8,7,3,9,2,4,2,2,7,8,2,6,7],[3,8,1,6,0,4,8,9,8,0,2,5,3,5,5,7,5],[1,8,2,5,7,7,1,9,9,8,9,2,4,9,5,4,0],[3,4,4,1,5,3,3,8,8,6,3,5,3,8,7,1,3]]")))
                .isEqualTo(82);
        assertThat(minPathSum(Ps.intArray("[[1,3,1],[1,5,1],[4,2,1]]"))).isEqualTo(7);
        assertThat(minPathSum(Ps.intArray("[[1,2,3],[4,5,6]]"))).isEqualTo(12);
        assertThat(minPathSum(Ps.intArray("[[1,9,2],[4,5,6]]"))).isEqualTo(16);
    }

    public int minPathSum(int[][] grid) {
        int HEIGHT = grid.length;
        int WIDTH = grid[0].length;
        int[][] dp = new int[HEIGHT][WIDTH];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MAX_VALUE);
        }

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        dp[0][0] = grid[0][0];
        while (!q.isEmpty()) {
            int[] poll = q.poll();
            for (int[] dir : new int[][]{{1, 0}, {0, 1}}) {
                int y = poll[0] + dir[0];
                int x = poll[1] + dir[1];
                if (0 <= y && y < HEIGHT && 0 <= x && x < WIDTH && dp[poll[0]][poll[1]] + grid[y][x] < dp[y][x]) {
                    dp[y][x] = dp[poll[0]][poll[1]] + grid[y][x];
                    q.offer(new int[]{y, x});
                }
            }
        }
        return dp[HEIGHT - 1][WIDTH - 1];
    }

}
