package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime1msBeats77.96%
 */
public class Q1405LongestHappyString {

    @Test
    public void test() {
        assertThat(longestDiverseString(3, 0, 4)).hasSize(7).doesNotContain(List.of("aaa", "bbb", "ccc"));
        assertThat(longestDiverseString(1, 4, 5)).hasSize(10).doesNotContain(List.of("aaa", "bbb", "ccc"));
        assertThat(longestDiverseString(1, 1, 7)).hasSize(8).doesNotContain(List.of("aaa", "bbb", "ccc"));
        assertThat(longestDiverseString(7, 1, 0)).hasSize(5).doesNotContain(List.of("aaa", "bbb", "ccc"));
        assertThat(longestDiverseString(7, 2, 0)).hasSize(8).doesNotContain(List.of("aaa", "bbb", "ccc"));
        assertThat(longestDiverseString(2, 2, 2)).hasSize(6).doesNotContain(List.of("aaa", "bbb", "ccc"));
    }

    public String longestDiverseString(int a, int b, int c) {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<CharClass> pq = new PriorityQueue<>();
        if (a > 0) {
            pq.offer(new CharClass('a', a));
        }
        if (b > 0) {
            pq.offer(new CharClass('b', b));
        }
        if (c > 0) {
            pq.offer(new CharClass('c', c));
        }
        while (!pq.isEmpty()) {
            CharClass c1 = pq.poll();

            // process c1
            boolean endWithSameChar = sb.length() > 0 && sb.charAt(sb.length() - 1) == c1.c;
            int c1Cnt = Math.min(c1.size, 2);
            if (endWithSameChar) {
                c1Cnt = 1;
            }
            for (int i = 0; i < c1Cnt; i++) {
                sb.append(c1.c);
            }
            c1.size -= c1Cnt;

            // process c2
            if (pq.isEmpty())
                continue;
            CharClass c2 = pq.poll();
            sb.append(c2.c);
            c2.size--;

            if (c1.size > 0) {
                pq.offer(c1);
            }
            if (c2.size > 0) {
                pq.offer(c2);
            }
        }
        return sb.toString();
    }

    static class CharClass implements Comparable<CharClass> {
        final char c;
        int size;

        CharClass(char c, int size) {
            this.c = c;
            this.size = size;
        }


        @Override
        public int compareTo(CharClass o) {
            return o.size - this.size;
        }
    }

}
