package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 15
 * ms
 * Beats
 * 7.26%
 */
public class Q3208AlternatingGroupsII {

    @Test
    public void test() {
        assertThat(numberOfAlternatingGroups(new int[]{0, 1, 0, 1, 0}, 3)).isEqualTo(3);
        assertThat(numberOfAlternatingGroups(new int[]{0, 1, 0, 0, 1, 0, 1}, 6)).isEqualTo(2);
        assertThat(numberOfAlternatingGroups(new int[]{1, 1, 0, 1}, 4)).isEqualTo(0);
    }

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int answer = 0;
        Deque<Boolean> deque = new LinkedList<>();
        for (int i = 0; i < colors.length + k - 1; i++) {
            boolean cur = colors[i % colors.length] == 1;
            if (!deque.isEmpty() && deque.peekLast() == cur) {
                deque.clear();
            }
            deque.offer(cur);
            if (deque.size() == k) {
                answer++;
                deque.pollFirst();
            }
        }
        return answer;
    }

}
