package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not Mine
 */
public class Q862ShortestSubarraywithSumatLeastK2 {
    @Test
    public void test2() {
        assertThat(shortestSubarray(new int[]{2, -1, 2}, 3)).isEqualTo(3);
    }

    @Test
    public void test() {
        assertThat(shortestSubarray(new int[]{-34, 37, 51, 3, -12, -50, 51, 100, -47, 99, 34, 14, -13, 89, 31, -14, -44, 23, -38, 6}, 151)).isEqualTo(2);
        assertThat(shortestSubarray(new int[]{-28, 81, -20, 28, -29}, 89)).isEqualTo(3);
        assertThat(shortestSubarray(new int[]{84, -37, 32, 40, 95}, 167)).isEqualTo(3);
        assertThat(shortestSubarray(new int[]{1}, 1)).isEqualTo(1);
        assertThat(shortestSubarray(new int[]{1, 2}, 4)).isEqualTo(-1);
    }

    public int shortestSubarray(int[] nums, int k) {
        int answer = Integer.MAX_VALUE;
        long[] sum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < nums.length + 1; i++) {
            while (!deque.isEmpty() && sum[i] - sum[deque.peekFirst()] >= k)
                answer = Math.min(answer, i - deque.pollFirst());
            while (!deque.isEmpty() && sum[i] <= sum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.addLast(i);
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

}
