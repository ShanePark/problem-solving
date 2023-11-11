package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE 3 / 36 testcases passed
 */
public class Q2642DesignGraphWithShortestPathCalculator {

    @Test
    public void test() {
        Graph graph = new Graph(4, Ps.intArray("[[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]"));
        assertThat(graph.shortestPath(3, 2)).isEqualTo(6);
        assertThat(graph.shortestPath(0, 3)).isEqualTo(-1);
        graph.addEdge(new int[]{1, 3, 4});
        assertThat(graph.shortestPath(0, 3)).isEqualTo(6);
    }

    class Graph {

        Map<Integer, Node> nodes = new HashMap<>();

        public Graph(int n, int[][] edges) {
            for (int i = 0; i < n; i++) {
                nodes.put(i, new Node(i));
            }
            for (int[] edge : edges) {
                addEdge(edge);
            }
        }

        public void addEdge(int[] edge) {
            Node from = nodes.get(edge[0]);
            Node to = nodes.get(edge[1]);
            int distance = edge[2];
            from.addEdge(to, distance);
        }

        public int shortestPath(int node1, int node2) {
            Node from = nodes.get(node1);
            Node target = nodes.get(node2);
            HashSet<Node> visited = new HashSet<>();
            visited.add(from);
            return shortestPath(from, target, visited);
        }

        private int shortestPath(Node from, Node target, Set<Node> visited) {
            if (from == target)
                return 0;
            int shorted = Integer.MAX_VALUE;
            for (Map.Entry<Node, Integer> e : from.edges.entrySet()) {
                Node next = e.getKey();
                if (!visited.add(next)) {
                    continue;
                }
                int curDistance = shortestPath(next, target, visited);
                visited.remove(next);
                if (curDistance == -1)
                    continue;
                shorted = Math.min(shorted, curDistance + e.getValue());
            }
            if (shorted == Integer.MAX_VALUE) {
                return -1;
            }
            return shorted;
        }

        class Node {
            int id;
            Map<Node, Integer> edges = new HashMap<>();

            public Node(int id) {
                this.id = id;
            }

            void addEdge(Node next, int distance) {
                this.edges.put(next, distance);
            }

            @Override
            public String toString() {
                return "Node{" +
                        "id=" + id +
                        '}';
            }
        }
    }

}
