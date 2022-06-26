package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q559MaximumDepthOfNaryTree {

    @Test
    public void test() {
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> list = new ArrayList<>();
        list.add(node5);
        list.add(node6);
        Node node3 = new Node(3, list);
        list = new ArrayList<>();

        Node node2 = new Node(2);
        Node node4 = new Node(4);


        list.add(node3);
        list.add(node2);
        list.add(node4);
        Node node1 = new Node(1, list);
        assertThat(maxDepth(node1)).isEqualTo(3);
    }

    public int maxDepth(Node root) {
        if(root == null)
            return 0;
        if (root.children == null)
            return 1;
        int max = 0;
        for (Node child : root.children) {
            max = Math.max(max, maxDepth(child));
        }
        return max + 1;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
