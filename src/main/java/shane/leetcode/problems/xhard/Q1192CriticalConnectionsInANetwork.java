package shane.leetcode.problems.xhard;

import com.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 */
public class Q1192CriticalConnectionsInANetwork {

    @Test
    public void test() {
        assertThat(criticalConnections(4, Ps.intList("[[0,1],[1,2],[2,0],[1,3]]"))).isEqualTo(Ps.intList("[[1,3]]"));
        assertThat(criticalConnections(2, Ps.intList("[[0,1]]"))).isEqualTo(Ps.intList("[[0,1]]"));
    }

    Map<Integer, Node> map;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new Node(i));
        }

        for (List<Integer> connection : connections) {
            Node node1 = map.get(connection.get(0));
            Node node2 = map.get(connection.get(1));
            node1.add(node2);
            node2.add(node1);
        }

        List<List<Integer>> answer = new ArrayList<>();

        for (List<Integer> connection : connections) {
            if (critical(connection, n)) {
                answer.add(connection);
            }
        }

        return answer;
    }

    private boolean critical(List<Integer> connection, int size) {
        Node node1 = map.get(connection.get(0));
        Node node2 = map.get(connection.get(1));

        boolean[] visited = new boolean[size];
        visited[node2.number] = true;

        // try go from node2 to node1 not using node2->node1 connection
        Queue<Node> q = new LinkedList<>();
        List<Node> connections = node2.connections;

        if (connection.size() == 1)
            return true;

        for (Node node : connections) {
            if (node != node1) {
                q.offer(node);
            }
        }

        while (!q.isEmpty()) {
            Node poll = q.poll();
            if (!visited[poll.number]) {
                if (poll == node1) {
                    return false;
                }
                visited[poll.number] = true;
                for (Node node : poll.connections) {
                    q.offer(node);
                }
            }
        }

        return true;
    }

    class Node {
        int number;
        List<Node> connections = new ArrayList<>();

        public Node(int number) {
            this.number = number;
        }

        public void add(Node node) {
            this.connections.add(node);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "number=" + number +
                    ", connections=" + connections.stream().map(n -> n.number).collect(Collectors.toList()) +
                    '}';
        }
    }
}
