package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 78 ms Beats 67.95%
 * Memory 80.6 MB Beats 61.33%
 */
public class Q452MinimumNumberOfArrowsToBurstBalloons5 {

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

        int cnt = 1;
        int x = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (x >= points[i][0])
                continue;
            cnt++;
            x = points[i][1];
        }
        return cnt;
    }

}
