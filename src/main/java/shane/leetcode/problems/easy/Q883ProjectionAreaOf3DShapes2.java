package shane.leetcode.problems.easy;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 2 ms, faster than 86.09% of Java online submissions for Projection Area of 3D Shapes.
 * Memory Usage: 44.8 MB, less than 32.33% of Java online submissions for Projection Area of 3D Shapes.
 */
public class Q883ProjectionAreaOf3DShapes2 {

    @Test
    public void test() {
        assertThat(projectionArea(Ps.intArray("[[1,2],[3,4]]"))).isEqualTo(17);
        assertThat(projectionArea(Ps.intArray("[[2]]"))).isEqualTo(5);
        assertThat(projectionArea(Ps.intArray("[[1,0],[0,2]]"))).isEqualTo(8);
    }

    public int projectionArea(int[][] grid) {
        int length = grid.length;
        int sum = 0;
        for (int j = 0; j < length; j++) {
            int max = 0;
            int max2 = 0;
            for (int i = 0; i < length; i++) {
                max = Math.max(max, grid[i][j]);
                max2 = Math.max(max2, grid[j][i]);
                if (grid[i][j] > 0)
                    sum++;
            }
            sum += max + max2;
        }
        return sum;
    }
}
