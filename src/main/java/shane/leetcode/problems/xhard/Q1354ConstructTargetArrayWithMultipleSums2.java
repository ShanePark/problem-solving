package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1354ConstructTargetArrayWithMultipleSums2 {

    @Test
    public void test() {
        assertThat(isPossible(new int[]{1, 1000000000})).isTrue();
        assertThat(isPossible(new int[]{1, 1, 1, 2})).isFalse();
        assertThat(isPossible(new int[]{9, 3, 5})).isTrue();
        assertThat(isPossible(new int[]{8, 5})).isTrue();
    }

    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        for (int i : target) {
            pq.offer(i);
            sum += i;
        }

        while (sum > 1 && pq.peek() > sum / 2) {
            int poll = pq.poll();
            sum -= poll;

            if (sum == 0)
                return false;
            if (sum == 1)
                return true;

            int next = poll % (int) sum;

            pq.offer(next);
            sum += next;
        }

        return sum == target.length;
    }

}
