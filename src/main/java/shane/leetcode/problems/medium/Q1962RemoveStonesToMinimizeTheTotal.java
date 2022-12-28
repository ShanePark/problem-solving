package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 517 ms Beats 90.43%
 * Memory 55.9 MB Beats 87.39%
 */
public class Q1962RemoveStonesToMinimizeTheTotal {

    @Test
    public void test() {
        assertThat(minStoneSum(new int[]{5, 4, 9}, 2)).isEqualTo(12);
        assertThat(minStoneSum(new int[]{4, 3, 6, 7}, 3)).isEqualTo(12);
    }

    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int pile : piles) {
            pq.offer(pile);
        }
        for (int i = 0; i < k; i++) {
            Integer poll = pq.poll();
            pq.offer(poll - (int) Math.floor(poll / 2));
        }
        return pq.stream().mapToInt(i -> i).sum();
    }
}
