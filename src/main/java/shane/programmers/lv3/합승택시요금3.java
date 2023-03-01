package shane.programmers.lv3;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@SuppressWarnings("ALL")
public class 합승택시요금3 {

    @Test
    public void test() {
        assertThat(solution(7, 3, 4, 1,
                Ps.intArray("[[5, 7, 9], [4, 6, 4], [3, 6, 1], [3, 2, 3], [2, 1, 6]]")))
                .isEqualTo(14);
        assertThat(solution(6, 4, 6, 2,
                Ps.intArray("[[4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]]")))
                .isEqualTo(82);

    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int[][] memo = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                memo[i][j] = Integer.MAX_VALUE / 3;
            }
        }
        for (int i = 1; i <= n; i++) {
            memo[i][i] = 0;
        }

        for (int[] fare : fares) {
            memo[fare[0]][fare[1]] = fare[2];
            memo[fare[1]][fare[0]] = fare[2];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= n; k++) {
                    if (memo[j][i] + memo[i][k] < memo[j][k])
                        memo[j][k] = memo[j][i] + memo[i][k];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            min = Math.min(min, memo[s][i] + memo[i][a] + memo[i][b]);
        }

        return min;
    }

}
