package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3 ms Beats 94.22% of users with Java
 */
public class Q1289MinimumFallingPathSumII {

    @Test
    public void test() {
        assertThat(minFallingPathSum(Ps.intArray("[[1,2,3],[4,5,6],[7,8,9]]"))).isEqualTo(13);
        assertThat(minFallingPathSum(Ps.intArray("[[7]]"))).isEqualTo(7);
    }

    public int minFallingPathSum(int[][] grid) {
        int HEIGHT = grid.length;
        int WIDTH = grid[0].length;
        for (int i = 1; i < HEIGHT; i++) {
            int smallestIndex = -1;
            int smallestValue = Integer.MAX_VALUE;
            int secondSmallestValue = Integer.MAX_VALUE;
            for (int j = 0; j < WIDTH; j++) {
                if (secondSmallestValue <= grid[i - 1][j])
                    continue;
                secondSmallestValue = grid[i - 1][j];
                if (secondSmallestValue < smallestValue) {
                    smallestIndex = j;
                    // swap
                    int tmp = smallestValue;
                    smallestValue = secondSmallestValue;
                    secondSmallestValue = tmp;
                }
            }
            for (int j = 0; j < WIDTH; j++) {
                grid[i][j] += smallestIndex == j ? secondSmallestValue : smallestValue;
            }
        }
        return Arrays.stream(grid[HEIGHT - 1]).min().getAsInt();
    }

}
