package shane.leetcode.contest.weekly.w288;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2233MaximumProductAfterKIncrements {

    @Test
    public void test() {
        assertThat(maximumProduct(new int[]{0, 4}, 5)).isEqualTo(20);
        assertThat(maximumProduct(new int[]{6, 3, 3, 2}, 2)).isEqualTo(216);
        assertThat(maximumProduct(new int[]{0}, 5)).isEqualTo(5);
        assertThat(maximumProduct(new int[]{24, 5, 64, 53, 26, 38}, 54)).isEqualTo(180820950);
        assertThat(maximumProduct(new int[]{24, 5, 64, 53, 26, 38}, 100000)).isEqualTo(23040041);
    }

    public int maximumProduct(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0] + k;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        while (k > 0) {
            Integer poll = pq.poll();
            if (pq.peek().equals(poll)) {
                pq.offer(poll + 1);
                k = k - 1;
            } else {
                int min = Math.min(k, pq.peek() - poll);
                k -= min;
                pq.offer(poll + min);
            }
        }
        long result = 1;
        while (!pq.isEmpty()) {
            result = (result * pq.poll()) % (1000000007);
        }
        return (int) result;
    }
}
