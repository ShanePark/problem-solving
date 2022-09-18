package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class 기지국설치 {

    @Test
    public void test() {
        assertThat(solution(11, new int[]{4, 11}, 1)).isEqualTo(3);
        assertThat(solution(16, new int[]{9}, 2)).isEqualTo(3);
    }

    /**
     * 1 sec 22ms
     */
    @Test
    public void tle() {
        int[] arr = new int[10000];
        for (int i = 1; i <= 10000; i++) {
            arr[i - 1] = i;
        }
        assertThat(solution(200000000, arr, 100000));
    }

    public int solution(int n, int[] stations, int w) {
        int[] arr = new int[n];
        for (int station : stations) {
            for (int i = 0; i <= w; i++) {
                if (station - 1 + i < n) {
                    arr[station - 1 + i] = 1;
                }
                if (station - 1 - i >= 0) {
                    arr[station - 1 - i] = 1;
                }
            }
        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                cnt++;
                for (int j = 0; j < 2 * w + 1 && i < n; j++, i++) {
                    arr[i] = 1;
                }
                i--;
            }
        }
        return cnt;
    }
}

