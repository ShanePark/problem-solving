package shane.leetcode.contest.weekly.w285;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Runtime
 * 0
 * ms
 * Beats
 * 100.00%
 */
public class Q2210CountHillsAndValleysInAnArray2 {

    @Test
    void test() {
        Assertions.assertThat(countHillValley(new int[]{2, 4, 1, 1, 6, 5})).isEqualTo(3);
        Assertions.assertThat(countHillValley(new int[]{6, 6, 5, 5, 4, 1})).isEqualTo(0);
        Assertions.assertThat(countHillValley(new int[]{1, 1, 1})).isEqualTo(0);
        Assertions.assertThat(countHillValley(new int[]{1, 1, 2, 1})).isEqualTo(1);
    }

    public int countHillValley(int[] nums) {
        int way = nums[1] - nums[0];
        int answer = 0;
        for (int i = 1; i < nums.length; i++) {
            int nextWay = nums[i] - nums[i - 1];
            if (nextWay == 0)
                continue;
            if (way == 0) {
                way = nextWay;
                continue;
            }
            if (way * nextWay > 0)
                continue;
            way = nextWay;
            answer++;
        }
        return answer;
    }

}
