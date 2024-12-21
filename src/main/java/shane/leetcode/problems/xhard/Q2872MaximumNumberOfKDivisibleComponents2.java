package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime2464msBeats5.19%
 */
public class Q2872MaximumNumberOfKDivisibleComponents2 {

    @Test
    public void test() {
        assertThat(maxKDivisibleComponents(5, Ps.intArray("[[0,2],[1,2],[1,3],[2,4]]"), new int[]{1, 8, 1, 4, 4}, 6)).isEqualTo(2);
        assertThat(maxKDivisibleComponents(7, Ps.intArray("[[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]"), new int[]{3, 0, 6, 1, 5, 2, 1}, 3)).isEqualTo(3);
    }

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, values[i] % k);
        }
        for (int[] edge : edges) {
            nodes[edge[0]].addEdge(nodes[edge[1]]);
        }
        Map<Integer, Set<Node>> nodeMap = new HashMap<>();
        for (Node node : nodes) {
            nodeMap.computeIfAbsent(node.connect.size(), o -> new HashSet<>())
                    .add(node);
        }
        int cutCnt = 0;
        for (int i = 0; i < n - 1; i++) {
            Node leaf = nodeMap.get(1).stream().findAny().get();
            nodeMap.get(1).remove(leaf);
            if (leaf.mod == 0)
                cutCnt++;
            Node parent = leaf.connect.stream().findAny().get();
            parent.mod = (parent.mod + leaf.mod) % k;
            parent.connect.remove(leaf);
            nodeMap.get(parent.connect.size() + 1).remove(parent);
            nodeMap.computeIfAbsent(parent.connect.size(), o -> new HashSet<>()).add(parent);
        }
        return cutCnt + 1;
    }

    static class Node implements Comparable<Node> {
        Set<Node> connect = new HashSet<>();
        int index;
        int mod;

        public Node(int index, int mod) {
            this.index = index;
            this.mod = mod;
        }

        public void addEdge(Node node) {
            this.connect.add(node);
            node.connect.add(this);
        }

        @Override
        public int compareTo(Node o) {
            return this.connect.size() - o.connect.size();
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", connect=" + connect.stream().map(o -> o.mod).collect(Collectors.toList()) +
                    ", mod=" + mod +
                    '}';
        }
    }

}
