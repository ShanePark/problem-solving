package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime2175msBeats5.29%
 */
public class Q7MaximumNumberOfPointsWithCost {

    @Test
    public void test() {
        assertThat(maxPoints(Ps.intArray("[[1,2,3],[1,5,1],[3,1,1]]"))).isEqualTo(9L);
        assertThat(maxPoints(Ps.intArray("[[1,5],[2,3],[4,2]]"))).isEqualTo(11L);
    }

    public long maxPoints(int[][] points) {
        long[] prev = new long[points[0].length];
        for (int i = 0; i < prev.length; i++) {
            prev[i] = points[0][i];
        }
        for (int i = 1; i < points.length; i++) {
            long[] next = new long[prev.length];
            for (int j = 0; j < points[0].length; j++) {
                int cur = points[i][j];
                long max = 0;
                for (int k = 0; k < prev.length; k++) {
                    max = Math.max(max, prev[k] - Math.abs(j - k));
                }
                next[j] = cur + max;
            }
            prev = next;
        }
        return Arrays.stream(prev).max().getAsLong();
    }

}
