package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TLE
 * 10 / 18 testcases passed
 */
public class Q1514PathWithMaximumProbability {

    @Test
    public void test() {
        assertThat(maxProbability(3, Ps.intArray("[[0,1],[1,2],[0,2]]"), new double[]{0.5, 0.5, 0.2}, 0, 2)).isEqualTo(0.25);
        assertThat(maxProbability(3, Ps.intArray("[[0,1],[1,2],[0,2]]"), new double[]{0.5, 0.5, 0.3}, 0, 2)).isEqualTo(0.3);
        assertThat(maxProbability(3, Ps.intArray("[[0,1]]"), new double[]{0.5}, 0, 2)).isEqualTo(0);
    }

    @Test
    public void tle() {
        int size = 10000;
        int[][] arr1 = new int[size][2];
        double[] arr2 = new double[size];
        for (int i = 0; i < size; i++) {
            arr1[i] = new int[]{new Random().nextInt(size), new Random().nextInt(size)};
            arr2[i] = Math.random();
        }
        assertThat(maxProbability(size, arr1, arr2, 4106, 2650));
    }

    double max;

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        max = 0;
        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Node node = new Node(i);
            nodes.put(i, node);
        }

        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            Node from = nodes.get(edge[0]);
            Node to = nodes.get(edge[1]);
            double prob = succProb[i];
            from.addConnection(to, prob);
            to.addConnection(from, prob);
        }

        boolean[] visited = new boolean[n];
        dfs(nodes, start, end, visited, 1);

        return max;
    }

    private void dfs(Map<Integer, Node> nodes, int cur, int end, boolean[] visited, double currentProb) {
        if (currentProb <= max)
            return;
        if (cur == end) {
            max = Math.max(max, currentProb);
            return;
        }
        Node curNode = nodes.get(cur);
        for (Connection connection : curNode.connections) {
            int next = connection.destination;
            if (visited[next])
                continue;
            visited[next] = true;
            dfs(nodes, next, end, visited, currentProb * connection.prob);
            visited[next] = false;
        }
    }

    class Node {
        int index;
        Set<Connection> connections = new HashSet<>();

        public Node(int index) {
            this.index = index;
        }

        public void addConnection(Node to, double prob) {
            connections.add(new Connection(to.index, prob));
        }
    }

    class Connection {
        int destination;
        double prob;

        public Connection(int destination, double prob) {
            this.destination = destination;
            this.prob = prob;
        }
    }

}
