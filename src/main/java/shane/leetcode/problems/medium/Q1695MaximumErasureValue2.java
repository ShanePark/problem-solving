package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 59ms
 * Beats23.01%
 */
public class Q1695MaximumErasureValue2 {

    @Test
    public void test() {
        assertThat(maximumUniqueSubarray(new int[]{4, 2, 4, 5, 6})).isEqualTo(17);
        assertThat(maximumUniqueSubarray(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5})).isEqualTo(8);
    }

    public int maximumUniqueSubarray(int[] nums) {
        int sum = 0;
        int max = 0;
        Set<Integer> set = new HashSet<>();
        Queue<Integer> q = new LinkedList<>();
        for (int num : nums) {
            if (set.contains(num)) {
                while (q.peek() != num) {
                    int poll = q.poll();
                    sum -= poll;
                    set.remove(poll);
                }
                sum -= q.poll();
                set.remove(num);
            }
            q.offer(num);
            set.add(num);
            sum += num;
            max = Math.max(max, sum);
        }
        return max;
    }

}
