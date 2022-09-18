package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Finally Passed !
 */
@SuppressWarnings("ALL")
public class 기지국설치4 {

    @Test
    public void test() {
        assertThat(solution(16, new int[]{3}, 2)).isEqualTo(3);
        assertThat(solution(11, new int[]{4, 11}, 1)).isEqualTo(3);
        assertThat(solution(16, new int[]{9}, 2)).isEqualTo(3);
    }

    /**
     * 33 ms
     */
    @Test
    public void tle() {
        int[] stations = new int[10000];
        for (int i = 1; i <= 10000; i++) {
            stations[i - 1] = i;
        }
        assertThat(solution(200000000, stations, 1));
    }

    public int solution(int n, int[] stations, int w) {
        int left = 1;
        int cnt = 0;
        for (int station : stations) {
            int gap = station - w - left;
            if (gap > 0) {
                cnt += (gap - 1) / (w * 2 + 1) + 1;
            }
            left = station + w + 1;
        }
        if (left <= n) {
            int lastStation = stations[stations.length - 1];
            int gap = n - (lastStation + w);
            if (gap > 0) {
                cnt += (gap - 1) / (w * 2 + 1) + 1;
            }
        }
        return cnt;
    }
}
