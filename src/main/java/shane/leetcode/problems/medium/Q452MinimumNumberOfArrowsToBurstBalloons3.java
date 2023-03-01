package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 170 ms Beats 11.19%
 * Memory 97.5 MB Beats 29.1%
 */
public class Q452MinimumNumberOfArrowsToBurstBalloons3 {

    @Test
    public void test() {
        assertThat(findMinArrowShots(Ps.intArray("[[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]")))
                .isEqualTo(2);
        assertThat(findMinArrowShots(Ps.intArray("[[10,16],[2,8],[1,6],[7,12]]"))).isEqualTo(2);
        assertThat(findMinArrowShots(Ps.intArray("[[1,2],[3,4],[5,6],[7,8]]"))).isEqualTo(4);
        assertThat(findMinArrowShots(Ps.intArray("[[1,2],[2,3],[3,4],[4,5]]"))).isEqualTo(2);
    }

    public int findMinArrowShots(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int[] point : points) {
            pq.offer(point);
        }

        int cnt = 0;
        while (!pq.isEmpty()) {
            int[] poll = pq.poll();
            int max = poll[1];
            while (!pq.isEmpty() && pq.peek()[0] <= max && max <= pq.peek()[1]) {
                int[] p = pq.poll();
                max = Math.min(max, p[1]);
            }
            cnt++;
        }
        return cnt;
    }

}
