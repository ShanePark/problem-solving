package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 2 ms Beats 47.70% of users with Java
 */
public class Q1608SpecialArrayWithXElementsGreaterThanOrEqualX {

    @Test
    public void test() {
        assertThat(specialArray(new int[]{0, 4, 3, 0, 4})).isEqualTo(3);
        assertThat(specialArray(new int[]{2, 1})).isEqualTo(-1);
        assertThat(specialArray(new int[]{0, 0})).isEqualTo(-1);
        assertThat(specialArray(new int[]{3, 5})).isEqualTo(2);
        assertThat(specialArray(new int[]{5, 4, 3})).isEqualTo(3);
        assertThat(specialArray(new int[]{5, 4})).isEqualTo(2);
    }

    public int specialArray(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : nums) {
            pq.offer(num);
        }
        int cnt = 0;
        while (!pq.isEmpty()) {
            int poll = pq.poll();
            cnt++;
            if (poll < cnt)
                continue;
            if (pq.isEmpty() || pq.peek() < cnt) {
                return cnt;
            }
        }
        return -1;
    }

}
