package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3578CountPartitionsWithMaxMinDifferenceAtMostK {

    @Test
    public void test() {
        assertThat(countPartitions(new int[]{9, 4, 1, 3, 7}, 4)).isEqualTo(6);
        assertThat(countPartitions(new int[]{3, 3, 4}, 0)).isEqualTo(2);
    }

    final int MOD = (int) 1e9 + 7;

    public int countPartitions(int[] nums, int k) {
        int[] dp = new int[nums.length + 1];
        int[] prefix = new int[nums.length + 1];
        TreeMap<Integer, Integer> cnt = new TreeMap<>();

        dp[0] = 1;
        prefix[0] = 1;
        for (int i = 0, j = 0; i < nums.length; i++) {
            cnt.merge(nums[i], 1, Integer::sum);
            while (j <= i && cnt.lastKey() - cnt.firstKey() > k) {
                if (cnt.merge(nums[j], -1, Integer::sum) == 0) {
                    cnt.remove(nums[j]);
                }
                j++;
            }
            dp[i + 1] = (prefix[i] - (j > 0 ? prefix[j - 1] : 0) + MOD) % MOD;
            prefix[i + 1] = (prefix[i] + dp[i + 1]) % MOD;
        }
        return dp[nums.length];
    }

}
