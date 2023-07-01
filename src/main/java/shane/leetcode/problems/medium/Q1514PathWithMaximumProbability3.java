package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 81 ms Beats 21.63%
 * Memory 59.7 MB Beats 5.30%
 */
public class Q1514PathWithMaximumProbability3 {

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
        assertThat(maxProbability(size, arr1, arr2, 7168, 6293));
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
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

        double[] dp = new double[n];
        dp[end] = 1;

        // end to everywhere DFS
        Queue<Node> q = new LinkedList<>();
        q.offer(nodes.get(end));
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node poll = q.poll();
                double curProb = dp[poll.index];
                for (Connection connection : poll.connections) {
                    int nextIndex = connection.destination;
                    double nextProb = curProb * connection.prob;
                    if (dp[nextIndex] < nextProb) {
                        dp[nextIndex] = nextProb;
                        q.offer(nodes.get(nextIndex));
                    }
                }
            }
        }

        return dp[start];
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
