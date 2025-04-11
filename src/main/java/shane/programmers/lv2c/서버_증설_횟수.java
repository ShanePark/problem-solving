package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class 서버_증설_횟수 {

    @Test
    public void test() {
        assertThat(solution(new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5}, 3, 5)).isEqualTo(7);
        assertThat(solution(new int[]{0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0}, 5, 1)).isEqualTo(11);
        assertThat(solution(new int[]{0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1}, 1, 1)).isEqualTo(12);
        assertThat(solution(new int[]{0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1}, 1, 1)).isEqualTo(12);
    }

    public int solution(int[] players, int m, int k) {
        Queue<Integer> servers = new LinkedList<>();
        int answer = 0;
        for (int i = 0; i < players.length; i++) {
            while (!servers.isEmpty() && servers.peek() <= i) {
                servers.poll();
            }
            int newServersNeeded = players[i] / m;
            while (servers.size() < newServersNeeded) {
                servers.add(i + k);
                answer++;
            }
        }
        return answer;
    }

}
