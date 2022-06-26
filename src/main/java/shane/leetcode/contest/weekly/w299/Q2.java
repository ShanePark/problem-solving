package shane.leetcode.contest.weekly.w299;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2 {

    @Test
    public void test() {
        assertThat(countHousePlacements(1)).isEqualTo(4);
        assertThat(countHousePlacements(2)).isEqualTo(9);
        assertThat(countHousePlacements(3)).isEqualTo(25);
        assertThat(countHousePlacements(4)).isEqualTo(64);
        assertThat(countHousePlacements(5)).isEqualTo(169);
        assertThat(countHousePlacements(1000)).isEqualTo(500478595);
        assertThat(countHousePlacements(9468)).isEqualTo(452249287);
        assertThat(countHousePlacements(2423)).isEqualTo(499741264);
    }

    public int countHousePlacements(int n) {
        int mod = 1_000_000_007;
        long[][] arr = new long[10001][4];
        // 0 1 2 3 -> xx xo ox oo
        arr[1][0] = 1;
        arr[1][1] = 1;
        arr[1][2] = 1;
        arr[1][3] = 1;
        for (int i = 2; i <= n; i++) {
            arr[i][0] = arr[i - 1][0] + arr[i - 1][1] + arr[i - 1][2] + arr[i - 1][3];
            arr[i][1] = arr[i - 1][0] + arr[i - 1][2];
            arr[i][2] = arr[i - 1][0] + arr[i - 1][1];
            arr[i][3] = arr[i - 1][0];
            for (int j = 0; j < 4; j++) {
                arr[i][j] %= mod;
            }
        }
        return (int) (((arr[n][0] + arr[n][1] + arr[n][2] + arr[n][3])) % mod);
    }

}
