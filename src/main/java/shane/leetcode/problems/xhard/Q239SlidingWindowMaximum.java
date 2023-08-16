package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q239SlidingWindowMaximum {

    @Test
    public void test() {
        assertThat(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)).containsExactly(3, 3, 5, 5, 6, 7);
        assertThat(maxSlidingWindow(new int[]{1, -1}, 1)).containsExactly(1, -1);
        assertThat(maxSlidingWindow(new int[]{1}, 1)).containsExactly(1);
    }

    /**
     * 1 sec 475 ms
     */
    @Test
    public void tle() {
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt(10000);
        }

        assertThat(maxSlidingWindow(arr, 30000)).isNotEqualTo(arr);
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < k - 1; i++) {
            pq.offer(nums[i]);
        }

        int[] answer = new int[nums.length - k + 1];
        for (int i = k - 1; i < nums.length; i++) {
            pq.offer(nums[i]);
            answer[i - k + 1] = pq.peek();
            if (pq.size() >= k) {
                int removeTarget = nums[i - k + 1];
                pq.remove(removeTarget);
            }
        }
        return answer;
    }

}
