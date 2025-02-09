package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 39
 * ms
 * Beats
 * 58.24%
 */
public class Q2364CountNumberOfBadPairs {

    @Test
    public void test() {
        assertThat(countBadPairs(new int[]{4, 1, 3, 3})).isEqualTo(5);
        assertThat(countBadPairs(new int[]{1, 2, 3, 4, 5})).isEqualTo(0);
        assertThat(countBadPairs(new int[]{0})).isEqualTo(0);
    }

    public long countBadPairs(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        long goodCnt = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i] - i;
            goodCnt += cnt.getOrDefault(num, 0);
            cnt.merge(num, 1, Integer::sum);
        }
        return (long) nums.length * (nums.length - 1) / 2 - goodCnt;
    }

}
