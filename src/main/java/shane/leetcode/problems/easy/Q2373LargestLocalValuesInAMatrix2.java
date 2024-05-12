package shane.leetcode.problems.easy;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 4 ms Beats 15.95% of users with Java
 */
public class Q2373LargestLocalValuesInAMatrix2 {

    @Test
    public void test() {
        assertThat(largestLocal(Ps.intArray("[[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]"))).isEqualTo(Ps.intArray("[[9,9],[8,6]]"));
        assertThat(largestLocal(Ps.intArray("[[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]"))).isEqualTo(Ps.intArray("[[2,2,2],[2,2,2],[2,2,2]]"));
    }

    public int[][] largestLocal(int[][] grid) {
        int[][] answer = new int[grid.length - 2][grid[0].length - 2];
        int[][] DIRS = new int[][]{
                {0, 0}, {0, 1}, {0, 2},
                {1, 0}, {1, 1}, {1, 2},
                {2, 0}, {2, 1}, {2, 2}
        };
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                int max = 0;
                for (int[] dir : DIRS) {
                    max = Math.max(max, grid[dir[0] + i][dir[1] + j]);
                }
                answer[i][j] = max;
            }
        }
        return answer;
    }

}
