package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q55JumpGame {

    @Test
    public void test() {
        assertThat(canJump(new int[]{2, 3, 1, 1, 4})).isTrue();
        assertThat(canJump(new int[]{3, 2, 1, 0, 4})).isFalse();
    }

    /**
     * 898 ms
     */
    @Test
    public void tle() {
        int[] arr = new int[10000];
        Arrays.fill(arr, 100000);
        assertThat(canJump(arr)).isTrue();
    }

    public boolean canJump(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        visited[0] = true;
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (int i = 1; i <= nums[poll]; i++) {
                int next = poll + i;
                if (next < nums.length && !visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        return visited[nums.length - 1];
    }

}
