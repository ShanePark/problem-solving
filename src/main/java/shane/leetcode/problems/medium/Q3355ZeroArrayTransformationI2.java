package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 2
 * ms
 * Beats
 * 100.00%
 */
public class Q3355ZeroArrayTransformationI2 {

    @Test
    public void test() {
        assertThat(isZeroArray(new int[]{1, 0, 1}, Ps.intArray("[[0,2]]"))).isTrue();
        assertThat(isZeroArray(new int[]{4, 3, 2, 1}, Ps.intArray("[[1,3],[0,2]]"))).isFalse();
        assertThat(isZeroArray(new int[]{2}, Ps.intArray("[[0,0],[0,0]]"))).isTrue();
    }

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int[] prefixSum = new int[nums.length + 1];
        for (int[] query : queries) {
            prefixSum[query[0]] += -1;
            prefixSum[query[1] + 1] += 1;
        }
        int curStatus = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            curStatus += prefixSum[i];
            if (0 < num + curStatus) {
                return false;
            }
        }
        return true;
    }

}
