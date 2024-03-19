package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 43 ms Beats 11.34% of users with Java
 */
public class Q621TaskScheduler {

    @Test
    public void test() {
        assertThat(leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 1)).isEqualTo(12);
        assertThat(leastInterval(new char[]{'A', 'A', 'A'}, 1)).isEqualTo(5);
        assertThat(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2)).isEqualTo(8);
        assertThat(leastInterval(new char[]{'A', 'C', 'A', 'B', 'D', 'B'}, 1)).isEqualTo(6);
        assertThat(leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 3)).isEqualTo(10);
    }

    public int leastInterval(char[] tasks, int n) {
        int[] chars = new int[26];
        for (char task : tasks) {
            chars[task - 'A']++;
        }
        PriorityQueue<Status> pq = new PriorityQueue<>();
        for (int i = 0; i < 26; i++) {
            int cnt = chars[i];
            if (cnt == 0)
                continue;
            char c = (char) ('A' + i);
            Status status = new Status(c, cnt);
            pq.offer(status);
        }
        int curTime = 0;
        while (!pq.isEmpty()) {
            List<Status> possible = new ArrayList<>();
            while (!pq.isEmpty() && pq.peek().isPossible(curTime, n)) {
                possible.add(pq.poll());
            }
            // find max cnt among list and calc
            possible.sort((s1, s2) -> {
                if (s1.count == s2.count) {
                    return Integer.compare(s1.lastActivated, s2.lastActivated);
                }
                return Integer.compare(s2.count, s1.count);
            });

            Status target;
            // if not possible
            if (possible.isEmpty()) {
                target = pq.poll();
            } else {
                target = possible.remove(0);
            }
            curTime = Math.max(target.lastActivated + n + 1, curTime + 1);
            target.lastActivated = curTime;
            target.count--;
            if (target.count > 0) {
                pq.offer(target);
            }
            pq.addAll(possible);
        }
        return curTime;
    }

    static class Status implements Comparable<Status> {
        final char c;
        int count;
        int lastActivated = -101;

        public Status(char c, int count) {
            this.c = c;
            this.count = count;
        }

        @Override
        public int compareTo(Status o) {
            if (o.lastActivated == this.lastActivated) {
                return Integer.compare(o.count, this.count);
            }
            return Integer.compare(this.lastActivated, o.lastActivated);
        }

        @Override
        public String toString() {
            return "Status{" +
                    "c=" + c +
                    ", count=" + count +
                    ", lastActivated=" + lastActivated +
                    '}';
        }

        public boolean isPossible(int curTime, int n) {
            return this.lastActivated + n <= curTime;
        }
    }

}
