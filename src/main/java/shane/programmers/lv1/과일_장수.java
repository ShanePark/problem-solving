package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class 과일_장수 {

    @Test
    public void test() {
        assertThat(solution(3, 4, new int[]{1, 2, 3, 1, 2, 3, 1})).isEqualTo(8);
        assertThat(solution(4, 3, new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2})).isEqualTo(33);
    }

    public int solution(int k, int m, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i : score) {
            i = Math.min(i, k);
            pq.add(i);
        }

        int sum = 0;
        while (pq.size() >= m) {
            for (int i = 1; i < m; i++) {
                pq.poll();
            }
            sum += pq.poll() * m;
        }

        return sum;
    }

}
