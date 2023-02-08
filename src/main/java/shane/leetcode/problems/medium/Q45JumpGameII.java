package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * bfs TLE
 */
public class Q45JumpGameII {

    @Test
    public void test() {
        assertThat(jump(new int[]{2, 3, 1, 1, 4})).isEqualTo(2);
        assertThat(jump(new int[]{2, 3, 0, 1, 4})).isEqualTo(2);
    }

    /**
     * 943 ms
     */
    @Test
    public void tle() {
        int[] arr = new int[10000];
        Arrays.fill(arr, 1000);
        assertThat(jump(arr)).isEqualTo(10);
    }

    public int jump(int[] nums) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        for (int step = 0; step < nums.length; step++) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer poll = q.poll();
                if (poll == nums.length - 1)
                    return step;
                int range = nums[poll];
                for (int j = 1; j <= range && poll + j < nums.length; j++) {
                    int next = poll + j;
                    q.offer(next);
                }
                nums[poll] = 0;
            }
        }
        return -1;
    }

}
