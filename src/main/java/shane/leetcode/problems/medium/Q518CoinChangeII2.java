package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q518CoinChangeII2 {

    @Test
    @SuppressWarnings("DuplicatedCode")
    public void test() {
        assertThat(change(5, new int[]{1, 2, 5})).isEqualTo(4);
        assertThat(change(0, new int[]{7})).isEqualTo(1);
        assertThat(change(3, new int[]{2})).isEqualTo(0);
        assertThat(change(10, new int[]{10})).isEqualTo(1);
    }

    @Test
    public void tle() {
        assertThat(change(500, new int[]{3, 5, 7, 8, 9, 10, 11})).isEqualTo(35502874);
    }

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 0; i + coin <= amount; i++) {
                dp[i + coin] += dp[i];
            }
        }

        return dp[amount];
    }

}
