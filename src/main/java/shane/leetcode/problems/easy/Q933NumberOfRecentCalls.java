package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q933NumberOfRecentCalls {

    @Test
    public void test() {
        RecentCounter rc = new RecentCounter();
        assertThat(rc.ping(1)).isEqualTo(1);
        assertThat(rc.ping(100)).isEqualTo(2);
        assertThat(rc.ping(3001)).isEqualTo(3);
        assertThat(rc.ping(3002)).isEqualTo(3);
    }

    class RecentCounter {

        Queue<Integer> q;

        public RecentCounter() {
            q = new LinkedList<>();
        }

        public int ping(int t) {
            q.offer(t);
            while (q.peek() < t - 3000) {
                q.poll();
            }
            return q.size();
        }
    }


}
