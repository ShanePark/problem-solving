package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * must be TLE
 */
public class Q930BinarySubarraysWithSum {

    @Test
    public void test() {
        assertThat(numSubarraysWithSum(new int[]{1, 0, 1, 0, 1}, 2)).isEqualTo(4);
        assertThat(numSubarraysWithSum(new int[]{0, 0, 0, 0, 0}, 0)).isEqualTo(15);
    }

    @Test
    public void tle() {
        int[] arr = new int[3 * (int) 1e4];
        assertThat(numSubarraysWithSum(arr, 0)).isEqualTo(450015000);
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        for (int num : nums) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer poll = q.poll();
                poll += num;
                if (poll == goal)
                    cnt++;
                if (poll > goal)
                    continue;
                q.offer(poll);
            }
            q.offer(num);
            if (num == goal)
                cnt++;
        }
        return cnt;
    }

}
