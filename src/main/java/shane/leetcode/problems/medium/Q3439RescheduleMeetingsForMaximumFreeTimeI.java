package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3439RescheduleMeetingsForMaximumFreeTimeI {

    @Test
    public void test() {
        assertThat(maxFreeTime(5, 1, new int[]{1, 3}, new int[]{2, 5})).isEqualTo(2);
        assertThat(maxFreeTime(10, 1, new int[]{0, 2, 9}, new int[]{1, 4, 10})).isEqualTo(6);
        assertThat(maxFreeTime(5, 2, new int[]{0, 1, 2, 3, 4}, new int[]{1, 2, 3, 4, 5})).isEqualTo(0);
    }

    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int answer = 0;
        int meeting = 0;
        for (int i = 0; i < startTime.length; i++) {
            meeting += endTime[i] - startTime[i];
            int left = i <= k - 1 ? 0 : endTime[i - k];
            int right = i == startTime.length - 1 ? eventTime : startTime[i + 1];
            answer = Math.max(answer, right - left - meeting);
            if (i >= k - 1) {
                meeting -= endTime[i - k + 1] - startTime[i - k + 1];
            }
        }
        return answer;
    }

}
