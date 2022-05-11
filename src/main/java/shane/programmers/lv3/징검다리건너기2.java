package shane.programmers.lv3;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class 징검다리건너기2 {

    @Test
    public void test() {
        assertThat(solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3)).isEqualTo(3);
    }

    public int solution(int[] stones, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i <= k - 1; i++) {
            pq.offer(stones[i]);
        }
        int min = pq.peek();
        for (int i = k; i < stones.length; i++) {
            pq.remove(stones[i - k]);
            pq.offer(stones[i]);
            min = Math.min(min, pq.peek());
        }
        return min;
    }

}
