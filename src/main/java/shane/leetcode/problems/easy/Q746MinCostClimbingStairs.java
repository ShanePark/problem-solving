package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q746MinCostClimbingStairs {

    @Test
    public void test() {
        assertThat(minCostClimbingStairs(new int[]{10, 20})).isEqualTo(10);
        assertThat(minCostClimbingStairs(new int[]{10, 15, 20})).isEqualTo(15);
        assertThat(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1})).isEqualTo(6);
    }

    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        for (int i = 2; i < length; i++) {
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return Math.min(cost[length - 1], cost[length - 2]);
    }
}
