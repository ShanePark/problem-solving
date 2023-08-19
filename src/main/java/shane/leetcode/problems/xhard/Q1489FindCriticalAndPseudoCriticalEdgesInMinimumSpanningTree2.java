package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1489FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree2 {

    @Test
    public void test() {
        assertThat(findCriticalAndPseudoCriticalEdges(5, Ps.intArray("[[0,1,1],[1,2,1],[2,3,2],[0,3,2],[0,4,3],[3,4,3],[1,4,6]]")))
                .isEqualTo(Ps.intList("[[0,1],[2,3,4,5]]"));
        assertThat(findCriticalAndPseudoCriticalEdges(4, Ps.intArray("[[0,1,1],[1,2,1],[2,3,1],[0,3,1]]")))
                .isEqualTo(Ps.intList("[[],[0,1,2,3]]"));
    }

    @Test
    public void wrong() {
        assertThat(findCriticalAndPseudoCriticalEdges(6, Ps.intArray("[[0,1,1],[1,2,1],[0,2,1],[2,3,4],[3,4,2],[3,5,2],[4,5,2]]")))
                .isEqualTo(Ps.intList("[[3],[0,1,2,4,5,6]]"));
    }

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edgesArr) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < edgesArr.length; i++) {
            edges.add(new Edge(i, edgesArr[i][0], edgesArr[i][1], edgesArr[i][2]));
        }
        Collections.sort(edges, Comparator.comparingInt(e -> e.weight));

        int baseValue = kruskal(n, edges, -1, -1);

        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());

        for (int i = 0; i < edges.size(); i++) {
            if (kruskal(n, edges, i, -1) > baseValue) {
                result.get(0).add(edges.get(i).edgeIndex);
                continue;
            }
            if (kruskal(n, edges, -1, i) == baseValue) {
                result.get(1).add(edges.get(i).edgeIndex);
            }
        }

        return result;
    }

    class Edge {
        int edgeIndex;
        int node1;
        int node2;
        int weight;

        public Edge(int edgeIndex, int node1, int node2, int weight) {
            this.edgeIndex = edgeIndex;
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }

    }

    class UnionFind {
        int[] parent;
        int count;

        UnionFind(int n) {
            parent = new int[n];
            count = n;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) return false;
            parent[rootX] = rootY;
            count--;
            return true;
        }

    }

    private int kruskal(int n, List<Edge> edges, int exclude, int include) {
        UnionFind uf = new UnionFind(n);
        int weight = 0;
        if (include >= 0) {
            uf.union(edges.get(include).node1, edges.get(include).node2);
            weight += edges.get(include).weight;
        }
        for (int i = 0; i < edges.size(); i++) {
            if (i == exclude || i == include) continue;
            Edge edge = edges.get(i);
            if (uf.union(edge.node1, edge.node2)) {
                weight += edge.weight;
            }
        }
        if (uf.count != 1) return Integer.MAX_VALUE; // Not connected
        return weight;
    }

}
