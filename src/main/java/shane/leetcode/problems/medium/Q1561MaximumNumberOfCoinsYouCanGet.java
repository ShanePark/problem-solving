package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1561MaximumNumberOfCoinsYouCanGet {

    @Test
    public void test() {
        assertThat(maxCoins(new int[]{2, 4, 1, 2, 7, 8})).isEqualTo(9);
        assertThat(maxCoins(new int[]{2, 4, 5})).isEqualTo(4);
        assertThat(maxCoins(new int[]{9, 8, 7, 6, 5, 1, 2, 3, 4})).isEqualTo(18);
    }

    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum = 0;
        for (int i = 0; i < piles.length / 3; i++) {
            sum += piles[piles.length - i * 2 - 2];
        }
        return sum;
    }
}
