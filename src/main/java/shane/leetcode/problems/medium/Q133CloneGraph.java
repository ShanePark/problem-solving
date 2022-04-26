package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q133CloneGraph {

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
        System.out.println("clone.val = " + clone.val);
        for (Node neighbor : clone.neighbors) {
            System.out.println("neighbor.val = " + neighbor.val);
        }

        cloneGraph(null);
    }

    public Node cloneGraph(Node node) {
        Map<Integer, Node> map = new HashMap<>();
        return clone(node, map);
    }

    private Node clone(Node node, Map<Integer, Node> map) {

        if (node == null)
            return null;

        Node clone = new Node(node.val);
        map.put(node.val, clone);
        for (Node neighbor : node.neighbors) {
            Node child = map.get(neighbor.val);
            if (child == null) {
                child = clone(neighbor, map);
            }
            clone.neighbors.add(child);
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
