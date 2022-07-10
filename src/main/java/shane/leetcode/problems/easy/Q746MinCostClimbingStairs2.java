package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class Q746MinCostClimbingStairs2 {

    @Test
    public void test() {
        assertThat(minCostClimbingStairs(new int[]{1, 0, 0, 1})).isEqualTo(0);
        assertThat(minCostClimbingStairs(new int[]{10, 20})).isEqualTo(10);
        assertThat(minCostClimbingStairs(new int[]{10, 15, 20})).isEqualTo(15);
        assertThat(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1})).isEqualTo(6);
    }

    public int minCostClimbingStairs(int[] cost) {
        Deque<Integer> deque = new LinkedList<>();
        if (cost[0] < cost[1]) {
            deque.offer(0);
        }
        deque.offer(1);
        for (int i = 2; i < cost.length; i++) {
            cost[i] = cost[deque.peekFirst()] + cost[i];

            if (deque.peekFirst() == i - 2) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && cost[deque.peekLast()] >= cost[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return Math.min(cost[cost.length - 2], cost[cost.length - 1]);
    }
}
