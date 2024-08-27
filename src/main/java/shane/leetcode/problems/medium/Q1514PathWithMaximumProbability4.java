package shane.leetcode.problems.medium;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime65msBeats16.94%
 */
public class Q1514PathWithMaximumProbability4 {

    @Test
    public void test() {
        assertThat(maxProbability(3, Ps.intArray("[[0,1],[1,2],[0,2]]"), new double[]{0.5, 0.5, 0.2}, 0, 2)).isEqualTo(0.25);
        assertThat(maxProbability(3, Ps.intArray("[[0,1],[1,2],[0,2]]"), new double[]{0.5, 0.5, 0.3}, 0, 2)).isEqualTo(0.3);
        assertThat(maxProbability(3, Ps.intArray("[[0,1]]"), new double[]{0.5}, 0, 2)).isEqualTo(0);
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] max = new double[n];
        max[start] = 1;
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            double prob = succProb[i];
            Node node1 = nodes[edge[0]];
            Node node2 = nodes[edge[1]];
            node1.addEdge(node2, prob);
        }
        Queue<Status> q = new LinkedList<>();
        q.offer(new Status(nodes[start], 1d));
        while (!q.isEmpty()) {
            Status poll = q.poll();
            for (Status next : poll.getNext()) {
                if (max[next.node.index] < next.prob) {
                    max[next.node.index] = next.prob;
                    q.offer(next);
                }
            }
        }
        return max[end];
    }

    static class Status {
        final Node node;
        final double prob;

        public Status(Node node, double prob) {
            this.node = node;
            this.prob = prob;
        }

        public List<Status> getNext() {
            List<Status> next = new ArrayList<>();
            for (Map.Entry<Node, Double> e : node.next.entrySet()) {
                double nextProb = prob * e.getValue();
                Status status = new Status(e.getKey(), nextProb);
                next.add(status);
            }
            return next;
        }
    }

    static class Node {
        int index;
        Map<Node, Double> next = new HashMap<>();

        public Node(int i) {
            this.index = i;
        }

        public void addEdge(Node node, double prob) {
            next.put(node, prob);
            node.next.put(this, prob);
        }
    }

}
