package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1552MagneticForceBetweenTwoBalls2 {

    @Test
    public void test() {
        assertThat(maxDistance(new int[]{1, 2, 3, 4, 7}, 3)).isEqualTo(3);
        assertThat(maxDistance(new int[]{5, 4, 3, 2, 1, 1000000000}, 2)).isEqualTo(999999999);
    }

    @Test
    public void tle() {
        assertThat(maxDistance(new int[]{10, 91, 11, 85, 71, 42, 59, 69, 75, 24, 12, 14, 31, 8, 5, 22, 82, 51, 78, 6, 97, 72, 92, 88, 52, 84, 23, 61, 98, 30}, 26))
                .isEqualTo(1);
    }

    /**
     * 1 sec 26 ms
     */
    @Test
    public void tle2() {
        assertThat(maxDistance(new int[]{57, 77, 26, 60, 38, 92, 71, 53, 27, 99, 20, 4, 86, 67, 94, 40, 83, 21, 17, 100, 52, 59, 44, 66, 43, 82, 8, 96, 98, 31, 6, 29, 84, 11, 1, 79, 48, 87, 69, 91, 97, 93, 58, 61, 68, 89, 45, 24, 80, 72, 47, 42, 50, 33, 19, 81, 95, 16, 23, 73}, 17))
                .isEqualTo(5);

    }

    int answer = 0;

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        dfs(position, 0, m, -1, Integer.MAX_VALUE);
        return answer;
    }

    private void dfs(int[] position, int i, int m, int last, int min) {
        if (position.length == i)
            return;
        if (position.length - i + 1 == m)
            return;
        // skip
        dfs(position, i + 1, m, last, min);

        // put
        int cur = position[i];
        if (last >= 0) {
            int distance = Math.abs(cur - last);
            min = Math.min(min, distance);
            if (min <= answer) {
                return;
            }
        }
        m--;
        if (m == 0) {
            answer = Math.max(min, answer);
            return;
        }
        dfs(position, i + 1, m, cur, min);
    }

}
