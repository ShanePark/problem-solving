package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class Q1637WidestVerticalAreaBetweenTwoPointsContainingNoPoints {

    @Test
    void test() {
        Assertions.assertThat(maxWidthOfVerticalArea(Ps.intArray("[[8,7],[9,9],[7,4],[9,7]]"))).isEqualTo(1);
        Assertions.assertThat(maxWidthOfVerticalArea(Ps.intArray("[[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]"))).isEqualTo(3);
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int[] point : points) {
            q.offer(point[0]);
        }
        int maxGap = 0;
        int before = q.poll();
        while (!q.isEmpty()) {
            Integer poll = q.poll();
            maxGap = Math.max(maxGap, poll - before);
            before = poll;
        }
        return maxGap;
    }

}
