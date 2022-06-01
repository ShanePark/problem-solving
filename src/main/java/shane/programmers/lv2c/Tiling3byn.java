package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Tiling3byn {

    public int solution(int n) {
        final int MOD = 1000000007;
        if (n == 2)
            return 3;

        long[] memo = new long[n + 1];
        memo[0] = 1;
        memo[2] = 3;

        for (int i = 4; i <= n; i += 2) {
            memo[i] = memo[i - 2] * 3;
            for (int j = i - 4; j >= 0; j -= 2) {
                memo[i] += memo[j] * 2;
            }
            memo[i] %= MOD;
        }
        return (int) memo[n];
    }

    @Test
    public void test() {
        assertThat(solution(2)).isEqualTo(3);
        assertThat(solution(4)).isEqualTo(11);
        assertThat(solution(6)).isEqualTo(41);
        assertThat(solution(9)).isEqualTo(0);
    }
}
