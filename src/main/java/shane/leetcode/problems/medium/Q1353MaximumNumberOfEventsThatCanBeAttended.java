package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1353MaximumNumberOfEventsThatCanBeAttended {

    @Test
    public void test() {
        assertThat(maxEvents(Ps.intArray("[[1,2],[2,3],[3,4]]"))).isEqualTo(3);
        assertThat(maxEvents(Ps.intArray("[[1,2],[2,3],[3,4],[1,2]]"))).isEqualTo(4);
    }

    @Test
    public void test2() {
        assertThat(maxEvents(Ps.intArray("[[1,5],[1,5],[1,5],[2,3],[2,3]]"))).isEqualTo(5);
        assertThat(maxEvents(Ps.intArray("[[1,2],[1,2],[3,3],[1,5],[1,5]]"))).isEqualTo(5);
    }

    public int maxEvents(int[][] events) {
        Arrays.sort(events, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int answer = 0;
        for (int cur = events[0][0], i = 0; cur <= 100000 && (i < events.length || !pq.isEmpty()); cur++) {
            while (i < events.length && events[i][0] <= cur) {
                pq.offer(events[i][1]);
                i++;
            }
            while (!pq.isEmpty() && pq.peek() < cur) {
                pq.poll();
            }
            if (!pq.isEmpty()) {
                pq.poll();
                answer++;
            }
        }
        return answer;
    }

}
