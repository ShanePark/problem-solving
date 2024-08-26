package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime0msBeats100.00%
 */
public class Q590NaryTreePostorderTraversal2 {

    @Test
    public void test() {
        Node node = new Node(1);
        node.children = new ArrayList<>();
        Node node3 = new Node(3);
        node.children.add(node3);
        node.children.add(new Node(2));
        node.children.add(new Node(4));
        node3.children = new ArrayList<>();
        node3.children.add(new Node(5));
        node3.children.add(new Node(6));
        assertThat(postorder(node)).containsExactly(5, 6, 3, 2, 4, 1);
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        postOrder(list, root);
        return list;
    }

    private void postOrder(List<Integer> list, Node node) {
        if (node == null)
            return;
        if (node.children != null) {
            for (Node child : node.children) {
                postOrder(list, child);
            }
        }
        list.add(node.val);
    }

    static class Node {
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


