package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 47ms
 * Beats10.68%
 */
public class Q1358NumberOfSubstringsContainingAllThreeCharacters {

    @Test
    public void test() {
        assertThat(numberOfSubstrings("abcabc")).isEqualTo(10);
        assertThat(numberOfSubstrings("aaacb")).isEqualTo(3);
        assertThat(numberOfSubstrings("abc")).isEqualTo(1);
    }

    public int numberOfSubstrings(String s) {
        Queue<Integer> aIndexes = new LinkedList<>();
        Queue<Integer> bIndexes = new LinkedList<>();
        Queue<Integer> cIndexes = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'a':
                    aIndexes.add(i);
                    continue;
                case 'b':
                    bIndexes.add(i);
                    continue;
                case 'c':
                    cIndexes.add(i);
                    continue;
            }
        }
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            clear(i, aIndexes, bIndexes, cIndexes);
            if (aIndexes.isEmpty() || bIndexes.isEmpty() || cIndexes.isEmpty()) {
                break;
            }
            int minIndex = -1;
            switch (c) {
                case 'a':
                    minIndex = Math.max(bIndexes.peek(), cIndexes.peek());
                    break;
                case 'b':
                    minIndex = Math.max(aIndexes.peek(), cIndexes.peek());
                    break;
                case 'c':
                    minIndex = Math.max(aIndexes.peek(), bIndexes.peek());
                    break;
            }
            answer += (s.length() - minIndex);
        }
        return answer;
    }

    private void clear(int i, Queue<Integer>... queues) {
        for (Queue<Integer> queue : queues) {
            while (!queue.isEmpty() && queue.peek() < i) {
                queue.poll();
            }
        }
    }

}
