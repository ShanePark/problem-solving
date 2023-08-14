package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 55ms Beats 43.16%of users with Java
 * Memory Details 56.74mb Beats 23.58%of users with Java
 */
public class Q215KthLargestElementInAnArray2 {

    @Test
    public void test() {
        assertThat(findKthLargest(new int[]{1}, 1)).isEqualTo(1);
        assertThat(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)).isEqualTo(5);
        assertThat(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)).isEqualTo(4);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

}
