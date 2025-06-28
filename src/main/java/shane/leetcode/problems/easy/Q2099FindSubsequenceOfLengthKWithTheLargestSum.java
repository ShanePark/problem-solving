package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 7
 * ms
 * Beats
 * 83.20%
 */
public class Q2099FindSubsequenceOfLengthKWithTheLargestSum {

    @Test
    public void test() {
        assertThat(maxSubsequence(new int[]{-1, -2, 3, 4}, 3)).containsExactly(-1, 3, 4);
        assertThat(maxSubsequence(new int[]{2, 1, 3, 3}, 2)).containsExactly(3, 3);
        assertThat(maxSubsequence(new int[]{3, 4, 3, 3}, 2)).containsExactly(3, 4);
    }

    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Queue<Integer> q = new LinkedList<>();
        for (int num : nums) {
            if (pq.size() == k && pq.peek() >= num)
                continue;
            pq.offer(num);
            q.offer(num);
            if (pq.size() > k) {
                q.remove(pq.poll());
            }
        }
        int[] answer = new int[k];
        int i = 0;
        for (Integer n : q) {
            answer[i++] = n;
        }
        return answer;
    }

}
