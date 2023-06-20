package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 30 ms Beats 5.75%
 * Memory 60.3 MB Beats 75.36%
 */
public class Q2090KRadiusSubarrayAverages {

    @Test
    public void test() {
        assertThat(getAverages(new int[]{7, 4, 3, 9, 1, 8, 5, 2, 6}, 3)).containsExactly(-1, -1, -1, 5, 4, 4, -1, -1, -1);
        assertThat(getAverages(new int[]{100000}, 0)).containsExactly(100000);
        assertThat(getAverages(new int[]{8}, 100000)).containsExactly(-1);
    }

    public int[] getAverages(int[] nums, int k) {
        long sum = 0;
        int[] answer = new int[nums.length];
        Arrays.fill(answer, -1);
        final int WIDTH = 2 * k + 1;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum += num;
            q.offer(num);
            if (k * 2 < i) {
                sum -= q.poll();
            }

            if (q.size() == WIDTH) {
                answer[i - k] = (int) (sum / WIDTH);
            }
        }
        return answer;
    }

}
