package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q3356ZeroArrayTransformationII {

    @Test
    public void test() {
        assertThat(minZeroArray(new int[]{2, 0, 2}, Ps.intArray("[[0,2,1],[0,2,1],[1,1,3]]"))).isEqualTo(2);
        assertThat(minZeroArray(new int[]{4, 3, 2, 1}, Ps.intArray("[[1,3,2],[0,2,1]]"))).isEqualTo(-1);
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        int queryIndex = 0;
        int cur = 0;
        int[] prefixSum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            for (; cur + prefixSum[i] < nums[i]; queryIndex++) {
                if (queryIndex == queries.length) return -1;
                if (queries[queryIndex][1] < i) continue;

                prefixSum[Math.max(queries[queryIndex][0], i)] += queries[queryIndex][2];
                prefixSum[queries[queryIndex][1] + 1] -= queries[queryIndex][2];
            }
            cur += prefixSum[i];
        }
        return queryIndex;
    }

}
