package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q518CoinChangeII {

    @Test
    public void test() {
        assertThat(change(0, new int[]{7})).isEqualTo(1);
        assertThat(change(5, new int[]{1, 2, 5})).isEqualTo(4);
        assertThat(change(3, new int[]{2})).isEqualTo(0);
        assertThat(change(10, new int[]{10})).isEqualTo(1);
    }

    @Test
    public void tle() {
        // 8 sec 465 ms
        assertThat(change(500, new int[]{3, 5, 7, 8, 9, 10, 11})).isEqualTo(35502874);
    }

    int answer = 0;

    public int change(int amount, int[] coins) {
        answer = 0;
        Arrays.sort(coins);
        dfs(amount, coins, 0);
        return answer;
    }

    private void dfs(int amount, int[] coins, int index) {
        if (amount == 0) {
            answer++;
            return;
        }

        if (index == coins.length)
            return;

        int coin = coins[index];
        dfs(amount, coins, index + 1);
        for (int i = 1; coin * i <= amount; i++) {
            int next = amount - coin * i;
            dfs(next, coins, index + 1);
        }
    }

}
