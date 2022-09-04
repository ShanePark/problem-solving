package shane.leetcode.contest.weekly.w309;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2 {

    @Test
    public void test() {
        assertThat(numberOfWays(0, 5, 3)).isEqualTo(0);
        assertThat(numberOfWays(0, 5, 5)).isEqualTo(1);
        assertThat(numberOfWays(989, 1000, 99)).isEqualTo(934081896);
        assertThat(numberOfWays(88, 81, 7)).isEqualTo(1);
        assertThat(numberOfWays(1, 1000, 999)).isEqualTo(1);
        assertThat(numberOfWays(1, 2, 3)).isEqualTo(3);
        assertThat(numberOfWays(2, 5, 10)).isEqualTo(0);
    }

    public int numberOfWays(int startPos, int endPos, int k) {
        if (Math.abs(startPos - endPos) > k) {
            return 0;
        }
        int[][] moves = new int[k + 1][k * 2 + 2];
        final int MOD = (int) 1e9 + 7;
        moves[0][k] = 1;
        for (int i = 1; i <= k; i++) {
            moves[i][0] = moves[i - 1][1];
            for (int j = 1; j <= k * 2; j++) {
                moves[i][j] = (int) (((long) moves[i - 1][j - 1] + moves[i - 1][j + 1]) % MOD);
            }
        }
        return moves[k][k + endPos - startPos];
    }

}
