package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1046LastStoneWeight {

    @Test
    public void test() {
        assertThat(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1})).isEqualTo(1);
        assertThat(lastStoneWeight(new int[]{1})).isEqualTo(1);
        assertThat(lastStoneWeight(new int[]{2, 2})).isEqualTo(0);
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int stone : stones) {
            pq.add(stone);
        }
        while (pq.size() > 1) {
            Integer stone1 = pq.poll();
            Integer stone2 = pq.poll();
            if (stone1 != stone2) {
                pq.add(stone1 - stone2);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
