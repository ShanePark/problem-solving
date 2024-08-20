package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1140StoneGameII3 {

    @Test
    public void test() {
        assertThat(stoneGameII(new int[]{2, 7, 9, 4, 4})).isEqualTo(10);
        assertThat(stoneGameII(new int[]{1, 2, 3, 4, 5, 100})).isEqualTo(104);
    }

    public int stoneGameII(int[] piles) {
        return gameBestScore(piles, 0, 1, new int[piles.length][piles.length + 1]);
    }

    private int gameBestScore(int[] piles, int index, int m, int[][] bestDP) {
        if (bestDP[index][m] > 0)
            return bestDP[index][m];

        int total = Arrays.stream(piles, index, piles.length).sum();

        if (piles.length <= index + 2 * m) {
            return total;
        }

        int bobMin = Integer.MAX_VALUE;
        for (int i = 1; i <= 2 * m && index + i < piles.length; i++) {
            int bob = gameBestScore(piles, index + i, Math.max(m, i), bestDP);
            bobMin = Math.min(bobMin, bob);
        }
        bestDP[index][m] = total - bobMin;
        return bestDP[index][m];
    }

}
