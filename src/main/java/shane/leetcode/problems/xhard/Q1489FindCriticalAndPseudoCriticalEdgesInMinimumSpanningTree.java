package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Wrong
 */
public class Q1489FindCriticalAndPseudoCriticalEdgesInMinimumSpanningTree {

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

    int min;
    List<List<Edge>> routes = new ArrayList<>();

    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        min = Integer.MAX_VALUE;
        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(i);
            nodes.put(i, node);
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            Node node1 = nodes.get(edge[0]);
            Node node2 = nodes.get(edge[1]);
            Edge e = new Edge(i, node1, node2, edge[2]);
            node1.addEdge(e);
            node2.addEdge(e);
        }

        for (int i = 0; i < n; i++) {
            Node root = nodes.get(i);
            Set<Node> visited = new HashSet<>();
            visited.add(root);
            dfs(n, root, 0, visited, new ArrayList<>());
        }

        Map<Integer, Integer> cnt = new HashMap<>();
        routes.stream().flatMap(r -> r.stream())
                .map(e -> e.edgeIndex)
                .forEach(i -> cnt.merge(i, 1, Integer::sum));
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(new ArrayList<>());
        answer.add(new ArrayList<>());

        cnt.entrySet().stream()
                .forEach(e -> {
                    if (e.getValue() == routes.size()) {
                        answer.get(0).add(e.getKey());
                    } else {
                        answer.get(1).add(e.getKey());
                    }
                });
        return answer;
    }

    private void dfs(int size, Node cur, int curWeight, Set<Node> visited, List<Edge> route) {
        if (min < curWeight)
            return;

        if (visited.size() == size) {
            if (curWeight < min) {
                min = curWeight;
                routes.clear();
            }
            routes.add(new ArrayList(route));
            return;
        }

        for (Edge edge : cur.edges) {
            Node next = edge.getNext(cur);
            if (visited.contains(next)) {
                continue;
            }

            visited.add(next);
            route.add(edge);

            dfs(size, next, curWeight + edge.weight, visited, route);

            visited.remove(next);
            route.remove(route.size() - 1);
        }
    }

    class Node {
        int index;
        List<Edge> edges = new ArrayList<>();

        public Node(int index) {
            this.index = index;
        }

        public void addEdge(Edge edge) {
            edges.add(edge);
        }
    }

    class Edge {
        int edgeIndex;
        Node node1;
        Node node2;
        int weight;

        public Edge(int edgeIndex, Node node1, Node node2, int weight) {
            this.edgeIndex = edgeIndex;
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }

        public Node getNext(Node cur) {
            if (node1 == cur)
                return node2;
            return node1;
        }

        @Override
        public String toString() {
            return "Edge (" + edgeIndex + ") [" + node1.index + ", " + node2.index + "]";
        }
    }

}
