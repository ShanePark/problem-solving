package shane.leetcode.contest.weekly.w285;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2210CountHillsAndValleysInAnArray {

    @Test
    void test() {
        Assertions.assertThat(countHillValley(new int[]{2, 4, 1, 1, 6, 5})).isEqualTo(3);
        Assertions.assertThat(countHillValley(new int[]{6, 6, 5, 5, 4, 1})).isEqualTo(0);
    }

    public int countHillValley(int[] nums) {
        int cnt = 0;
        String status = null;
        Integer before = nums[0];

        for (int num : nums) {
            if (before < num) {
                if (status != null && "DOWN".equals(status)) {
                    cnt++;
                }
                status = "UP";
            } else if (before > num) {
                if (status != null && "UP".equals(status)) {
                    cnt++;
                }
                status = "DOWN";
            }
            before = num;
        }

        return cnt;

    }

}
