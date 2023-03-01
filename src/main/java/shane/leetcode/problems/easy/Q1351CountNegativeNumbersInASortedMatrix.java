package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1351CountNegativeNumbersInASortedMatrix {

    @Test
    public void test() {
        assertThat(countNegatives(Ps.intArray("[[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]"))).isEqualTo(8);
        assertThat(countNegatives(Ps.intArray("[[3,2],[1,0]]"))).isEqualTo(0);
    }

    public int countNegatives(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int left = width;
        int cnt = 0;
        for (int i = 0; i < height; i++) {
            if (grid[i][0] < 0) {
                return cnt + width * (height - i);
            }
            for (int j = 0; j < width; j++) {
                if (left == j) {
                    cnt += width - j;
                    break;
                }
                if (grid[i][j] < 0) {
                    cnt++;
                    left = j;
                }
            }
        }
        return cnt;
    }
}
