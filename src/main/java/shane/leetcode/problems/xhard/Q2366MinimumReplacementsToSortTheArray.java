package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2366MinimumReplacementsToSortTheArray {

    @Test
    public void test() {
        assertThat(minimumReplacement(new int[]{3, 9, 3})).isEqualTo(2);
        assertThat(minimumReplacement(new int[]{3, 10, 3})).isEqualTo(4);
        assertThat(minimumReplacement(new int[]{1, 2, 3, 4, 5})).isEqualTo(0);
    }

    public long minimumReplacement(int[] nums) {
        long answer = 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            int cur = nums[i];
            int next = nums[i + 1];
            if (cur <= next) {
                continue;
            }
            int cnt = (cur + next - 1) / next;
            nums[i] = nums[i] / cnt;

            answer += (cnt - 1);
        }

        return answer;
    }

}
