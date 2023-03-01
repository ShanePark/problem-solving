package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 5 ms, faster than 15.04% of Java online submissions for Projection Area of 3D Shapes.
 * Memory Usage: 45.8 MB, less than 7.52% of Java online submissions for Projection Area of 3D Shapes.
 */
public class Q883ProjectionAreaOf3DShapes {

    @Test
    public void test() {
        assertThat(projectionArea(Ps.intArray("[[1,2],[3,4]]"))).isEqualTo(17);
        assertThat(projectionArea(Ps.intArray("[[2]]"))).isEqualTo(5);
        assertThat(projectionArea(Ps.intArray("[[1,0],[0,2]]"))).isEqualTo(8);
    }

    public int projectionArea(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int sum = 0;
        for (int i = 0; i < height; i++) {
            sum += Arrays.stream(grid[i]).max().getAsInt();
        }
        for (int j = 0; j < width; j++) {
            int max = 0;
            for (int i = 0; i < height; i++) {
                max = Math.max(max, grid[i][j]);
                if (grid[i][j] > 0)
                    sum++;
            }
            sum += max;
        }
        return sum;
    }
}
