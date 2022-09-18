package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Faster, but still TLE
 */
public class 기지국설치3 {

    @Test
    public void test() {
        assertThat(solution(11, new int[]{4, 11}, 1)).isEqualTo(3);
        assertThat(solution(16, new int[]{3}, 2)).isEqualTo(3);
        assertThat(solution(16, new int[]{9}, 2)).isEqualTo(3);
    }

    /**
     * 29 ms
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
        int index = 0;
        int closestStation = stations[index];
        int stationsLength = stations.length;

        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if (i + w < closestStation) {
                closestStation = i + w;
                cnt++;
                i += w * 2 - 1;
            } else if (i - w == closestStation) {
                if (index < stationsLength - 1 && stations[index] == closestStation) {
                    closestStation = stations[++index];
                } else if (closestStation < stations[index]) {
                    closestStation = stations[index];
                } else {
                    closestStation = Integer.MAX_VALUE;
                }
            }
        }
        return cnt;
    }
}
