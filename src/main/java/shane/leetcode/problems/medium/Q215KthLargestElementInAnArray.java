package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q215KthLargestElementInAnArray {

    @Test
    public void test() {
        assertThat(findKthLargest(new int[]{1}, 1)).isEqualTo(1);
        assertThat(findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2)).isEqualTo(5);
        assertThat(findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4)).isEqualTo(4);
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (pq.size() < k) {
                pq.offer(num);
            } else if (pq.peek() < num) {
                pq.poll();
                pq.offer(num);
            }
        }
        return pq.peek();
    }

    // sort
//    public int findKthLargest(int[] nums, int k) {
//        Arrays.sort(nums);
//        return nums[nums.length - k];
//    }

}
