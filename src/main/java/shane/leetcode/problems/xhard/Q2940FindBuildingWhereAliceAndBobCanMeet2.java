package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q2940FindBuildingWhereAliceAndBobCanMeet2 {

    @Test
    public void test() {
        assertThat(leftmostBuildingQueries(new int[]{6, 4, 8, 5, 2, 7}, new int[][]{{0, 1}, {0, 3}, {2, 4}, {3, 4}, {2, 2}})).isEqualTo(new int[]{2, 5, -1, 5, 2});
        assertThat(leftmostBuildingQueries(new int[]{5, 3, 8, 2, 6, 1, 4, 6}, new int[][]{{0, 7}, {3, 5}, {5, 2}, {3, 0}, {1, 6}})).isEqualTo(new int[]{7, 6, -1, 4, 6});
        assertThat(leftmostBuildingQueries(new int[]{1, 2, 1, 2, 1, 2},
                Ps.intArray("[[0,0],[0,1],[0,2],[0,3],[0,4],[0,5],[1,0],[1,1],[1,2],[1,3],[1,4],[1,5],[2,0],[2,1],[2,2],[2,3],[2,4],[2,5],[3,0],[3,1],[3,2],[3,3],[3,4],[3,5],[4,0],[4,1],[4,2],[4,3],[4,4],[4,5],[5,0],[5,1],[5,2],[5,3],[5,4],[5,5]]")))
                .isEqualTo(new int[]{0, 1, 3, 3, 5, 5, 1, 1, -1, -1, -1, -1, 3, -1, 2, 3, 5, 5, 3, -1, 3, 3, -1, -1, 5, -1, 5, -1, 4, 5, 5, -1, 5, -1, 5, 5});
    }

    @Test
    public void tle1() {
        int[] heights = new int[50000];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = i;
        }
        heights[0] = 50000;
        int[][] queries = new int[50000][2];
        Arrays.fill(queries, new int[]{0, 1});
        assertThat(leftmostBuildingQueries(heights, queries)).isNotNull();
    }

    @Test
    public void tle2() {
        int[] heights = new int[50000];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = i;
        }
        heights[0] = 50000;
        heights[heights.length - 1] = 50001;
        int[][] queries = new int[50000][2];
        Arrays.fill(queries, new int[]{0, 1});
        assertThat(leftmostBuildingQueries(heights, queries)).isNotNull();
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int LENGTH = heights.length;
        int[] next = new int[LENGTH];
        next[LENGTH - 1] = -1;
        Stack<int[]> stack = new Stack<>(); // { index, val} }
        stack.add(new int[]{LENGTH - 1, heights[LENGTH - 1]});
        for (int i = LENGTH - 2; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[1] <= heights[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                next[i] = -1;
            } else {
                next[i] = stack.peek()[0];
            }
            stack.push(new int[]{i, heights[i]});
        }
        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            answer[i] = leftMost(heights, next, Math.min(q[0], q[1]), Math.max(q[0], q[1]));
        }
        return answer;
    }

    private int leftMost(int[] heights, int[] next, int i, int j) {
        if (i == -1 || j == -1)
            return -1;
        if (i == j)
            return i;
        if (next[i] == -1)
            return -1;
        if (heights[i] < heights[j])
            return j;
        if (next[i] < next[j]) {
            return leftMost(heights, next, i, next[j]);
        }
        return leftMost(heights, next, Math.min(next[i], j), Math.max(next[i], j));
    }

}
