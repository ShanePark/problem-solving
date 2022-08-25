package shane.programmers.lv2c;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class 두_큐_합_같게_만들기 {

    @Test
    public void test() {
        assertThat(solution(new int[]{3, 2, 7, 2}, new int[]{4, 6, 5, 1})).isEqualTo(2);
        assertThat(solution(new int[]{1, 2, 1, 2}, new int[]{1, 10, 1, 2})).isEqualTo(7);
        assertThat(solution(new int[]{1, 1}, new int[]{1, 5})).isEqualTo(-1);
    }

    public int solution(int[] queue1, int[] queue2) {
        Q q1 = new Q(queue1);
        Q q2 = new Q(queue2);
        long sum = q1.sum + q2.sum;
        int cnt = 0;

        while (q1.sum != sum / 2) {
            if (q1.sum > q2.sum) {
                q2.offer(q1.poll());
            } else {
                q1.offer(q2.poll());
            }
            cnt++;
            if (cnt > (queue1.length * 3 - 1))
                return -1;
        }

        return cnt;
    }

    class Q {
        Queue<Integer> q = new LinkedList<>();
        long sum = 0;

        public Q(int[] nums) {
            for (int num : nums) {
                sum += num;
                q.offer(num);
            }
        }

        public void offer(int n) {
            sum += n;
            q.offer(n);
        }

        public int poll() {
            Integer poll = q.poll();
            sum -= poll;
            return poll;
        }
    }
}
