package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
148ms
Beats69.14%
 */
public class Q3066MinimumOperationsToExceedThresholdValueII {

    @Test
    public void test() {
        assertThat(minOperations(new int[]{2, 11, 10, 1, 3}, 10)).isEqualTo(2);
        assertThat(minOperations(new int[]{1, 1, 2, 4, 9}, 20)).isEqualTo(4);
        assertThat(minOperations(new int[]{999999999, 999999999, 999999999}, 1000000000)).isEqualTo(2);
    }

    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer((long) num);
        }
        int answer = 0;
        while (pq.peek() < k) {
            long n1 = pq.poll();
            long n2 = pq.poll();
            pq.offer((Math.min(n1, n2) * 2 + Math.max(n1, n2)));
            answer++;
        }
        return answer;
    }

}
