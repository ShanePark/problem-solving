package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class 디펜스_게임 {

    @Test
    public void test() {
        assertThat(solution(3, 2, new int[]{1, 5, 4, 1})).isEqualTo(4);
        assertThat(solution(3, 1, new int[]{3, 5, 1})).isEqualTo(2);
        assertThat(solution(7, 3, new int[]{4, 2, 4, 5, 3, 3, 1})).isEqualTo(5);
        assertThat(solution(2, 4, new int[]{3, 3, 3, 3})).isEqualTo(4);
    }

    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < enemy.length; i++) {
            int opponent = enemy[i];
            if (pq.size() < k) {
                pq.offer(opponent);
            } else if (pq.peek() < opponent) {
                Integer poll = pq.poll();
                pq.offer(opponent);
                n -= poll;
            } else {
                n -= opponent;
            }
            if (n < 0) {
                return i;
            }
        }
        return n < 0 ? enemy.length - 1 : enemy.length;
    }

}
