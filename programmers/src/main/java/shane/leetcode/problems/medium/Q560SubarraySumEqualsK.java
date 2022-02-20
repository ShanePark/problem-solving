package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q560SubarraySumEqualsK {

    @Test
    void test() {
        Assertions.assertThat(subarraySum(new int[]{1, 1, 1,}, 2)).isEqualTo(2);
        Assertions.assertThat(subarraySum(new int[]{1, 2, 3,}, 3)).isEqualTo(2);
        Assertions.assertThat(subarraySum(new int[]{-1, -1, 1}, 0)).isEqualTo(1);
    }

    public int subarraySum(int[] nums, int k) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length - i; j++) {
                sum += nums[i + j];
                if (sum == k) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

}
