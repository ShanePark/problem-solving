package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2147NumberOfWaysToDivideALongCorridor2 {

    @Test
    public void test() {
        assertThat(numberOfWays("SSPPSPS")).isEqualTo(3);
        assertThat(numberOfWays("PPSPSP")).isEqualTo(1);
        assertThat(numberOfWays("S")).isEqualTo(0);
    }

    @Test
    public void tle() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 50000; i++) {
            sb.append("S");
            sb.append("B");
        }
        assertThat(numberOfWays(sb.toString())).isEqualTo(370937954);
    }

    int MOD = (int) 1e9 + 7;

    public int numberOfWays(String corridor) {
        int cnt0 = 1;
        int cnt1 = 0;
        int cnt2 = 0;
        for (char c : corridor.toCharArray()) {
            cnt0 = (cnt0 + cnt2) % MOD;
            if (c == 'S') {
                cnt2 = cnt1;
                cnt1 = cnt0;
                cnt0 = 0;
            }
        }
        return cnt2;
    }

}
