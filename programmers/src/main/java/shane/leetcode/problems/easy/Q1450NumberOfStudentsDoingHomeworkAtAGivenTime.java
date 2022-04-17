package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1450NumberOfStudentsDoingHomeworkAtAGivenTime {

    @Test
    public void test() {
        assertThat(busyStudent(new int[]{1, 2, 3}, new int[]{3, 2, 7}, 4)).isEqualTo(1);
    }

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int cnt = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && queryTime <= endTime[i])
                cnt++;
        }
        return cnt;
    }
}
