package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 15
 * ms
 * Beats
 * 88.00%
 */
public class Q3433CountMentionsPerUser {

    @Test
    public void test() {
        assertThat(countMentions(2, List.of(
                List.of("MESSAGE", "10", "id1 id0"),
                List.of("OFFLINE", "11", "0"),
                List.of("MESSAGE", "71", "HERE")
        ))).isEqualTo(new int[]{2, 2});

        assertThat(countMentions(2, List.of(
                List.of("MESSAGE", "10", "id1 id0"),
                List.of("OFFLINE", "11", "0"),
                List.of("MESSAGE", "12", "ALL")
        ))).isEqualTo(new int[]{2, 2});

        assertThat(countMentions(2, List.of(
                List.of("OFFLINE", "10", "0"),
                List.of("MESSAGE", "12", "HERE")
        ))).isEqualTo(new int[]{0, 1});
    }

    @Test
    public void test2() {
        assertThat(countMentions(50, Ps.strList("[[\"OFFLINE\",\"825\",\"24\"],[\"OFFLINE\",\"189\",\"49\"],[\"OFFLINE\",\"47\",\"45\"],[\"MESSAGE\",\"733\",\"id29 id21 id20 id0 id34 id2 id15 id43 id14 id24 id35 id6 id8 id27 id5 id18 id11 id8 id11 id39 id41 id13 id20 id21 id39 id14 id6 id45 id23 id36 id37 id35 id10 id19 id12\"],[\"MESSAGE\",\"282\",\"HERE\"],[\"MESSAGE\",\"677\",\"HERE\"],[\"OFFLINE\",\"460\",\"8\"],[\"MESSAGE\",\"461\",\"HERE\"],[\"MESSAGE\",\"815\",\"id5 id8 id39 id39 id43 id3 id0 id31 id48 id45 id40 id12 id3 id25 id29 id14 id36 id18 id12 id2 id30\"],[\"OFFLINE\",\"90\",\"48\"],[\"OFFLINE\",\"602\",\"10\"],[\"MESSAGE\",\"107\",\"ALL\"],[\"OFFLINE\",\"39\",\"44\"],[\"MESSAGE\",\"834\",\"HERE\"],[\"MESSAGE\",\"104\",\"id41 id38 id11 id17 id37 id41 id17 id44 id30 id43 id8 id48 id22 id25 id24 id12\"],[\"OFFLINE\",\"173\",\"5\"],[\"OFFLINE\",\"377\",\"15\"],[\"OFFLINE\",\"646\",\"29\"],[\"OFFLINE\",\"676\",\"28\"],[\"OFFLINE\",\"888\",\"30\"],[\"MESSAGE\",\"950\",\"ALL\"],[\"MESSAGE\",\"201\",\"ALL\"],[\"OFFLINE\",\"957\",\"34\"],[\"MESSAGE\",\"475\",\"id24 id13 id33 id49 id28 id3 id44 id7 id5 id17 id45 id7 id38 id3 id33 id27 id24 id48 id1 id6 id19 id36 id34 id42 id29 id28 id30 id9 id46 id9 id27 id26 id31\"],[\"MESSAGE\",\"915\",\"id46 id20 id3 id0 id39 id44 id0 id4 id2 id13 id20 id43 id39 id0 id40 id42 id43 id19 id3 id16 id35 id33 id4 id38 id20 id12 id13 id21 id5 id45 id19 id16 id7 id30\"],[\"OFFLINE\",\"71\",\"41\"],[\"OFFLINE\",\"819\",\"23\"],[\"MESSAGE\",\"613\",\"ALL\"],[\"MESSAGE\",\"960\",\"HERE\"],[\"MESSAGE\",\"877\",\"ALL\"],[\"MESSAGE\",\"860\",\"HERE\"],[\"OFFLINE\",\"759\",\"23\"],[\"OFFLINE\",\"558\",\"13\"],[\"MESSAGE\",\"789\",\"ALL\"],[\"OFFLINE\",\"362\",\"26\"],[\"MESSAGE\",\"642\",\"ALL\"],[\"OFFLINE\",\"152\",\"19\"],[\"OFFLINE\",\"560\",\"19\"],[\"MESSAGE\",\"742\",\"HERE\"],[\"OFFLINE\",\"83\",\"12\"],[\"OFFLINE\",\"485\",\"22\"],[\"MESSAGE\",\"504\",\"ALL\"],[\"MESSAGE\",\"669\",\"id33 id0 id2 id34 id6 id34 id41 id0 id18 id37 id5 id45 id30 id22 id46 id42 id16\"],[\"MESSAGE\",\"53\",\"id38 id13 id0 id49 id29 id21 id39 id48 id14 id46 id30 id22 id40 id33 id32 id4 id49 id24 id33 id42 id0 id48 id37 id11 id11 id45 id44 id19 id35 id49 id11 id23 id43 id44 id22 id45 id14\"],[\"OFFLINE\",\"91\",\"10\"],[\"MESSAGE\",\"567\",\"HERE\"],[\"OFFLINE\",\"425\",\"27\"],[\"OFFLINE\",\"166\",\"2\"],[\"MESSAGE\",\"926\",\"ALL\"],[\"OFFLINE\",\"535\",\"17\"]]")))
                .isEqualTo(new int[]{26, 18, 21, 23, 20, 22, 21, 20, 20, 19, 18, 23, 22, 21, 22, 18, 20, 19, 20, 21, 22, 21, 21, 17, 20, 19, 18, 19, 18, 20, 23, 19, 18, 23, 20, 21, 20, 21, 21, 24, 20, 21, 21, 23, 22, 24, 21, 17, 22, 21});
    }

    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        PriorityQueue<Event> pq = new PriorityQueue<>();
        for (List<String> event : events) {
            pq.offer(new Event(event));
        }
        int[] answer = new int[numberOfUsers];
        int[] offlineUntil = new int[numberOfUsers];
        while (!pq.isEmpty()) {
            Event event = pq.poll();
            int time = event.time;
            switch (event.type) {
                case OFFLINE:
                    offlineUntil[Integer.parseInt(event.data)] = time + 60;
                    break;
                case MESSAGE:
                    String data = event.data;
                    if ("HERE".equals(data)) {
                        for (int i = 0; i < numberOfUsers; i++) {
                            if (time < offlineUntil[i]) {
                                continue;
                            }
                            answer[i]++;
                        }
                        break;
                    }
                    if ("ALL".equals(data)) {
                        for (int i = 0; i < numberOfUsers; i++) {
                            answer[i]++;
                        }
                        break;
                    }
                    String[] ids = data.split(" ");
                    for (String s : ids) {
                        int userId = Integer.parseInt(s.substring(2));
                        answer[userId]++;
                    }
                    break;
            }
        }
        return answer;
    }

    static class Event implements Comparable<Event> {
        final int time;
        final EventType type;
        final String data;

        @Override
        public String toString() {
            return "Event{" +
                    "time=" + time +
                    ", type=" + type +
                    ", data='" + data + '\'' +
                    '}';
        }

        public Event(List<String> event) {
            this.time = Integer.parseInt(event.get(1));
            this.data = event.get(2);
            if ("MESSAGE".equals(event.get(0))) {
                this.type = EventType.MESSAGE;
            } else {
                this.type = EventType.OFFLINE;
            }
        }

        @Override
        public int compareTo(Event o2) {
            if (this.time != o2.time) {
                return Integer.compare(this.time, o2.time);
            }
            if (this.type == EventType.MESSAGE && o2.type != EventType.MESSAGE) {
                return 1;
            }
            if (this.type != EventType.MESSAGE && o2.type == EventType.MESSAGE) {
                return -1;
            }
            return 0;

        }
    }

    enum EventType {OFFLINE, MESSAGE}

}
