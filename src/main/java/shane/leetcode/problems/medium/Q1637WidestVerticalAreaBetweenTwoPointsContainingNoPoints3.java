package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * Runtime Details 38ms Beats 31.92%of users with Java
 * Memory Details 73.08MB Beats 5.00%of users with Java
 */
public class Q1637WidestVerticalAreaBetweenTwoPointsContainingNoPoints3 {

    @Test
    void test() {
        Assertions.assertThat(maxWidthOfVerticalArea(Ps.intArray("[[8,7],[9,9],[7,4],[9,7]]"))).isEqualTo(1);
        Assertions.assertThat(maxWidthOfVerticalArea(Ps.intArray("[[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]"))).isEqualTo(3);
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, (o1, o2) -> o1[0] - o2[0]);
        int before = points[0][0];
        int max = 0;
        for (int i = 1; i < points.length; i++) {
            int x = points[i][0];
            max = Math.max(max, x - before);
            before = x;
        }
        return max;
    }

}
