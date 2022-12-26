package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 142 ms Beats 22.72%
 * Memory 43.1 MB Beats 78.17%
 */
public class Q55JumpGame3 {

    @Test
    public void test() {
        assertThat(canJump(new int[]{2, 3, 1, 1, 4})).isTrue();
        assertThat(canJump(new int[]{3, 2, 1, 0, 4})).isFalse();
        assertThat(canJump(new int[]{0})).isTrue();
    }

    /**
     * 49 ms
     */
    @Test
    public void tle() {
        int[] arr = new int[10000];
        Arrays.fill(arr, 100000);
        assertThat(canJump(arr)).isTrue();
    }

    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        boolean[] visited = new boolean[nums.length];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (int i = 1; i <= nums[poll] && poll + i < nums.length; i++) {
                int next = poll + i;
                if (!visited[next]) {
                    if (next == nums.length - 1)
                        return true;
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        return false;
    }

}
