package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 25
 * ms
 * Beats
 * 84.13%
 */
public class Q416PartitionEqualSubsetSum {

    @Test
    public void test() {
        assertThat(canPartition(new int[]{1, 5, 11, 5})).isTrue();
        assertThat(canPartition(new int[]{1, 2, 3, 5})).isFalse();
    }

    @Test
    public void test2() {
        assertThat(canPartition(new int[]{1, 2, 5})).isFalse();
        assertThat(canPartition(new int[]{14, 9, 8, 4, 3, 2})).isTrue();
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1)
            return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            Set<Integer> visitThisTime = new HashSet<>();
            if (target < num)
                return false;
            for (int i = 0; i < dp.length; i++) {
                if (!dp[i])
                    continue;
                int next = i + num;
                if (target < next || dp[next] || visitThisTime.contains(i))
                    continue;
                if (next == target)
                    return true;
                visitThisTime.add(next);
                dp[next] = true;
            }
        }
        return false;
    }

}
