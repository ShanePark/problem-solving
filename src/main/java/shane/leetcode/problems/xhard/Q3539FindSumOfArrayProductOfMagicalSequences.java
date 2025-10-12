package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q3539FindSumOfArrayProductOfMagicalSequences {

    @Test
    public void test() {
        assertThat(magicalSum(5, 5, new int[]{1, 10, 100, 10000, 1000000})).isEqualTo(991600007);
        assertThat(magicalSum(2, 2, new int[]{5, 4, 3, 2, 1})).isEqualTo(170);
    }

    @Test
    public void test2() {
        assertThat(magicalSum(3, 2, new int[]{33})).isEqualTo(35937);
    }

    @Test
    public void TLE() {
        assertThat(magicalSum(8, 8, new int[]{4475, 37658, 51018, 12424, 65157, 27914, 31161, 25310, 97672, 53516, 26018, 1860, 47220, 27702, 77234, 6951, 22039, 9184, 64449, 45837, 58613, 53764, 24216, 73423, 68676, 15003})).isEqualTo(369456900);
    }

    private final int MOD = (int) 1e9 + 7;
    private final int MAX = 31;
    private final long[] FACT = new long[MAX];
    private final long[] INV_FACT = new long[MAX];

    public int magicalSum(int m, int k, int[] nums) {
        FACT[0] = 1;
        for (int i = 1; i < MAX; i++) FACT[i] = FACT[i - 1] * i % MOD;
        long x = FACT[MAX - 1];
        int n = MOD - 2;
        long res = 1;
        for (; n > 0; n >>= 1, x = x * x % MOD)
            if ((n & 1) == 1) res = res * x % MOD;
        INV_FACT[MAX - 1] = res;
        for (int i = MAX - 1; i > 0; i--) INV_FACT[i - 1] = INV_FACT[i] * i % MOD;

        int LENGTH = nums.length;
        int[][] pows = new int[LENGTH][m + 1];
        for (int i = 0; i < LENGTH; i++) {
            pows[i][0] = 1;
            for (int j = 1; j <= m; j++)
                pows[i][j] = (int) ((long) pows[i][j - 1] * nums[i] % MOD);
        }

        int[][][][] memo = new int[LENGTH][m + 1][m / 2 + 1][k + 1];
        for (int[][][] a : memo)
            for (int[][] b : a)
                for (int[] c : b)
                    Arrays.fill(c, -1);

        return (int) (dfs(0, m, 0, k, pows, memo) * FACT[m] % MOD);
    }

    private long dfs(int i, int mLeft, int carry, int kLeft, int[][] pows, int[][][][] memo) {
        int ones = Integer.bitCount(carry);
        if (ones + mLeft < kLeft) return 0;
        if (i == pows.length) return (mLeft == 0 && ones == kLeft) ? 1 : 0;
        if (memo[i][mLeft][carry][kLeft] != -1) return memo[i][mLeft][carry][kLeft];

        long res = 0;
        for (int j = 0; j <= mLeft; j++) {
            int bit = (carry + j) & 1;
            if (bit <= kLeft) {
                long r = dfs(i + 1, mLeft - j, (carry + j) >> 1, kLeft - bit, pows, memo);
                res = (res + r * pows[i][j] % MOD * INV_FACT[j]) % MOD;
            }
        }
        return memo[i][mLeft][carry][kLeft] = (int) res;
    }

}
