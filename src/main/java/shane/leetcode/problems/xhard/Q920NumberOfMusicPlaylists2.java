package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q920NumberOfMusicPlaylists2 {

    @Test
    public void test() {
        assertThat(numMusicPlaylists(2, 3, 1)).isEqualTo(2);
        assertThat(numMusicPlaylists(3, 3, 1)).isEqualTo(6);
        assertThat(numMusicPlaylists(2, 3, 0)).isEqualTo(6);
    }

    @Test
    public void tle() {
        assertThat(numMusicPlaylists(16, 16, 4)).isEqualTo(789741546);
    }

    final int MOD = (int) (1e9 + 7);

    public int numMusicPlaylists(int n, int goal, int k) {
        long[][] dp = new long[goal + 1][n + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= goal; i++) {
            for (int j = 1; j <= i; j++) {
                if (j > n)
                    continue;

                dp[i][j] = dp[i - 1][j - 1] * (n - j + 1) % MOD;
                if (j > k) {
                    dp[i][j] = (dp[i][j] + dp[i - 1][j] * (j - k)) % MOD;
                }
            }
        }

        return (int) dp[goal][n];
    }

}
