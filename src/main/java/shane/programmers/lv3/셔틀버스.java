package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class 셔틀버스 {

    @Test
    public void test() {
        assertThat(solution(10, 60, 45, new String[]{"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}))
                .isEqualTo("18:00");
        assertThat(solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"})).isEqualTo("09:09");
        assertThat(solution(1, 1, 1, new String[]{"23:59"})).isEqualTo("09:00");
        assertThat(solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"})).isEqualTo("09:00");
        assertThat(solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"})).isEqualTo("08:59");
        assertThat(solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"})).isEqualTo("00:00");
    }

    public String solution(int n, int t, int m, String[] timetable) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (String s : timetable) {
            pq.offer(toMinute(s));
        }

        int time = 9 * 60;
        int last = -1;
        boolean lastBusHasSeat = false;
        for (int i = 0; i < n; i++) {
            lastBusHasSeat = false;
            for (int j = 0; j < m; j++) {
                if (!pq.isEmpty() && pq.peek() <= time) {
                    Integer poll = pq.poll();
                    last = poll;
                } else {
                    lastBusHasSeat = true;
                }
            }
            time += t;
        }

        if (lastBusHasSeat) {
            return minToStr(9 * 60 + (n - 1) * t);
        }

        return minToStr(last - 1);
    }

    private String minToStr(int time) {
        int hour = time / 60;
        int min = time % 60;
        return String.format("%02d:%02d", hour, min);
    }

    private Integer toMinute(String s) {
        int hour = (s.charAt(0) - '0') * 10 + s.charAt(1) - '0';
        int min = (s.charAt(3) - '0') * 10 + s.charAt(4) - '0';
        return 60 * hour + min;
    }
}
