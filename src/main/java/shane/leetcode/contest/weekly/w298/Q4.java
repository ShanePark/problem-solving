package shane.leetcode.contest.weekly.w298;

import com.tistory.shanepark.STool;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q4 {

    @Test
    public void test() {
        assertThat(sellingWood(3, 5, STool.convertToIntArray("[[1,4,2],[2,2,7],[2,1,3]]"))).isEqualTo(19);
        assertThat(sellingWood(4, 6, STool.convertToIntArray("[[3,2,10],[1,4,2],[4,1,3]]"))).isEqualTo(32);
    }

    public long sellingWood(int m, int n, int[][] prices) {
        long[][] memo = new long[m + 1][n + 1];

        for (int[] price : prices)
            memo[price[0]][price[1]] = price[2];

        for (int width = 1; width <= m; width++) {
            for (int height = 1; height <= n; height++) {
                // cut vertical
                for (int i = 1; i <= width / 2; i++)
                    memo[width][height] = Math.max(memo[width][height], memo[i][height] + memo[width - i][height]);
                // cut horizontal
                for (int i = 1; i <= height / 2; i++)
                    memo[width][height] = Math.max(memo[width][height], memo[width][i] + memo[width][height - i]);
            }
        }
        return memo[m][n];
    }

}
