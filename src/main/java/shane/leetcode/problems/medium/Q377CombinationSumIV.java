package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Must be TLE
 */
public class Q377CombinationSumIV {

    @Test
    public void test() {
        assertThat(combinationSum4(new int[]{1, 2, 3}, 4)).isEqualTo(7);
        assertThat(combinationSum4(new int[]{9}, 3)).isEqualTo(0);
        combinationSum4(new int[]{1, 2, 3}, 999);
    }

    public int combinationSum4(int[] nums, int target) {
        Queue<Integer> q = new LinkedList<>();
        int[] arr = new int[1001];
        for (int num : nums) {
            q.add(num);
        }

        while (!q.isEmpty()) {
            Integer poll = q.poll();
            for (int num : nums) {
                int sum = poll + num;
                if (sum <= target) {
                    arr[sum]++;
                    q.add(sum);
                }
            }
        }

        return arr[target];
    }
}
