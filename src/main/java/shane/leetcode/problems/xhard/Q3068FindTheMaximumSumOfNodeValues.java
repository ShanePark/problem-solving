package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3068FindTheMaximumSumOfNodeValues {

    @Test
    public void test() {
        assertThat(maximumValueSum(new int[]{24, 78, 1, 97, 44}, 6, Ps.intArray("[[0,2],[1,2],[4,2],[3,4]]"))).isEqualTo(260);
        assertThat(maximumValueSum(new int[]{78, 43, 92, 97, 95, 94}, 6, Ps.intArray("[[1,2],[3,0],[4,0],[0,1],[1,5]]"))).isEqualTo(507);
        assertThat(maximumValueSum(new int[]{2, 3}, 7, Ps.intArray("[[0,1]]"))).isEqualTo(9);
        assertThat(maximumValueSum(new int[]{1, 2, 1}, 3, Ps.intArray("[[0,1],[0,2]]"))).isEqualTo(6);
        assertThat(maximumValueSum(new int[]{7, 7, 7, 7, 7, 7}, 3, Ps.intArray("[[0,1],[0,2],[0,3],[0,4],[0,5]]"))).isEqualTo(42);
    }

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long answer = 0;
        int minDiff = Integer.MAX_VALUE;
        boolean flag = false;
        for (int val : nums) {
            int xor = val ^ k;
            answer += Math.max(val, xor);
            flag ^= val < xor;
            int diff = Math.abs(val - xor);
            minDiff = Math.min(minDiff, diff);
        }
        if (flag) {
            answer -= minDiff;
        }
        return answer;
    }

}
