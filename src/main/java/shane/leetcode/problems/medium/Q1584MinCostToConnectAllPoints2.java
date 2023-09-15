package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 2637ms Beats 5.04%of users with Java
 * Memory Details 43.19MB Beats 94.71%of users with Java
 */
public class Q1584MinCostToConnectAllPoints2 {

    @Test
    public void test() {
        assertThat(minCostConnectPoints(Ps.intArray("[[0,0],[2,2],[3,10],[5,2],[7,0]]"))).isEqualTo(20);
        assertThat(minCostConnectPoints(Ps.intArray("[[3,12],[-2,5],[-4,1]]"))).isEqualTo(18);
    }

    public int minCostConnectPoints(int[][] points) {
        List<int[]> list = Arrays.stream(points).collect(Collectors.toList());
        int[] first = list.remove(0);
        List<int[]> included = new ArrayList<>();
        included.add(first);

        int answer = 0;

        while (!list.isEmpty()) {
            int minDistance = Integer.MAX_VALUE;
            int[] candidate = null;

            for (int[] p1 : included) {
                for (int[] p2 : list) {
                    int distance = getDistance(p1, p2);
                    if (candidate == null || distance < minDistance) {
                        candidate = p2;
                        minDistance = distance;
                    }
                }
            }
            list.remove(candidate);
            included.add(candidate);
            answer += minDistance;
        }
        return answer;
    }

    private int getDistance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

}
