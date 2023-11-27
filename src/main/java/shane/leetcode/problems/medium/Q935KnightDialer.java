package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 123ms Beats 22.28%of users with Java
 * Memory Details 44.46MB Beats 16.03%of users with Java
 */
public class Q935KnightDialer {

    @Test
    public void test() {
        assertThat(knightDialer(1)).isEqualTo(10);
        assertThat(knightDialer(2)).isEqualTo(20);
        assertThat(knightDialer(3131)).isEqualTo(136006598);
    }

    int MOD = (int) 1e9 + 7;

    public int knightDialer(int n) {
        int[][] dp = new int[n][10];
        Map<Integer, Set<Integer>> jump = new HashMap<>();
        jump.put(0, Set.of(4, 6));
        jump.put(1, Set.of(6, 8));
        jump.put(2, Set.of(7, 9));
        jump.put(3, Set.of(4, 8));
        jump.put(4, Set.of(0, 3, 9));
        jump.put(5, Set.of());
        jump.put(6, Set.of(0, 1, 7));
        jump.put(7, Set.of(2, 6));
        jump.put(8, Set.of(1, 3));
        jump.put(9, Set.of(2, 4));

        Arrays.fill(dp[0], 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int next : jump.get(j)) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][next]) % MOD;
                }
            }
        }

        int sum = 0;
        for (int i : dp[n - 1]) {
            sum = (sum + i) % MOD;
        }
        return sum;
    }

}
