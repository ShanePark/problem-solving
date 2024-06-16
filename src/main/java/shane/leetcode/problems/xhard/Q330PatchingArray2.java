package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q330PatchingArray2 {

    @Test
    public void test() {
        assertThat(minPatches(new int[]{1, 5, 10}, 20)).isEqualTo(2);
        assertThat(minPatches(new int[]{1, 3}, 6)).isEqualTo(1);
        assertThat(minPatches(new int[]{1, 2, 2}, 5)).isEqualTo(0);
    }

    @Test
    public void memory_limit_exceeded() {
        assertThat(minPatches(new int[]{1, 2, 31, 33}, 2147483647)).isEqualTo(28);
    }

    public int minPatches(int[] nums, int n) {
        int answer = 0;
        long cur = 1;
        int i = 0;

        while (cur <= n) {
            if (i < nums.length && nums[i] <= cur) {
                cur += nums[i++];
                continue;
            }
            cur *= 2;
            answer++;
        }
        return answer;
    }

}
