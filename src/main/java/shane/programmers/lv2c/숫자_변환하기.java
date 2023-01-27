package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class 숫자_변환하기 {

    @Test
    public void test() {
        assertThat(solution(10, 40, 5)).isEqualTo(2);
        assertThat(solution(10, 40, 30)).isEqualTo(1);
        assertThat(solution(2, 5, 4)).isEqualTo(-1);
    }

    public int solution(int x, int y, int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.offer(y);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer poll = q.poll();
                if (!set.add(poll)) continue;
                if (poll == x) return step;
                if (poll % 2 == 0) q.offer(poll / 2);
                if (poll % 3 == 0) q.offer(poll / 3);
                if (poll > n) q.offer(poll - n);
            }
            step++;
        }
        return -1;
    }
}
