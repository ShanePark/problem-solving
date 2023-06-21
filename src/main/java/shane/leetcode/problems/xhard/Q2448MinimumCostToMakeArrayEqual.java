package shane.leetcode.problems.xhard;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 21 ms Beats 50.77%
 * Memory 55.3 MB Beats 69.23%
 */
public class Q2448MinimumCostToMakeArrayEqual {

    @Test
    public void test() {
        assertThat(minCost(new int[]{735103, 366367, 132236, 133334, 808160, 113001, 49051, 735598, 686615, 665317, 999793, 426087, 587000, 649989, 509946, 743518},
                new int[]{724182, 447415, 723725, 902336, 600863, 287644, 13836, 665183, 448859, 917248, 397790, 898215, 790754, 320604, 468575, 825614}))
                .isEqualTo(1907611126748L);
        assertThat(minCost(new int[]{1, 3, 5, 2}, new int[]{2, 3, 1, 14})).isEqualTo(8);
        assertThat(minCost(new int[]{2, 2, 2, 2, 2}, new int[]{4, 2, 8, 1, 3})).isEqualTo(0);
    }

    public long minCost(int[] nums, int[] cost) {
        int left = 1;
        int right = 1_000_000;
        Long[] memo = new Long[1_000_001];

        while (left < right) {
            int mid = left + (right - left) / 2;
            long cost1 = getTotalCost(nums, cost, memo, mid);
            long cost2 = getTotalCost(nums, cost, memo, mid + 1);
            if (cost1 < cost2) {
                right = mid;
                continue;
            }
            left = mid + 1;
        }
        return memo[left];
    }

    private long getTotalCost(int[] nums, int[] cost, Long[] memo, int index) {
        if (memo[index] == null) {
            long sum = 0;
            for (int i = 0; i < nums.length; i++) {
                sum += (long) Math.abs(nums[i] - index) * cost[i];
            }
            memo[index] = sum;
        }
        return memo[index];
    }

}
