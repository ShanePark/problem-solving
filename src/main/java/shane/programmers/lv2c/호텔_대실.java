package shane.programmers.lv2c;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class 호텔_대실 {

    @Test
    public void test() {
        assertThat(solution(Ps.strArray("[[\"15:00\", \"17:00\"], [\"16:40\", \"18:20\"], [\"14:20\", \"15:20\"], [\"14:10\", \"19:20\"], [\"18:20\", \"21:20\"]]"))).isEqualTo(3);
        assertThat(solution(Ps.strArray("[[\"09:10\", \"10:10\"], [\"10:20\", \"12:20\"]]\t"))).isEqualTo(1);
        assertThat(solution(Ps.strArray("[[\"10:20\", \"12:30\"], [\"10:20\", \"12:30\"], [\"10:20\", \"12:30\"]]"))).isEqualTo(3);
    }

    public int solution(String[][] book_time) {
        PriorityQueue<Event> pq = new PriorityQueue<>((e1, e2) -> {
            if (e1.time == e2.time) {
                return e1.status == Status.IN ? 1 : -1;
            }
            return Integer.compare(e1.time, e2.time);
        });
        for (String[] arr : book_time) {
            String in = arr[0];
            String out = arr[1];
            int inTime = toTime(in);
            int outTime = toTime(out);
            pq.offer(Event.inEvent(inTime));
            pq.offer(Event.outEvent(outTime));
        }
        int rooms = 0;
        int max = 0;
        while (!pq.isEmpty()) {
            Event event = pq.poll();
            if (event.status == Status.IN) {
                rooms++;
            } else {
                rooms--;
            }
            max = Math.max(max, rooms);
        }
        return max;
    }

    private int toTime(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3, 5));
        return hour * 60 + min;
    }

    static class Event {
        int time;
        Status status;

        public Event(int time, Status status) {
            this.time = time;
            this.status = status;
        }

        static public Event inEvent(int time) {
            return new Event(time, Status.IN);
        }

        static public Event outEvent(int time) {
            return new Event(time + 10, Status.OUT);
        }
    }

    enum Status {
        IN, OUT
    }

}
