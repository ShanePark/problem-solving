package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 4ms
 * Beats97.41%
 */
public class Q2017GridGame2 {

    @Test
    public void test() {
        assertThat(gridGame(Ps.intArray("[[2,5,4],[1,5,1]]"))).isEqualTo(4);
        assertThat(gridGame(Ps.intArray("[[3,3,1],[8,5,2]]"))).isEqualTo(4);
    }

    @Test
    public void test2() {
        assertThat(gridGame(Ps.intArray("[" +
                "[20, 3,20,17, 2,12,15,17, 4,15]," +
                "[20,10,13,14,15, 5, 2, 3,14, 3]]"))).isEqualTo(63);
    }

    public long gridGame(int[][] grid) {
        int WIDTH = grid[0].length;
        long up = -grid[0][0];
        long down = 0;
        for (int i = 0; i < WIDTH; i++) {
            up += grid[0][i];
        }
        long min = up;
        for (int i = 1; i < WIDTH; i++) {
            down += grid[1][i - 1];
            up -= grid[0][i];
            long curMax = Math.max(up, down);
            min = Math.min(min, curMax);
        }
        return min;
    }

}
