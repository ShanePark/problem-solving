package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 2ms
 * Beats7.50%
 */
public class Q3021AliceAndBobPlayingFlowerGame {

    @Test
    public void test() {
        assertThat(flowerGame(3, 2)).isEqualTo(3);
        assertThat(flowerGame(1, 1)).isEqualTo(0);
    }

    @Test
    public void test2() {
        assertThat(flowerGame(4, 3)).isEqualTo(6);
    }

    public long flowerGame(int n, int m) {
        long answer = 0;
        for (int i = 1; i <= n; i++) {
            answer += (i % 2) == 0 ? (m + 1) / 2 : m / 2;
        }
        return answer;
    }

}
