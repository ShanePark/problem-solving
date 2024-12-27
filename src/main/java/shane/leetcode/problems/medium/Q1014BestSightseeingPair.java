package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 304ms Beats5.13%
 */
public class Q1014BestSightseeingPair {

    @Test
    public void test() {
        assertThat(maxScoreSightseeingPair(new int[]{2, 8, 1, 5, 2, 6})).isEqualTo(11);
        assertThat(maxScoreSightseeingPair(new int[]{8, 1, 5, 2, 6})).isEqualTo(11);
        assertThat(maxScoreSightseeingPair(new int[]{1, 2})).isEqualTo(2);
    }

    public int maxScoreSightseeingPair(int[] values) {
        for (int i = 0; i < values.length; i++) {
            values[i] -= i;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> -o[1]));
        for (int i = 0; i < values.length; i++) {
            pq.offer(new int[]{i, values[i]});
        }

        int max = 0;
        for (int i = 0; i < values.length - 1; i++) {
            while (pq.peek()[0] < i) {
                pq.poll();
            }
            int[] max1 = pq.poll();
            while (pq.peek()[0] < i) {
                pq.poll();
            }
            int[] max2 = pq.poll();
            pq.offer(max1);
            pq.offer(max2);
            max = Math.max(max, max1[1] + max2[1] + 2 * Math.min(max1[0], max2[0]));
        }

        return max;
    }


}
