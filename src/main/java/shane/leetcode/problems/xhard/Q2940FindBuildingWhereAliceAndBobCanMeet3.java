package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my idea
 */
public class Q2940FindBuildingWhereAliceAndBobCanMeet3 {

    @Test
    public void test() {
        assertThat(leftmostBuildingQueries(new int[]{3, 5, 1, 2, 4}, Ps.intArray("[[0,0],[0,1],[0,2],[0,3],[0,4],[1,0],[1,1],[1,2],[1,3],[1,4],[2,0],[2,1],[2,2],[2,3],[2,4],[3,0],[3,1],[3,2],[3,3],[3,4],[4,0],[4,1],[4,2],[4,3],[4,4]]")))
                .isEqualTo(new int[]{0, 1, 4, 4, 4, 1, 1, -1, -1, -1, 4, -1, 2, 3, 4, 4, -1, 3, 3, 4, 4, -1, 4, 4, 4});
        assertThat(leftmostBuildingQueries(new int[]{3, 4, 1, 2}, Ps.intArray("[[0,0],[0,1],[0,2],[0,3],[1,0],[1,1],[1,2],[1,3],[2,0],[2,1],[2,2],[2,3],[3,0],[3,1],[3,2],[3,3]]")))
                .isEqualTo(new int[]{0, 1, -1, -1, 1, 1, -1, -1, -1, -1, 2, 3, -1, -1, 3, 3});
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

    @Test
    public void tle3() {
        int[] heights = new int[50000];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = i - 1;
        }
        heights[0] = 50000;
        heights[1] = 50001;
        heights[heights.length - 1] = 50001;
        int[][] queries = new int[50000][2];
        for (int i = 0; i < queries.length; i++) {
            queries[i] = new int[]{0, i};
        }
        assertThat(leftmostBuildingQueries(heights, queries)).isNotNull();
    }

    public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
        int[] answer = new int[queries.length];
        Arrays.fill(answer, -1);

        List<Query> queryList = new ArrayList<>();
        for (int k = 0; k < queries.length; k++) {
            int i = queries[k][0];
            int j = queries[k][1];
            if (i < j && heights[i] < heights[j]) {
                answer[k] = j;
                continue;
            }
            if (i > j && heights[i] > heights[j]) {
                answer[k] = i;
                continue;
            }
            if (i == j) {
                answer[k] = i;
                continue;
            }
            queryList.add(new Query(Math.max(heights[i], heights[j]), k, Math.max(i, j)));
        }

        queryList.sort(Comparator.comparingInt(q -> q.targetIndex));

        int queryIndex = 0;
        PriorityQueue<Query> pq = new PriorityQueue<>(Comparator.comparingInt(q -> q.maxHeight));
        for (int i = 0; i < heights.length; i++) {
            while (!pq.isEmpty() && pq.peek().maxHeight < heights[i]) {
                answer[pq.poll().queryIndex] = i;
            }
            while (queryIndex < queryList.size() && queryList.get(queryIndex).targetIndex == i) {
                pq.add(queryList.get(queryIndex));
                queryIndex++;
            }
        }
        return answer;
    }

    static class Query {
        int maxHeight;
        int queryIndex;
        int targetIndex;

        public Query(int maxHeight, int queryIndex, int targetIndex) {
            this.maxHeight = maxHeight;
            this.queryIndex = queryIndex;
            this.targetIndex = targetIndex;
        }
    }

}
