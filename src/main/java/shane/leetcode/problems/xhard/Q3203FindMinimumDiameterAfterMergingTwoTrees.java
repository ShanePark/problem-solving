package shane.leetcode.problems.xhard;

import io.github.shanepark.Ps;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3203FindMinimumDiameterAfterMergingTwoTrees {

    @Test
    public void test() {
        assertThat(minimumDiameterAfterMerge(Ps.intArray("[[1,0],[1,2],[1,3]]"), Ps.intArray("[[3,0],[2,5],[4,2],[4,6],[3,4],[1,3],[1,7]]"))).isEqualTo(5);
        assertThat(minimumDiameterAfterMerge(Ps.intArray("[[0,1],[0,2],[0,3]]"), Ps.intArray("[[0,1]]"))).isEqualTo(3);
        assertThat(minimumDiameterAfterMerge(Ps.intArray("[[0,1],[2,0],[3,2],[3,6],[8,7],[4,8],[5,4],[3,5],[3,9]]"), Ps.intArray("[[0,1],[0,2],[0,3]]"))).isEqualTo(7);
        assertThat(minimumDiameterAfterMerge(Ps.intArray("[]"), Ps.intArray("[]"))).isEqualTo(1);
        assertThat(minimumDiameterAfterMerge(Ps.intArray("[[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]]"), Ps.intArray("[[0,1],[0,2],[0,3],[2,4],[2,5],[3,6],[2,7]]"))).isEqualTo(5);
    }

    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int d1 = getMinDiameter(edges1);
        int d2 = getMinDiameter(edges2);
        int max = Math.max(d1, d2);
        max = Math.max(max, (d1 + 1) / 2 + (d2 + 1) / 2 + 1);
        return max;
    }

    private int getMinDiameter(int[][] edges) {
        if (edges.length == 0) {
            return 0;
        }
        Node[] nodes = makeNodesFromEdges(edges);
        NodeDistance farNodeDist = getFurthestNode(nodes[0], null, 0);
        NodeDistance anotherFarNodeDist = getFurthestNode(farNodeDist.node, null, 0);
        return anotherFarNodeDist.distance;
    }

    private NodeDistance getFurthestNode(Node node, Node prev, int dist) {
        NodeDistance result = new NodeDistance(node, dist);
        for (Node next : node.con) {
            if (next == prev)
                continue;
            NodeDistance candidate = getFurthestNode(next, node, dist + 1);
            if (candidate.distance > result.distance) {
                result = candidate;
            }
        }
        return result;
    }

    private static Node[] makeNodesFromEdges(int[][] edges) {
        Node[] nodes = new Node[edges.length + 1];
        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new Node(i);
        }
        for (int[] edge : edges) {
            nodes[edge[0]].addEdge(nodes[edge[1]]);
        }
        return nodes;
    }


    static class Node {
        final int index;
        Set<Node> con = new HashSet<>();

        Node(int index) {
            this.index = index;
        }

        public void addEdge(Node node) {
            this.con.add(node);
            node.con.add(this);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    '}';
        }
    }

    private static class NodeDistance {
        Node node;
        int distance;

        NodeDistance(Node node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

}
