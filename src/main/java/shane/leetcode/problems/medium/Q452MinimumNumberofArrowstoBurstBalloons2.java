package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Assertions;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Runtime: 132 ms, faster than 9.31% of Java online submissions for Minimum Number of Arrows to Burst Balloons.
 * Memory Usage: 116.8 MB, less than 7.78% of Java online submissions for Minimum Number of Arrows to Burst Balloons.
 */
public class Q452MinimumNumberofArrowstoBurstBalloons2 {

    public static void main(String[] args) {
        Assertions.assertEquals(2, findMinArrowShots(Ps.intArray("[[10,16],[2,8],[1,6],[7,12]]")));
        Assertions.assertEquals(4, findMinArrowShots(Ps.intArray("[[1,2],[3,4],[5,6],[7,8]]")));
        Assertions.assertEquals(2, findMinArrowShots(Ps.intArray("[[1,2],[2,3],[3,4],[4,5]]")));
    }

    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        int end = points[0][1];

        int sum = 0;
        for (int i = 1; i < points.length; i++) {
            if (end < points[i][0]) {
                sum++;
                end = points[i][1];
            }
        }

        return sum+1;
    }

}
