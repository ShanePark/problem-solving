package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Comparator;
import java.util.PriorityQueue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 18 ms Beats 74.08% of users with Java
 */
public class Q1642FurthestBuildingYouCanReach4 {

    @Test
    public void test() throws IOException {
        assertThat(furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1)).isEqualTo(4);
        assertThat(furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2)).isEqualTo(7);
        assertThat(furthestBuilding(new int[]{14, 3, 19, 3}, 17, 0)).isEqualTo(3);
    }


    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < heights.length - 1; i++) {
            int diff = heights[i + 1] - heights[i];
            if (diff <= 0)
                continue;
            bricks -= diff;
            pq.offer(diff);
            if (0 <= bricks) {
                continue;
            }
            if (ladders == 0)
                return i;
            bricks += pq.poll();
            ladders--;
        }
        return heights.length - 1;
    }

}
