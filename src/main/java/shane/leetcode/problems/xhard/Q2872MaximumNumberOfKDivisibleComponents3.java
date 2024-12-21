package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime58msBeats27.27%
 */
public class Q2872MaximumNumberOfKDivisibleComponents3 {

    @Test
    public void test() {
        assertThat(maxKDivisibleComponents(5, Ps.intArray("[[0,2],[1,2],[1,3],[2,4]]"), new int[]{1, 8, 1, 4, 4}, 6)).isEqualTo(2);
        assertThat(maxKDivisibleComponents(7, Ps.intArray("[[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]"), new int[]{3, 0, 6, 1, 5, 2, 1}, 3)).isEqualTo(3);
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(values[i] % k);
        }
        for (int[] edge : edges) {
            nodes[edge[0]].addEdge(nodes[edge[1]]);
        }
        Queue<Node> leaves = new LinkedList<>();
        for (Node node : nodes) {
            if (node.connect.size() == 1)
                leaves.add(node);
        }
        int cutCnt = 0;
        for (int i = 0; i < n - 1; i++) {
            Node leaf = leaves.poll();
            if (leaf.mod == 0)
                cutCnt++;
            Node parent = leaf.connect.iterator().next();
            parent.mod = (parent.mod + leaf.mod) % k;
            parent.connect.remove(leaf);
            if (parent.connect.size() == 1) {
                leaves.add(parent);
            }
        }
        return cutCnt + 1;
    }

    static class Node {
        Set<Node> connect = new HashSet<>();
        int mod;

        public Node(int mod) {
            this.mod = mod;
        }

        public void addEdge(Node node) {
            this.connect.add(node);
            node.connect.add(this);
        }
    }

}
