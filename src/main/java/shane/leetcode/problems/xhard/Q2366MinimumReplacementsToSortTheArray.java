package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2366MinimumReplacementsToSortTheArray {

    @Test
    public void test() {
        assertThat(minimumReplacement(new int[]{3, 10, 3})).isEqualTo(4);
        assertThat(minimumReplacement(new int[]{3, 9, 3})).isEqualTo(2);
        assertThat(minimumReplacement(new int[]{1, 2, 3, 4, 5})).isEqualTo(0);
        assertThat(minimumReplacement(new int[]{19, 7, 2, 24, 11, 16, 1, 11, 23})).isEqualTo(73);
    }

    public long minimumReplacement(int[] nums) {
        long answer = 0;
        int min = nums[nums.length - 1];

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] <= min) {
                min = nums[i];
                continue;
            }

            int cnt = nums[i] / min + (nums[i] % min == 0 ? 0 : 1);
            min = nums[i] / cnt;
            answer += (cnt - 1);
        }

        return answer;
    }

}
