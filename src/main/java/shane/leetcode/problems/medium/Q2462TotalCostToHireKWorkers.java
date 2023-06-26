package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 72 ms Beats 40.59%
 * Memory 56 MB Beats 77.33%
 */
public class Q2462TotalCostToHireKWorkers {

    @Test
    public void test() {
        assertThat(totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4)).isEqualTo(11);
        assertThat(totalCost(new int[]{1, 2, 4, 1}, 3, 3)).isEqualTo(4);
    }

    public long totalCost(int[] costs, int k, int candidates) {
        int length = costs.length;
        PriorityQueue<Integer> left = new PriorityQueue<>();
        Deque<Integer> mid = new ArrayDeque<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();
        for (int i = 0; i < candidates; i++) {
            left.offer(costs[i]);
        }
        for (int i = candidates; i < costs.length - candidates; i++) {
            mid.offer(costs[i]);
        }
        int rightStart = Math.max(length - candidates, candidates);
        for (int i = rightStart; i < length; i++) {
            right.offer(costs[i]);
        }

        long sum = 0;

        for (int i = 0; i < k; i++) {
            if (i + candidates * 2 >= costs.length) {
                return sum + finish(left, right, k - i);
            }
            Integer leftPeek = left.peek();
            Integer rightPeek = right.peek();
            if (leftPeek <= rightPeek) {
                sum += left.poll();
                left.offer(mid.pollFirst());
            } else {
                sum += right.poll();
                right.offer(mid.pollLast());
            }
        }

        return sum;
    }

    private long finish(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int cnt) {
        left.addAll(right);
        long sum = 0;
        for (int i = 0; i < cnt; i++) {
            Integer poll = left.poll();
            sum += poll;
        }
        return sum;
    }

}
