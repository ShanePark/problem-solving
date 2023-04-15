package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 152 ms Beats 73.46%
 * Memory 44.9 MB Beats 72.22%
 */
public class Q2218MaximumValueOfKCoinsFromPiles {

    @Test
    void test() {
        assertThat(maxValueOfCoins(Ps.intList("[[1,100,3],[7,8,9]]"), 2)).isEqualTo(101);
        assertThat(maxValueOfCoins(Ps.intList("[[100],[100],[100],[100],[100],[100],[1,1,1,1,1,1,700]]"), 7)).isEqualTo(706);
    }

    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[][] dp = new int[piles.size()][k + 1];
        return dfs(piles, dp, 0, k);
    }

    private int dfs(List<List<Integer>> piles, int[][] dp, int i, int k) {
        if (k == 0 || i == piles.size())
            return 0;

        if (dp[i][k] != 0)
            return dp[i][k];

        List<Integer> list = piles.get(i);
        int max = dfs(piles, dp, i + 1, k);
        int sum = 0;
        for (int j = 0; j < k && j < list.size(); j++) {
            sum += list.get(j);
            max = Math.max(max, sum + dfs(piles, dp, i + 1, k - j - 1));
        }

        dp[i][k] = max;
        return dp[i][k];
    }

}
