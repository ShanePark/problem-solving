package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 25 ms Beats 81.90%
 * Memory 42.5 MB Beats 62.89%
 */
public class Q133CloneGraph3 {

    @Test
    void test() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        Node clone = cloneGraph(node1);
        assertThat(clone.val).isEqualTo(1);
        assertThat(clone.neighbors.size()).isEqualTo(2);
        assertThat(clone.neighbors.get(0).val).isEqualTo(2);
        assertThat(clone.neighbors.get(1).val).isEqualTo(4);
    }

    @Test
    void test2() {
        Node node = new Node(1);
        Node clone = cloneGraph(node);
        assertThat(clone.val).isEqualTo(1);
        assertThat(clone.neighbors).isEmpty();
    }

    @Test
    void test3() {
        assertThat(cloneGraph(null)).isEqualTo(null);
    }

    public Node cloneGraph(Node node) {
        return clone(node, new HashMap<>());
    }

    private Node clone(Node original, Map<Integer, Node> cloneMap) {
        if (original == null)
            return null;
        int index = original.val;
        if (cloneMap.containsKey(index))
            return cloneMap.get(index);

        Node clone = new Node(index, new ArrayList<>());
        cloneMap.put(index, clone);
        for (Node neighbor : original.neighbors) {
            Node cloneNeighbor = clone(neighbor, cloneMap);
            clone.neighbors.add(cloneNeighbor);
        }

        return clone;
    }

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
}
