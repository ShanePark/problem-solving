package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q117PopulatingNextRightPointersInEachNodeII2 {

    @Test
    public void test() {
        assertThat(connect(null)).isNull();
    }

    public Node connect(Node root) {
        Node cur = root;
        Node line = new Node();
        Node temp = line;
        while (cur != null) {
            if (cur.left != null) {
                temp.next = cur.left;
                temp = temp.next;
            }
            if (cur.right != null) {
                temp.next = cur.right;
                temp = temp.next;
            }
            if (cur.next != null) {
                cur = cur.next;
            } else {
                cur = line.next;
                line.next = null;
                temp = line;
            }
        }
        return root;
    }


    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
