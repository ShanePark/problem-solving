package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime48msBeats19.88%
 */
public class Q1514PathWithMaximumProbability5 {

    @Test
    public void test() {
        assertThat(maxProbability(3, Ps.intArray("[[0,1],[1,2],[0,2]]"), new double[]{0.5, 0.5, 0.2}, 0, 2)).isEqualTo(0.25);
        assertThat(maxProbability(3, Ps.intArray("[[0,1],[1,2],[0,2]]"), new double[]{0.5, 0.5, 0.3}, 0, 2)).isEqualTo(0.3);
        assertThat(maxProbability(3, Ps.intArray("[[0,1]]"), new double[]{0.5}, 0, 2)).isEqualTo(0);
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] dp = new double[n];
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < edges.length; i++) {
            Node node1 = nodes[edges[i][0]];
            Node node2 = nodes[edges[i][1]];
            node1.addEdge(node2, succProb[i]);
        }
        dp[start] = 1;
        Queue<Node> q = new LinkedList<>();
        q.offer(nodes[start]);
        while (!q.isEmpty()) {
            Node poll = q.poll();
            double cur = dp[poll.index];
            for (Map.Entry<Node, Double> e : poll.next.entrySet()) {
                Node next = e.getKey();
                if (dp[next.index] < cur * e.getValue()) {
                    dp[next.index] = cur * e.getValue();
                    q.offer(next);
                }
            }
        }
        return dp[end];
    }

    static class Node {
        final int index;
        Map<Node, Double> next = new HashMap<>();

        Node(int index) {
            this.index = index;
        }

        public void addEdge(Node node2, double v) {
            next.put(node2, v);
            node2.next.put(this, v);
        }
    }

}
