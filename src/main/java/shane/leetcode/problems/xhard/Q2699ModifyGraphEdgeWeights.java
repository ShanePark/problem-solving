package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q2699ModifyGraphEdgeWeights {

    @Test
    public void test() {
        assertThat(modifiedGraphEdges(5, Ps.intArray("[[4,1,-1],[2,0,-1],[0,3,-1],[4,3,-1]]"), 0, 1, 5)).isEqualTo(Ps.intArray("[[4,1,1],[2,0,1],[0,3,1],[4,3,3]]"));
        assertThat(modifiedGraphEdges(3, Ps.intArray("[[0,1,-1],[0,2,5]]"), 0, 2, 6)).isEqualTo(Ps.intArray("[]"));
        assertThat(modifiedGraphEdges(4, Ps.intArray("[[1,0,4],[1,2,3],[2,3,5],[0,3,-1]]"), 0, 2, 6)).isEqualTo(Ps.intArray("[[1,0,4],[1,2,3],[2,3,5],[0,3,1]]"));
        assertThat(modifiedGraphEdges(5, Ps.intArray("[[1,4,1],[2,4,-1],[3,0,2],[0,4,-1],[1,3,10],[1,0,10]]"), 0, 2, 15)).isEqualTo(Ps.intArray("[[1,4,1],[2,4,4],[3,0,2],[0,4,2000000000],[1,3,10],[1,0,10]]"));
    }

    final int INF = (int) 2e9;

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        long currentShortestDistance = dijkstra(edges, n, source, destination);

        if (currentShortestDistance < target)
            return new int[][]{};

        boolean match = currentShortestDistance == target;

        for (int[] edge : edges) {
            if (0 < edge[2])
                continue;

            edge[2] = match ? INF : 1;

            if (!match) {
                long newDistance = dijkstra(edges, n, source, destination);
                if (newDistance <= target) {
                    match = true;
                    edge[2] += (int) (target - newDistance);
                }
            }
        }

        return match ? edges : new int[0][0];
    }

    private long dijkstra(int[][] edges, int n, int source, int destination) {
        long[][] adjMatrix = new long[n][n];
        long[] minDistance = new long[n];
        boolean[] visited = new boolean[n];

        Arrays.fill(minDistance, INF);
        for (long[] row : adjMatrix) {
            Arrays.fill(row, INF);
        }

        minDistance[source] = 0;

        for (int[] edge : edges) {
            if (edge[2] != -1) {
                adjMatrix[edge[0]][edge[1]] = edge[2];
                adjMatrix[edge[1]][edge[0]] = edge[2];
            }
        }

        for (int i = 0; i < n; ++i) {
            int nearestUnvisitedNode = -1;
            for (int j = 0; j < n; ++j) {
                if (!visited[j] && (nearestUnvisitedNode == -1 || minDistance[j] < minDistance[nearestUnvisitedNode])) {
                    nearestUnvisitedNode = j;
                }
            }
            visited[nearestUnvisitedNode] = true;

            for (int v = 0; v < n; ++v) {
                minDistance[v] = Math.min(minDistance[v], minDistance[nearestUnvisitedNode] + adjMatrix[nearestUnvisitedNode][v]);
            }
        }

        return minDistance[destination];
    }

}
