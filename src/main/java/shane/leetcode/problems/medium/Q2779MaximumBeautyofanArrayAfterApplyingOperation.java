package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 104ms Beats15.38%
 */
public class Q2779MaximumBeautyofanArrayAfterApplyingOperation {

    @Test
    public void test() {
        assertThat(maximumBeauty(new int[]{4, 6, 1, 2}, 2)).isEqualTo(3);
        assertThat(maximumBeauty(new int[]{1, 1, 1, 1}, 10)).isEqualTo(4);
    }

    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int maxSize = 0;
        for (long num : nums) {
            pq.offer(num);
            while (!pq.isEmpty() && pq.peek() + 2L * k < num) {
                pq.poll();
            }
            maxSize = Math.max(maxSize, pq.size());
        }
        return maxSize;
    }

}
