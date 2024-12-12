package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 7ms Beats27.26%
 */
public class Q2558TakeGiftsFromtheRichestPile {

    @Test
    public void test() {
        assertThat(pickGifts(new int[]{25, 64, 9, 4, 100}, 4)).isEqualTo(29);
        assertThat(pickGifts(new int[]{1, 1, 1, 1}, 4)).isEqualTo(4);
    }

    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int gift : gifts) {
            pq.offer(gift);
        }
        for (int i = 0; i < k; i++) {
            Integer poll = pq.poll();
            pq.offer((int) Math.sqrt(poll));
        }
        return pq.stream().mapToLong(Long::valueOf).sum();
    }

}
