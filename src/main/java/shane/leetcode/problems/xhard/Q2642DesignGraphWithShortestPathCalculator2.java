package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 209ms Beats 31.48%of users with Java
 * Memory Details 54.54MB Beats 66.67%of users with Java
 * <p>
 * Comment: I was impressed how Dijkstra algorithm could be used like this.
 */
public class Q2642DesignGraphWithShortestPathCalculator2 {

    @Test
    public void test() {
        Graph graph = new Graph(4, Ps.intArray("[[0, 2, 5], [0, 1, 2], [1, 2, 1], [3, 0, 3]]"));
        assertThat(graph.shortestPath(3, 2)).isEqualTo(6);
        assertThat(graph.shortestPath(0, 3)).isEqualTo(-1);
        graph.addEdge(new int[]{1, 3, 4});
        assertThat(graph.shortestPath(0, 3)).isEqualTo(6);
    }


    @Test
    public void test2() {
        Graph graph = new Graph(13, Ps.intArray("[[7,2,131570],[9,4,622890],[9,1,812365],[1,3,399349],[10,2,407736],[6,7,880509],[1,4,289656],[8,0,802664],[6,4,826732],[10,3,567982],[5,6,434340],[4,7,833968],[12,1,578047],[8,5,739814],[10,9,648073],[1,6,679167],[3,6,933017],[0,10,399226],[1,11,915959],[0,12,393037],[11,5,811057],[6,2,100832],[5,1,731872],[3,8,741455],[2,9,835397],[7,0,516610],[11,8,680504],[3,11,455056],[1,0,252721]]"));
        assertThat(graph.shortestPath(9, 3)).isEqualTo(1211714);
        graph.addEdge(new int[]{11, 1, 873094});
        assertThat(graph.shortestPath(3, 10)).isEqualTo(1943345);
    }

    class Graph {

        final Map<Integer, Node> nodes = new HashMap<>();

        public Graph(int n, int[][] edges) {
            for (int i = 0; i < n; i++) {
                nodes.put(i, new Node(i));
            }
            for (int[] edge : edges) {
                Node from = nodes.get(edge[0]);
                Node to = nodes.get(edge[1]);
                from.addEdge(to, edge[2]);
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
            int[] distances = new int[nodes.size()];
            Arrays.fill(distances, Integer.MAX_VALUE);

            PriorityQueue<DistanceNodePair> pq = new PriorityQueue<>(Comparator.comparingInt(d -> d.distance));
            pq.offer(new DistanceNodePair(0, from));
            while (!pq.isEmpty()) {
                DistanceNodePair poll = pq.poll();
                Node node = poll.node;
                if (node.id == node2) {
                    return poll.distance;
                }
                if (distances[node.id] <= poll.distance) {
                    continue;
                }
                distances[node.id] = poll.distance;
                for (Map.Entry<Node, Integer> e : node.edges.entrySet()) {
                    Node next = e.getKey();
                    int nextDistance = poll.distance + e.getValue();
                    pq.offer(new DistanceNodePair(nextDistance, next));
                }
            }
            return -1;
        }

        class DistanceNodePair {
            int distance;
            Node node;

            public DistanceNodePair(int distance, Node node) {
                this.distance = distance;
                this.node = node;
            }
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
