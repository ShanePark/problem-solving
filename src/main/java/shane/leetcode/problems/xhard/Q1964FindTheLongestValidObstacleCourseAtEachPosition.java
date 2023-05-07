package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1964FindTheLongestValidObstacleCourseAtEachPosition {

    @Test
    void test() {
        assertThat(longestObstacleCourseAtEachPosition(new int[]{5, 2, 1, 3, 3, 5, 2, 1, 1, 2})).isEqualTo(new int[]{1, 1, 1, 2, 3, 4, 2, 2, 3, 4});
        assertThat(longestObstacleCourseAtEachPosition(new int[]{5, 3, 4, 4, 4, 2, 1, 1, 4, 1})).isEqualTo(new int[]{1, 1, 2, 3, 4, 1, 1, 2, 5, 3});
        assertThat(longestObstacleCourseAtEachPosition(new int[]{1, 2, 3, 2})).isEqualTo(new int[]{1, 2, 3, 3});
        assertThat(longestObstacleCourseAtEachPosition(new int[]{2, 2, 1})).isEqualTo(new int[]{1, 2, 1});
        assertThat(longestObstacleCourseAtEachPosition(new int[]{3, 1, 5, 6, 4, 2})).isEqualTo(new int[]{1, 1, 2, 3, 2, 2});
    }

    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] answer = new int[obstacles.length];
        for (int i = 0; i < obstacles.length; i++) {
            answer[i] = cnt(obstacles, i - 1, obstacles[i]) + 1;
        }
        return answer;
    }

    private int cnt(int[] obstacles, int until, int min) {
        if (until < 0) {
            return 0;
        }
        if (until == 0) {
            return obstacles[0] <= min ? 1 : 0;
        }

        int cnt = cnt(obstacles, until - 1, min);
        if (obstacles[until] <= min) {
            int nextMin = Math.min(obstacles[until], min);
            cnt = Math.max(cnt, cnt(obstacles, until - 1, nextMin) + 1);
        }

        return cnt;
    }

}
