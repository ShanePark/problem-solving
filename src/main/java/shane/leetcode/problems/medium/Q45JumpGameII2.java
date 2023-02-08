package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * greedy
 * Runtime 1 ms Beats 99.45%
 * Memory 43.1 MB Beats 40.86%
 */
public class Q45JumpGameII2 {

    @Test
    public void test() {
        assertThat(jump(new int[]{2, 3, 1, 1, 4})).isEqualTo(2);
        assertThat(jump(new int[]{2, 3, 0, 1, 4})).isEqualTo(2);
    }

    @Test
    public void tle() {
        int[] arr = new int[10000];
        Arrays.fill(arr, 1000);
        assertThat(jump(arr)).isEqualTo(10);
    }

    public int jump(int[] nums) {
        if (nums.length <= 1)
            return 0;
        int cur = 0;
        int max = nums[0];
        for (int step = 1; step < nums.length; step++) {
            if (max >= nums.length - 1) {
                return step;
            }
            int newMax = 0;
            for (int i = cur; i <= max; i++) {
                newMax = Math.max(newMax, i + nums[i]);
            }
            cur = max;
            max = newMax;
        }
        return -1;
    }

}
