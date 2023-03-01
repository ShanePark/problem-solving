package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 147 ms Beats 14.41%
 * Memory 100.7 MB Beats 16.47%
 */
public class Q452MinimumNumberOfArrowsToBurstBalloons4 {

    @Test
    public void test() {
        assertThat(findMinArrowShots(Ps.intArray("[[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]")))
                .isEqualTo(2);
        assertThat(findMinArrowShots(Ps.intArray("[[10,16],[2,8],[1,6],[7,12]]"))).isEqualTo(2);
        assertThat(findMinArrowShots(Ps.intArray("[[1,2],[3,4],[5,6],[7,8]]"))).isEqualTo(4);
        assertThat(findMinArrowShots(Ps.intArray("[[1,2],[2,3],[3,4],[4,5]]"))).isEqualTo(2);
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));

        int cnt = 0;
        for (int i = 0; i < points.length; i++) {
            int[] poll = points[i];
            int max = poll[1];
            while (i < points.length - 1 && points[i + 1][0] <= max && max <= points[i + 1][1]) {
                int[] p = points[++i];
                max = Math.min(max, p[1]);
            }
            cnt++;
        }
        return cnt;
    }

}
