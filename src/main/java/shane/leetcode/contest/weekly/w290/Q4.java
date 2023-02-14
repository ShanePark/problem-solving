package shane.leetcode.contest.weekly.w290;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;


public class Q4 {

    @Test
    public void test() {
        assertThat(fullBloomFlowers(Ps.intArray("[[1,6],[3,7],[9,12],[4,13]]"), new int[]{2, 3, 7, 11})).containsExactly(1, 2, 2, 2);
        assertThat(fullBloomFlowers(Ps.intArray("[[1,10],[3,3]]"), new int[]{3, 3, 2})).containsExactly(2, 2, 1);
    }

    public int[] fullBloomFlowers2(int[][] flowers, int[] persons) {
        int n = flowers.length, Q = persons.length;
        int[][] es = new int[2*n+Q][];
        for(int i = 0;i < n;i++){
            es[i] = new int[]{flowers[i][0], 1};
            es[i+n] = new int[]{flowers[i][1]+1, -1};
        }
        for(int i = 0;i < Q;i++){
            es[i+2*n] = new int[]{persons[i], 0, i};
        }
        Arrays.sort(es, (x, y) -> {
            if (x[0] != y[0]) return x[0] - y[0];
            return x.length - y.length;
        });
        int h = 0;
        int[] ans = new int[Q];
        for(int[] e : es){
            if(e.length == 2){
                h += e[1];
            }else{
                ans[e[2]] = h;
            }
        }
        return ans;
    }

    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        PriorityQueue<Event> events = new PriorityQueue<>();
        for (int[] flower : flowers) {
            events.offer(new Event(flower[0], E.START));
            events.offer(new Event(flower[1], E.END));
        }
        Map<Integer, Integer> map = new HashMap<>();
        int cnt = 0;
        map.put(0, 0);
        while (!events.isEmpty()) {
            int next = cnt;
            Event poll = events.poll();
            int index = poll.index;
            if (poll.event == E.START) {
                cnt++;
                next++;
            } else {
                next--;
            }
            while (!events.isEmpty() && events.peek().index == index) {
                Event p = events.poll();
                if (p.event == E.START) {
                    cnt++;
                    next++;
                } else {
                    next--;
                }
            }
            map.put(index, cnt);
            cnt = next;
            map.put(index + 1, cnt);
        }

        int[] answer = new int[persons.length];
        List<Integer> l = map.keySet().stream().sorted().collect(Collectors.toList());
        int[] keys = new int[l.size()];
        for (int i = 0; i < keys.length; i++) {
            keys[i] = l.get(i);
        }
        for (int i = 0; i < persons.length; i++) {
            answer[i] = binarySearch(keys, map, persons[i]);
        }
        return answer;
    }

    private int binarySearch(int[] keys, Map<Integer, Integer> map, int person) {
        int left = 0;
        int right = keys.length;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (keys[mid] == person) {
                left = mid;
                right = mid;
            } else if (keys[mid] < person) {
                left = mid;
            } else {
                right = mid;
            }

        }
        return map.get(keys[left]);
    }

    class Event implements Comparable {
        int index;
        E event;

        public Event(int index, E event) {
            this.index = index;
            this.event = event;
        }

        @Override
        public int compareTo(Object o) {
            Event e = (Event) o;
            return Integer.compare(this.index, e.index);
        }

        @Override
        public String toString() {
            return "Event{" +
                    "index=" + index +
                    ", event=" + event +
                    '}';
        }
    }

    enum E {
        START, END
    }

}
