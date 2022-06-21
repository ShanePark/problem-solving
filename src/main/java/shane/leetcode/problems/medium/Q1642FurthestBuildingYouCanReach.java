package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1642FurthestBuildingYouCanReach {

    @Test
    public void test() {
        assertThat(furthestBuilding(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1)).isEqualTo(4);
        assertThat(furthestBuilding(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2)).isEqualTo(7);
    }


    int max = 0;

    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        dfs(heights, bricks, ladders, 1);
        return max;
    }

    private void dfs(int[] heights, int bricks, int ladders, int i) {
        if (i == heights.length)
            return;

        int diff = heights[i] - heights[i - 1];

        if (diff <= 0) {
            max = Math.max(max, i);
            dfs(heights, bricks, ladders, i + 1);
            return;
        }

        if (diff <= bricks) {
            max = Math.max(max, i);
            dfs(heights, bricks - diff, ladders, i + 1);
        }
        if (ladders > 0) {
            max = Math.max(max, i);
            dfs(heights, bricks, ladders - 1, i + 1);
        }
    }

}
