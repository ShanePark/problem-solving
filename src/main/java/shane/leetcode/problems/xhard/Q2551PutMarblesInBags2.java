package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2551PutMarblesInBags2 {

    @Test
    void test() {
        assertThat(putMarbles(new int[]{1, 3, 5, 1}, 2)).isEqualTo(4);
        assertThat(putMarbles(new int[]{1, 3}, 2)).isEqualTo(0);
    }

    @Test
    public void test2() {
        assertThat(putMarbles(new int[]{24, 16, 62, 27, 8, 3, 70, 55, 13, 34, 9, 29, 10}, 11)).isEqualTo(168);
    }

    public long putMarbles(int[] weights, int k) {
        PriorityQueue<Integer> pq = IntStream.range(0, weights.length - 1)
                .map(i -> weights[i] + weights[i + 1])
                .sorted()
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));
        PriorityQueue<Integer> reversePq = new PriorityQueue<>(Comparator.reverseOrder());
        reversePq.addAll(pq);

        long answer = 0;
        for (int i = 0; i < k - 1; i++) {
            answer += reversePq.poll();
            answer -= pq.poll();
        }
        return answer;
    }

}
