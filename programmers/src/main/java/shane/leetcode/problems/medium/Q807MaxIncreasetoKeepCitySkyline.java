package shane.leetcode.problems.medium;

import com.tistory.shanepark.STool;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q807MaxIncreasetoKeepCitySkyline {

    @Test
    void test() {
        Assertions.assertThat(maxIncreaseKeepingSkyline(STool.convertToIntArray("[[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]"))).isEqualTo(35);
        Assertions.assertThat(maxIncreaseKeepingSkyline(STool.convertToIntArray("[[0,0,0],[0,0,0],[0,0,0]]"))).isEqualTo(0);
    }

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] maxX = new int[grid.length];
        int[] maxY = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                maxX[j] = Math.max(maxX[j], grid[i][j]);
                maxY[i] = Math.max(maxY[i], grid[i][j]);
            }
        }

        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                cnt += (Math.min(maxX[j], maxY[i]) - grid[i][j]);
            }
        }

        return cnt;

    }
}
