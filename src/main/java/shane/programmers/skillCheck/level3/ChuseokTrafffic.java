package shane.programmers.skillCheck.level3;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class ChuseokTrafffic {

    @Test
    public void test() {
        assertThat(solution(new String[]{"2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"})).isEqualTo(7);
        assertThat(solution(new String[]{"2016-09-15 01:00:04.001 2.0s",
                "2016-09-15 01:00:07.000 2s"})).isEqualTo(1);
        assertThat(solution(new String[]{"2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"})).isEqualTo(2);
    }

    public int solution(String[] lines) {
        int max = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        List<Response> list = new ArrayList<>();

        for (String line : lines) {
            list.add(new Response(millisecond(line), duration(line)));
        }
        Collections.sort(list);

        for (Response response : list) {
            pq.offer(response.response + 999);
            while (!pq.isEmpty() && pq.peek() < response.start) {
                pq.poll();
            }
            max = Math.max(max, pq.size());
        }
        return max;
    }

    class Response implements Comparable {
        long start;
        long response;

        public Response(long millisecond, int duration) {
            this.start = millisecond - duration + 1;
            this.response = millisecond;
        }

        @Override
        public int compareTo(Object o) {
            return Long.compare(start, ((Response) o).start);
        }

        @Override
        public String toString() {
            return "Response{" +
                    "start=" + start +
                    ", response=" + response +
                    '}';
        }
    }

    private int duration(String line) {
        double duration = Double.parseDouble(line.substring(24, line.length() - 1)) * 1000;
        return (int) duration;
    }

    private long millisecond(String line) {
        int hour = Integer.parseInt(line.substring(11, 13));
        int min = Integer.parseInt(line.substring(14, 16));
        long sec = Integer.parseInt(line.substring(17, 19));
        long millisecond = Integer.parseInt(line.substring(20, 23));
        min = hour * 60 + min;
        sec = min * 60 + sec;
        millisecond = sec * 1000 + millisecond;
        return millisecond;
    }
}
