package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
@SuppressWarnings("ALL")
public class 징검다리건너기3 {

    @Test
    public void test() {
        assertThat(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3)).isEqualTo(3);
    }

    public int solution(int[] stones, int k) {
        for (int i = 0; i <= stones.length - k; i++) {
            int max = 0;
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, stones[j]);
            }
            stones[i] = max;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= stones.length - k; i++) {
            min = Math.min(min, stones[i]);
        }
        return min;
    }

}
