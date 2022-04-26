package shane.leetcode.problems.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q589NaryTreePreorderTraversal {

    @Test
    public void test() {
        Node root = new Node(1);
        Node left = new Node(3);
        left.children = new ArrayList<>();
        left.children.add(new Node(5));
        left.children.add(new Node(6));
        root.children = new ArrayList<>();
        root.children.add(left);
        root.children.add(new Node(2));
        root.children.add(new Node(4));

        assertThat(preorder(root)).containsExactly(1, 3, 5, 6, 2, 4);

        assertThat(preorder(null)).contains();
    }

    public List<Integer> preorder(Node root) {
        if (root == null)
            return Collections.EMPTY_LIST;
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        if (root.children == null)
            return list;
        for (Node child : root.children) {
            list.addAll(preorder(child));
        }
        return list;
    }
}

// Definition for a Node.
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
};
