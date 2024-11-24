package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 5msBeats97.24%
 */
public class Q1975MaximumMatrixSum {

    @Test
    public void test() {
        assertThat(maxMatrixSum(Ps.intArray("[[1,-1],[-1,1]]"))).isEqualTo(4);
        assertThat(maxMatrixSum(Ps.intArray("[[1,2,3],[-1,-2,-3],[1,2,3]]"))).isEqualTo(16);
        assertThat(maxMatrixSum(Ps.intArray("[[2,9,3],[5,4,-4],[1,7,1]]"))).isEqualTo(34);
    }

    public long maxMatrixSum(int[][] matrix) {
        int minusCnt = 0;
        boolean hasZero = false;
        long plusSum = 0;
        int min = Integer.MAX_VALUE;
        for (int[] ints : matrix) {
            for (int i : ints) {
                if (i < 0) {
                    minusCnt++;
                    i = -i;
                }
                if (i == 0)
                    hasZero = true;
                min = Math.min(min, i);
                plusSum += i;
            }
        }
        if (!hasZero && minusCnt % 2 == 1) {
            plusSum -= min * 2L;
        }
        return plusSum;
    }

}
