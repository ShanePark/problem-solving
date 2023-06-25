package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 59 ms Beats 92%
 * Memory 43.2 MB Beats 40%
 */
public class Q1575CountAllPossibleRoutes {

    @Test
    void test() {
        assertThat(countRoutes(new int[]{2, 3, 6, 8, 4}, 1, 3, 5)).isEqualTo(4);
        assertThat(countRoutes(new int[]{4, 3, 1}, 1, 0, 6)).isEqualTo(5);
        assertThat(countRoutes(new int[]{5, 2, 1}, 0, 2, 3)).isEqualTo(0);
    }

    final int MOD = (int) 1e9 + 7;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int length = locations.length;
        Integer[][] dp = new Integer[length][201];
        return dfs(dp, locations, start, finish, fuel);
    }

    private int dfs(Integer[][] dp, int[] locations, int cur, int finish, int fuel) {
        if (dp[cur][fuel] == null) {
            long sum = 0;
            if (cur == finish)
                sum++;
            for (int i = 0; i < locations.length; i++) {
                if (i == cur)
                    continue;
                int next = locations[i];
                int distance = Math.abs(next - locations[cur]);
                if (fuel < distance)
                    continue;
                sum += dfs(dp, locations, i, finish, fuel - distance);
            }
            dp[cur][fuel] = (int) (sum % MOD);
        }
        return dp[cur][fuel];
    }

}
