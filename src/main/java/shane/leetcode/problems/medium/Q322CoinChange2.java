package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * untime: 21 ms, faster than 69.86% of Java online submissions for Coin Change.
 * Memory Usage: 45 MB, less than 57.32% of Java online submissions for Coin Change.
 */
public class Q322CoinChange2 {

    @Test
    public void test() {
        assertThat(coinChange(new int[]{1, 2}, 2)).isEqualTo(1);
        assertThat(coinChange(new int[]{4, 7}, 12)).isEqualTo(3);
        assertThat(coinChange(new int[]{1, 2, 100, 5}, 11)).isEqualTo(3);
        assertThat(coinChange(new int[]{1, 2, 5}, 11)).isEqualTo(3);
        assertThat(coinChange(new int[]{2}, 3)).isEqualTo(-1);
        assertThat(coinChange(new int[]{1}, 0)).isEqualTo(0);
    }

    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] memo = new int[amount + 1];

        int sum = 1;
        while (sum <= amount) {
            int min = -1;
            for (int coin : coins) {
                if (sum >= coin && memo[sum - coin] != -1) {
                    int cnt = memo[sum - coin] + 1;
                    if (min < 0 || cnt < min)
                        min = cnt;
                }
            }
            memo[sum] = min;
            sum++;
        }
        return memo[amount];
    }
}
