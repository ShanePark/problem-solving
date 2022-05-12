package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class 징검다리건너기 {

    @Test
    public void test() {
        assertThat(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3)).isEqualTo(3);
    }

    public int solution(int[] stones, int k) {

        int result = 0;
        while (canCross(stones, k)) {
            int min = 200000001;
            for (int i = 0; i < stones.length; i++) {
                min = stones[i] <= 0 ? min : Math.min(min, stones[i]);
            }
            for (int i = 0; i < stones.length; i++) {
                stones[i] -= min;
            }
            result += min;
        }

        return result;
    }

    private boolean canCross(int[] stones, int k) {
        int distance = 0;
        for (int i = 0; i < stones.length; i++) {
            if (stones[i] <= 0) {
                distance++;
                if (distance >= k)
                    return false;
            } else {
                distance = 0;
            }
        }
        return true;
    }
}
