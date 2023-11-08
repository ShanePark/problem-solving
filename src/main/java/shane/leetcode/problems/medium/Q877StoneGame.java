package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 7ms Beats 37.34%of users with Java
 * Memory Details 45.30MB Beats 17.85%of users with Java
 */
public class Q877StoneGame {

    @Test
    public void test() {
        assertThat(stoneGame(new int[]{5, 3, 4, 5})).isTrue();
        assertThat(stoneGame(new int[]{3, 7, 2, 3})).isTrue();
    }

    public boolean stoneGame(int[] piles) {
        int[][] dp = new int[piles.length][piles.length];
        int[] accumSum = new int[piles.length + 1];
        int sum = 0;
        for (int i = 0; i < piles.length; i++) {
            dp[i][i] = piles[i];
            sum += piles[i];
            accumSum[i + 1] = sum;
        }
        return max(0, piles.length - 1, dp, accumSum) >= sum / 2;
    }

    private int max(int i, int j, int[][] dp, int[] accumSum) {
        int sumRange = accumSum[j + 1] - accumSum[i];
        if (dp[i][j] > 0)
            return dp[i][j];
        int whenTakeLeftEnemyHas = max(i + 1, j, dp, accumSum);
        int whenTakeRightEnemyHas = max(i, j - 1, dp, accumSum);
        int minEnemy = Math.min(whenTakeLeftEnemyHas, whenTakeRightEnemyHas);
        return dp[i][j] = sumRange - minEnemy;
    }

}
