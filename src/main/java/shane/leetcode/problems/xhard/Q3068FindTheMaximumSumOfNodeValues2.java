package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3068FindTheMaximumSumOfNodeValues2 {

    @Test
    public void test() {
        assertThat(maximumValueSum(new int[]{24, 78, 1, 97, 44}, 6, Ps.intArray("[[0,2],[1,2],[4,2],[3,4]]"))).isEqualTo(260);
        assertThat(maximumValueSum(new int[]{1, 2, 1}, 3, Ps.intArray("[[0,1],[0,2]]"))).isEqualTo(6);
        assertThat(maximumValueSum(new int[]{2, 3}, 7, Ps.intArray("[[0,1]]"))).isEqualTo(9);
        assertThat(maximumValueSum(new int[]{7, 7, 7, 7, 7, 7}, 3, Ps.intArray("[[0,1],[0,2],[0,3],[0,4],[0,5]]"))).isEqualTo(42);
    }

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long sum = 0;
        int xorMinDiff = Integer.MAX_VALUE;
        int xorCnt = 0;
        for (int num : nums) {
            int xor = num ^ k;
            if (xor <= num) {
                sum += num;
                xorMinDiff = Math.min(xorMinDiff, num - xor);
                continue;
            }
            sum += xor;
            xorCnt++;
            xorMinDiff = Math.min(xorMinDiff, xor - num);
        }
        if (xorCnt % 2 == 0)
            return sum;
        return sum - xorMinDiff;
    }

}
