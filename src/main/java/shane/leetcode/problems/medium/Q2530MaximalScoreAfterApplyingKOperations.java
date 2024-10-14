package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime154msBeats46.92%
 */
public class Q2530MaximalScoreAfterApplyingKOperations {

    @Test
    public void test() {
        assertThat(maxKelements(new int[]{10, 10, 10, 10, 10}, 5)).isEqualTo(50);
        assertThat(maxKelements(new int[]{1, 10, 3, 3, 3}, 3)).isEqualTo(17);
    }

    public long maxKelements(int[] nums, int k) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (Integer i : nums) {
            pq.offer(i);
        }
        for (int i = 0; i < k; i++) {
            Integer poll = pq.poll();
            answer += poll;
            pq.offer((int) Math.ceil(poll / 3.0));
        }
        return answer;
    }

}
