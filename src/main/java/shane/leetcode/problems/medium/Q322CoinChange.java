package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 82 ms, faster than 13.17% of Java online submissions for Coin Change.
 * Memory Usage: 64.8 MB, less than 8.94% of Java online submissions for Coin Change.
 */
public class Q322CoinChange {

    @Test
    public void test() {
        assertThat(coinChange(new int[]{1, 2}, 2)).isEqualTo(1);
        assertThat(coinChange(new int[]{4, 7}, 12)).isEqualTo(3);
        assertThat(coinChange(new int[]{1, 2, 100, 5}, 11)).isEqualTo(3);
        assertThat(coinChange(new int[]{1, 2, 5}, 11)).isEqualTo(3);
        assertThat(coinChange(new int[]{2}, 3)).isEqualTo(-1);
        assertThat(coinChange(new int[]{1}, 0)).isEqualTo(0);
    }

    public int coinChange(int[] C, int amount) {

        if (amount == 0)
            return 0;

        int[] coins = Arrays.stream(C).filter(c -> c <= amount).boxed().sorted(Comparator.reverseOrder()).mapToInt(Integer::valueOf).toArray();

        int[] memo = new int[10000];
        Arrays.fill(memo, -1);

        Queue<Integer> q = new LinkedList<>();
        for (int coin : coins) {
            if (coin == amount)
                return 1;

            q.offer(coin);
            memo[coin] = 1;
        }

        int count = 2;

        while (!q.isEmpty()) {
            Queue<Integer> temp = new LinkedList<>();
            while (!q.isEmpty()) {
                Integer poll = q.poll();
                for (int coin : coins) {
                    int price = poll + coin;
                    if (price == amount) {
                        return count;
                    } else if (price < amount && memo[price] == -1) {
                        memo[price] = memo[poll] + 1;
                        temp.offer(price);
                    }
                }
            }
            count++;
            q = temp;
        }

        return memo[amount];
    }
}
