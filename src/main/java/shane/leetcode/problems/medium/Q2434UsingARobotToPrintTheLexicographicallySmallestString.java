package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime422msBeats5.59%
 */
public class Q2434UsingARobotToPrintTheLexicographicallySmallestString {

    @Test
    public void test() {
        assertThat(robotWithString("vzhofnpo")).isEqualTo("fnohopzv");
        assertThat(robotWithString("bac")).isEqualTo("abc");
        assertThat(robotWithString("zza")).isEqualTo("azz");
        assertThat(robotWithString("bdda")).isEqualTo("addb");
    }

    public String robotWithString(String s) {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        Map<Character, Integer> cnt = new HashMap<>();
        for (char c : s.toCharArray()) {
            pq.offer(c);
            cnt.merge(c, 1, Integer::sum);
        }
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            while (cnt.get(pq.peek()) == 0) {
                pq.poll();
            }
            char peek = pq.peek();
            while (!stack.isEmpty() && stack.peek() <= peek) {
                sb.append(stack.pop());
            }
            char c = s.charAt(i);
            cnt.merge(c, -1, Integer::sum);
            if (c == peek) {
                sb.append(pq.poll());
                continue;
            }
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

}
