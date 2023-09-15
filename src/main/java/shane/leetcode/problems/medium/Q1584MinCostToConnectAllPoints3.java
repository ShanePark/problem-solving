package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1584MinCostToConnectAllPoints3 {

    @Test
    public void test() {
        assertThat(minCostConnectPoints(Ps.intArray("[[2,-3],[-17,-8],[13,8],[-17,-15]]"))).isEqualTo(53);
        assertThat(minCostConnectPoints(Ps.intArray("[[0,0],[2,2],[3,10],[5,2],[7,0]]"))).isEqualTo(20);
        assertThat(minCostConnectPoints(Ps.intArray("[[3,12],[-2,5],[-4,1]]"))).isEqualTo(18);
    }

    public int minCostConnectPoints(int[][] points) {
        final int LENGTH = points.length;
        int total = 0;
        HashSet<Integer> visited = new HashSet<>();
        visited.add(0);
        int[] distance = new int[LENGTH];
        for (int i = 1; i < LENGTH; i++) {
            distance[i] = distance(points[0], points[i]);
        }
        while (visited.size() < LENGTH) {
            int next = 0;
            for (int i = 1; i < LENGTH; i++) {
                if (visited.contains(i))
                    continue;
                if (next == 0 || distance[i] < distance[next]) {
                    next = i;
                }
            }
            visited.add(next);
            total += distance[next];
            for (int i = 1; i < LENGTH; i++) {
                if (visited.contains(i)) {
                    continue;
                }
                distance[i] = Math.min(distance[i], distance(points[i], points[next]));
            }
        }
        return total;
    }

    private int distance(int[] p1, int[] p2) {
        return Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
    }

}
