package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q821ShortestDistanceToACharacter {

    @Test
    public void test() {
        assertThat(shortestToChar("zzzzazzz", 'a')).containsExactly(4, 3, 2, 1, 0, 1, 2, 3);
        assertThat(shortestToChar("loveleetcode", 'e')).containsExactly(3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0);
        assertThat(shortestToChar("aaab", 'b')).containsExactly(3, 2, 1, 0);
        assertThat(shortestToChar("aaaaaaaa", 'a')).containsExactly(0, 0, 0, 0, 0, 0, 0, 0);
    }

    public int[] shortestToChar(String s, char c) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (s.charAt(i) == c) {
                pq.offer(i);
            }
        }
        int[] answer = new int[length];
        Integer before = pq.poll();
        int i = 0;

        while (i < before) {
            answer[i] = before - i;
            i++;
        }

        while (!pq.isEmpty()) {
            int next = pq.peek();
            answer[++i] = Math.min(Math.abs(i - before), Math.abs(next - i));
            if (i == next) {
                before = pq.poll();
            }
        }

        while (i < length - 1) {
            answer[++i] = i - before;
        }

        return answer;
    }
}
