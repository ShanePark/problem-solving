package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 1 ms Beats 98.75%
 * Memory 40.7 MB Beats 7.73%
 */
public class Q1046LastStoneWeight2 {

    @Test
    public void test() {
        assertThat(lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1})).isEqualTo(1);
        assertThat(lastStoneWeight(new int[]{1})).isEqualTo(1);
        assertThat(lastStoneWeight(new int[]{2, 2})).isEqualTo(0);
    }

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            Integer y = pq.poll();
            Integer x = pq.poll();
            if (x != y) {
                pq.offer(y - x);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

}
