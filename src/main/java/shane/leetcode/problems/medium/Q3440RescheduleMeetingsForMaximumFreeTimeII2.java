package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 4ms
 * Beats78.21%
 */
public class Q3440RescheduleMeetingsForMaximumFreeTimeII2 {

    @Test
    public void test() {
        assertThat(maxFreeTime(5, new int[]{1, 3}, new int[]{2, 5})).isEqualTo(2);
        assertThat(maxFreeTime(10, new int[]{0, 7, 9}, new int[]{1, 8, 10})).isEqualTo(7);
        assertThat(maxFreeTime(10, new int[]{0, 3, 7, 9}, new int[]{1, 4, 8, 10})).isEqualTo(6);
        assertThat(maxFreeTime(5, new int[]{0, 1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5})).isEqualTo(0);
    }

    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int maxGap = 0;
        final int LENGTH = startTime.length;
        int answer = 0;
        // l->r
        for (int i = 0; i < LENGTH; i++) {
            int leftGap = (i == 0) ? startTime[i] : (startTime[i] - endTime[i - 1]);
            int meeting = endTime[i] - startTime[i];
            int right = (i == LENGTH - 1) ? eventTime : startTime[i + 1];
            int left = i == 0 ? 0 : endTime[i - 1];
            int free = right - left - (maxGap < meeting ? meeting : 0);
            maxGap = Math.max(maxGap, leftGap);
            answer = Math.max(answer, free);
        }

        maxGap = 0;
        // r->l
        for (int i = LENGTH - 1; i >= 0; i--) {
            int rightGap = (i == LENGTH - 1) ? (eventTime - endTime[i]) : (startTime[i + 1] - endTime[i]);
            int meeting = endTime[i] - startTime[i];
            int right = (i == LENGTH - 1) ? eventTime : startTime[i + 1];
            int left = i == 0 ? 0 : endTime[i - 1];
            int free = right - left - (maxGap < meeting ? meeting : 0);
            maxGap = Math.max(maxGap, rightGap);
            answer = Math.max(answer, free);
        }
        return answer;
    }

}
