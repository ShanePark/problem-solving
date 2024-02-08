package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 123 ms Beats 19.50% of users with Java
 */
public class Q279PerfectSquares5 {

    @Test
    public void test() {
        assertThat(numSquares(12)).isEqualTo(3);
        assertThat(numSquares(3)).isEqualTo(3);
        assertThat(numSquares(13)).isEqualTo(2);
        assertThat(numSquares(32)).isEqualTo(2);
    }

    @Test
    public void tle() {
        assertThat(numSquares(7168)).isEqualTo(4);
    }

    public int numSquares(int n) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.offer(0);
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer poll = q.poll();
                if (!set.add(poll)) {
                    continue;
                }
                if (poll == n) {
                    return step;
                }
                for (int j = 1; poll + (j * j) <= n; j++) {
                    q.offer(poll + j * j);
                }
            }
            step++;
        }
        return step;
    }

}
