package shane.leetcode.contest.weekly.w301;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1 {

    @Test
    public void test() {
        assertThat(fillCups(new int[]{1, 4, 2})).isEqualTo(4);
        assertThat(fillCups(new int[]{5, 4, 4})).isEqualTo(7);
        assertThat(fillCups(new int[]{5, 0, 0})).isEqualTo(5);
    }

    public int fillCups(int[] amount) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : amount) {
            pq.offer(i);
        }
        int time = 0;
        while (pq.peek() > 0) {
            Integer poll = pq.poll();
            Integer poll2 = pq.poll();
            pq.offer(poll - 1);
            pq.offer(poll2 - 1);
            time++;
        }
        return time;
    }

}
