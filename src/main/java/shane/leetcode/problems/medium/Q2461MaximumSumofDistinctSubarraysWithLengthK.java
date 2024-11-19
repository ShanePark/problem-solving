package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 42ms Beats60.90%
 */
public class Q2461MaximumSumofDistinctSubarraysWithLengthK {

    @Test
    public void test() {
        assertThat(maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3)).isEqualTo(15);
        assertThat(maximumSubarraySum(new int[]{4, 4, 4}, 3)).isEqualTo(0);
    }

    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> cntMap = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < k; i++) {
            int num = nums[i];
            sum += num;
            cntMap.merge(num, 1, Integer::sum);
        }

        long max = cntMap.size() == k ? sum : 0;

        for (int i = k; i < nums.length; i++) {
            int num = nums[i];

            sum += num;
            cntMap.merge(num, 1, Integer::sum);

            int removeTarget = nums[i - k];
            Integer newCnt = cntMap.merge(removeTarget, -1, Integer::sum);
            if (newCnt == 0)
                cntMap.remove(removeTarget);
            sum -= removeTarget;

            if (cntMap.size() == k) {
                max = Math.max(max, sum);
            }
        }
        return max;
    }

}
