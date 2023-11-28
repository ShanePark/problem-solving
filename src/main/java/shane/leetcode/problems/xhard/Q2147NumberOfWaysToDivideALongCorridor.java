package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE 194 / 248 testcases passed
 */
public class Q2147NumberOfWaysToDivideALongCorridor {

    @Test
    public void test() {
        assertThat(numberOfWays("SSPPSPS")).isEqualTo(3);
        assertThat(numberOfWays("PPSPSP")).isEqualTo(1);
        assertThat(numberOfWays("S")).isEqualTo(0);
    }

    int MOD = (int) 1e9 + 7;

    public int numberOfWays(String corridor) {
        char[] arr = corridor.toCharArray();
        Integer[] dp = new Integer[arr.length];
        calc(dp, arr, 0);
        return dp[0];
    }

    private int calc(Integer[] dp, char[] arr, int start) {
        if (start == arr.length)
            return 0;

        if (dp[start] != null)
            return dp[start];

        dp[start] = 0;
        int seatCnt = 0;
        for (int i = start; i < arr.length; i++) {
            if (arr[i] == 'S') {
                seatCnt++;
            }
            if (seatCnt == 2) {
                dp[start] = (dp[start] + calc(dp, arr, i + 1)) % MOD;
            }
        }
        if (seatCnt == 2)
            dp[start]++;
        return dp[start] % MOD;
    }

}
