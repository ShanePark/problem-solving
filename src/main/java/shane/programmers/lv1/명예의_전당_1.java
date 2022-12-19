package shane.programmers.lv1;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class 명예의_전당_1 {

    @Test
    public void test() {
        assertThat(solution(3, new int[]{10, 100, 20, 150, 1, 100, 200})).containsExactly(10, 10, 10, 20, 20, 100, 100);
        assertThat(solution(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000})).containsExactly(0, 0, 0, 0, 20, 40, 70, 70, 150, 300);
    }

    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < score.length; i++) {
            int n = score[i];
            pq.offer(n);
            if (pq.size() > k) {
                pq.poll();
            }
            score[i] = pq.peek();
        }
        return score;
    }
}
