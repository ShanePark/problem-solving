package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1354ConstructTargetArrayWithMultipleSums {

    @Test
    public void test() {
//        assertThat(isPossible(new int[]{1, 1000000000})).isFalse();
        assertThat(isPossible(new int[]{1, 1, 1, 2})).isFalse();
        assertThat(isPossible(new int[]{9, 3, 5})).isTrue();
        assertThat(isPossible(new int[]{8, 5})).isTrue();
    }

    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for (int i : target) {
            pq.offer(i);
            sum += i;
        }

        while (pq.peek() > 1) {
            Integer poll = pq.poll();
            int next = poll - (sum - poll);
            if (next < 1)
                return false;
            pq.offer(next);
            sum -= poll - next;
        }

        return true;
    }

}
