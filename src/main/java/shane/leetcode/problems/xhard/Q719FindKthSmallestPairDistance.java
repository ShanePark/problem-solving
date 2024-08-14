package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Memory Limit Exceeded
 */
public class Q719FindKthSmallestPairDistance {

    @Test
    public void test() {
        assertThat(smallestDistancePair(new int[]{1, 6, 1}, 3)).isEqualTo(5);
        assertThat(smallestDistancePair(new int[]{9, 10, 7, 10, 6, 1, 5, 4, 9, 8}, 18))
                .isEqualTo(2);
        assertThat(smallestDistancePair(new int[]{1, 3, 1}, 1)).isEqualTo(0);
        assertThat(smallestDistancePair(new int[]{1, 1, 1}, 2)).isEqualTo(0);
    }

    @Test
    public void mle() {
        int[] arr = new int[10000];
        assertThat(smallestDistancePair(arr, 25000000)).isEqualTo(0);
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int pqSize = Math.max(k, (nums.length * (nums.length - 1) / 2) - k + 1);
        bigLoop:
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int diff = nums[j] - nums[i];
                pq.offer(diff);
                if (pq.size() > pqSize) {
                    int poll = pq.poll();
                    if (poll == diff)
                        continue bigLoop;
                }
            }
        }
        while (pq.size() > k) {
            pq.poll();
        }
        return pq.peek();
    }

}
