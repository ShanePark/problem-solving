package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PuzzleGameChallenge {

    @Test
    public void test() {
        assertThat(solution(new int[]{1, 328, 467, 209, 54}, new int[]{2, 7, 1, 4, 3}, 1723)).isEqualTo(294);
        assertThat(solution(new int[]{1, 5, 3}, new int[]{2, 4, 7}, 30)).isEqualTo(3);
        assertThat(solution(new int[]{1, 4, 4, 2}, new int[]{6, 3, 8, 2}, 59)).isEqualTo(2);
        assertThat(solution(new int[]{1, 99999, 100000, 99995}, new int[]{9999, 9001, 9999, 9001}, 3456789012L)).isEqualTo(39354);
        assertThat(solution(new int[]{1}, new int[]{1}, 100)).isEqualTo(1);
    }

    public int solution(int[] diffs, int[] times, long limit) {
        int left = 1;
        int right = 0;
        for (int diff : diffs) {
            right = Math.max(right, diff);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (possible(diffs, times, limit, mid)) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }

        return left;
    }

    private boolean possible(int[] diffs, int[] times, long limit, int level) {
        limit -= times[0];
        for (int i = 1; i < times.length; i++) {
            int levelDiff = Math.max(diffs[i] - level, 0);
            limit -= ((long) levelDiff * (times[i] + times[i - 1]) + times[i]);
            if (limit < 0){
                return false;
            }
        }
        return 0 <= limit;
    }

}
