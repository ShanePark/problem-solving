package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Not my solution
 */
public class Q2493DivideNodesIntoTheMaximumNumberOfGroups {

    @Test
    public void test() {
        assertThat(magnificentSets(6, Ps.intArray("[[1,2],[1,4],[1,5],[2,6],[2,3],[4,6]]"))).isEqualTo(4);
        assertThat(magnificentSets(3, Ps.intArray("[[1,2],[2,3],[3,1]]"))).isEqualTo(-1);
        assertThat(magnificentSets(92, Ps.intArray("[[67,29],[13,29],[77,29],[36,29],[82,29],[54,29],[57,29],[53,29],[68,29],[26,29],[21,29],[46,29],[41,29],[45,29],[56,29],[88,29],[2,29],[7,29],[5,29],[16,29],[37,29],[50,29],[79,29],[91,29],[48,29],[87,29],[25,29],[80,29],[71,29],[9,29],[78,29],[33,29],[4,29],[44,29],[72,29],[65,29],[61,29]]"))).isEqualTo(57);
    }

    public int magnificentSets(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0] - 1).add(edge[1] - 1);
            graph.get(edge[1] - 1).add(edge[0] - 1);
        }

        int[] colors = new int[n];
        Arrays.fill(colors, -1);
        for (int node = 0; node < n; node++) {
            if (colors[node] != -1) continue;
            colors[node] = 0;
            if (isNotBipartite(graph, node, colors))
                return -1;
        }

        int[] distances = new int[n];
        for (int node = 0; node < n; node++) {
            distances[node] = getLongestShortestPath(graph, node, n);
        }

        int maxNumberOfGroups = 0;
        boolean[] visited = new boolean[n];
        for (int node = 0; node < n; node++) {
            if (visited[node]) continue;
            maxNumberOfGroups += getNumberOfGroupsForComponent(graph, node, distances, visited);
        }

        return maxNumberOfGroups;
    }

    private boolean isNotBipartite(List<List<Integer>> adjList, int node, int[] colors) {
        for (int next : adjList.get(node)) {
            if (colors[next] == colors[node])
                return true;
            if (colors[next] != -1)
                continue;
            colors[next] = (colors[node] + 1) % 2;
            if (isNotBipartite(adjList, next, colors))
                return true;
        }
        return false;
    }

    private int getLongestShortestPath(List<List<Integer>> adjList, int node, int n) {
        Queue<Integer> nodesQueue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        nodesQueue.add(node);
        visited[node] = true;
        int distance = 0;

        while (!nodesQueue.isEmpty()) {
            int numOfNodesInLayer = nodesQueue.size();
            for (int i = 0; i < numOfNodesInLayer; i++) {
                int currentNode = nodesQueue.poll();

                for (int neighbor : adjList.get(currentNode)) {
                    if (visited[neighbor]) continue;
                    visited[neighbor] = true;
                    nodesQueue.add(neighbor);
                }
            }
            distance++;
        }
        return distance;
    }

    private int getNumberOfGroupsForComponent(List<List<Integer>> adjList, int node, int[] distances, boolean[] visited) {
        int maxNumberOfGroups = distances[node];
        visited[node] = true;

        for (int neighbor : adjList.get(node)) {
            if (visited[neighbor]) continue;
            maxNumberOfGroups = Math.max(maxNumberOfGroups, getNumberOfGroupsForComponent(adjList, neighbor, distances, visited));
        }
        return maxNumberOfGroups;
    }

}
