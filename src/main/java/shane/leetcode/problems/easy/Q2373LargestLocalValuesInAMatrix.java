package shane.leetcode.problems.easy;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 2 ms, faster than 100.00% of Java online submissions for Largest Local Values in a Matrix.
 * Memory Usage: 52 MB, less than 50.00% of Java online submissions for Largest Local Values in a Matrix.
 */
public class Q2373LargestLocalValuesInAMatrix {

    @Test
    public void test() {
        assertThat(largestLocal(STool.convertToIntArray("[[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]"))).isEqualTo(STool.convertToIntArray("[[9,9],[8,6]]"));
        assertThat(largestLocal(STool.convertToIntArray("[[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]"))).isEqualTo(STool.convertToIntArray("[[2,2,2],[2,2,2],[2,2,2]]"));
    }

    public int[][] largestLocal(int[][] grid) {
        int[][] answer = new int[grid.length - 2][grid.length - 2];
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid.length - 2; j++) {
                answer[i][j] = max(grid, i, j);
            }
        }
        return answer;
    }

    private int max(int[][] grid, int y, int x) {
        int max = 0;
        for (int i = y; i < y + 3; i++) {
            for (int j = x; j < x + 3; j++) {
                max = Math.max(max, grid[i][j]);
            }
        }
        return max;
    }
}
