package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime79msBeats6.03%
 */
public class Q264UglyNumberII {

    @Test
    public void test() {
        assertThat(nthUglyNumber(10)).isEqualTo(12);
        assertThat(nthUglyNumber(1)).isEqualTo(1);
        assertThat(nthUglyNumber(137)).isEqualTo(4096);
        assertThat(nthUglyNumber(1690)).isEqualTo(2123366400);
    }

    public int nthUglyNumber(int n) {
        Queue<Integer> q = new LinkedList<>();
        TreeSet<Integer> set = new TreeSet<>();
        q.offer(1);
        set.add(1);
        int[] factors = new int[]{2, 3, 5};
        while (!q.isEmpty()) {
            int poll = q.poll();
            for (int factor : factors) {
                if (Integer.MAX_VALUE < (long) poll * factor) {
                    continue;
                }
                int next = poll * factor;
                if (set.add(next)) {
                    if (set.size() > n) {
                        int last = set.last();
                        set.remove(last);
                        if (next == last) {
                            continue;
                        }
                    }
                    q.offer(next);
                }
            }
        }
        return set.last();
    }

}
