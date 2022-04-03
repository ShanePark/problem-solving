package shane.leetcode.contest.weekly.w287;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2224MinimumNumberOfOperationsToConvertTime {

    @Test
    public void test() {
        assertThat(convertTime("02:30", "04:35")).isEqualTo(3);
        assertThat(convertTime("11:00", "11:01")).isEqualTo(1);
    }

    public int convertTime(String current, String correct) {
        int dif = convert(correct) - convert(current);
        int[] arr = new int[]{60, 15, 5, 1};
        int cnt = 0;
        for (int i = 0; i < arr.length && dif > 0; i++) {
            cnt += dif / arr[i];
            dif = dif % arr[i];
        }
        return cnt;
    }

    private int convert(String str) {
        int hour = Integer.parseInt(str.substring(0, 2));
        int minute = Integer.parseInt(str.substring(3, 5));
        return hour * 60 + minute;
    }
}
