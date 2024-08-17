package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class Q7MaximumNumberOfPointsWithCost2 {

    @Test
    public void test() {
        assertThat(maxPoints(Ps.intArray("[[1,2,3],[1,5,1],[3,1,1]]"))).isEqualTo(9L);
        assertThat(maxPoints(Ps.intArray("[[1,5],[2,3],[4,2]]"))).isEqualTo(11L);
    }

    @Test
    public void tle() {
        int[][] arr = new int[1000][1000];
        assertThat(maxPoints(arr)).isEqualTo(0);
    }

    public long maxPoints(int[][] points) {
        long[] prev = new long[points[0].length];
        for (int i = 0; i < points[0].length; i++) {
            prev[i] = points[0][i];
        }

        for (int i = 1; i < points.length; i++) {
            long[] next = new long[points[0].length];
            long[] left = new long[points[0].length];
            long[] right = new long[points[0].length];

            left[0] = prev[0];
            for (int j = 1; j < points[0].length; j++) {
                left[j] = Math.max(left[j - 1], prev[j] + j);
            }

            right[points[0].length - 1] = prev[points[0].length - 1] - (points[0].length - 1);
            for (int j = points[0].length - 2; j >= 0; j--) {
                right[j] = Math.max(right[j + 1], prev[j] - j);
            }

            for (int j = 0; j < points[0].length; j++) {
                next[j] = points[i][j] + Math.max(left[j] - j, right[j] + j);
            }
            prev = next;
        }

        return Arrays.stream(prev).max().getAsLong();
    }

}
