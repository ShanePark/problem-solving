package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 61 ms Beats 18.90% of users with Java
 */
public class Q452MinimumNumberOfArrowsToBurstBalloons6 {

    @Test
    public void test() {
        assertThat(findMinArrowShots(Ps.intArray("[[3,9],[7,12],[3,8],[6,8],[9,10],[2,9],[0,9],[3,9],[0,6],[2,8]]")))
                .isEqualTo(2);
        assertThat(findMinArrowShots(Ps.intArray("[[10,16],[2,8],[1,6],[7,12]]"))).isEqualTo(2);
        assertThat(findMinArrowShots(Ps.intArray("[[1,2],[3,4],[5,6],[7,8]]"))).isEqualTo(4);
        assertThat(findMinArrowShots(Ps.intArray("[[1,2],[2,3],[3,4],[4,5]]"))).isEqualTo(2);
        assertThat(findMinArrowShots(Ps.intArray("[[-2147483648,2147483647]]"))).isEqualTo(1);
    }

    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(arr -> arr[0]));
        Integer max = null;
        int cnt = 0;
        for (int[] point : points) {
            if (max == null || max < point[0]) {
                cnt++;
                max = point[1];
                continue;
            }
            max = Math.min(max, point[1]);
        }
        return cnt;
    }

}
