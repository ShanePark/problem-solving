package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 7ms Beats 22.19%of users with Java
 * Memory Details 40.41MB Beats 87.22%of users with Java
 */
public class Q767ReorganizeString {

    @Test
    public void test() {
        assertThat(reorganizeString("kkkkzrkatkwpkkkktrq")).isEqualTo("krktkzktkwkpkrkakqk");
        assertThat(reorganizeString("aab")).isEqualTo("aba");
        assertThat(reorganizeString("aaab")).isEqualTo("");
    }

    public String reorganizeString(String s) {
        Map<Character, Integer> cnt = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            cnt.merge(c, 1, Integer::sum);
        }

        PriorityQueue<MyChar> pq = cnt.entrySet().stream()
                .map(e -> new MyChar(e.getKey(), e.getValue()))
                .collect(Collectors.toCollection(PriorityQueue::new));

        StringBuilder sb = new StringBuilder();
        while (sb.length() < s.length()) {
            MyChar poll = pq.poll();
            int length = sb.length();
            if (length == 0 || poll.c != sb.charAt(length - 1)) {
                sb.append(poll.c);
                poll.cnt--;
                if (poll.cnt > 0) {
                    pq.offer(poll);
                }
                continue;
            }
            if (pq.isEmpty())
                return "";
            MyChar next = pq.poll();
            sb.append(next.c);
            next.cnt--;
            if (next.cnt > 0) {
                pq.offer(next);
            }
            pq.offer(poll);
        }
        return sb.toString();
    }

    class MyChar implements Comparable {
        char c;
        int cnt;

        public MyChar(Character c, Integer cnt) {
            this.c = c;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Object o) {
            MyChar b = (MyChar) o;
            return Integer.compare(b.cnt, cnt);
        }

        @Override
        public String toString() {
            return "MyChar{" +
                    "c=" + c +
                    ", cnt=" + cnt +
                    '}';
        }
    }

}
