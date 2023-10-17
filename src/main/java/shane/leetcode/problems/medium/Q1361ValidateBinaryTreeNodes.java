package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 15ms Beats 48.53%of users with Java
 * Memory Details 44.87MB Beats 40.72%of users with Java
 */
public class Q1361ValidateBinaryTreeNodes {

    @Test
    public void test() {
        assertThat(validateBinaryTreeNodes(4, new int[]{1, 0, 3, -1}, new int[]{-1, -1, -1, -1})).isFalse();
        assertThat(validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, -1, -1, -1})).isTrue();
        assertThat(validateBinaryTreeNodes(4, new int[]{1, -1, 3, -1}, new int[]{2, 3, -1, -1})).isFalse();
        assertThat(validateBinaryTreeNodes(2, new int[]{1, 0}, new int[]{-1, -1})).isFalse();
    }

    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Map<Integer, Node> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new Node(i));
        }
        for (int i = 0; i < n; i++) {
            Node node = map.get(i);
            if (leftChild[i] >= 0) {
                node.left = map.get(leftChild[i]);
                if (node.left.parent != null) {
                    return false;
                }
                node.left.parent = node;
            }
            if (rightChild[i] >= 0) {
                node.right = map.get(rightChild[i]);
                if (node.right.parent != null) {
                    return false;
                }
                node.right.parent = node;
            }
        }
        Node head = null;
        for (int i = 0; i < n; i++) {
            Node node = map.get(i);
            if (node.parent == null) {
                if (head == null) {
                    head = node;
                    continue;
                }
                return false;
            }
        }
        if (head == null)
            return false;

        Set<Integer> set = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(head);
        while (!q.isEmpty()) {
            Node poll = q.poll();
            if (!set.add(poll.index)) {
                return false;
            }
            if (poll.left != null) {
                q.offer(poll.left);
            }
            if (poll.right != null) {
                q.offer(poll.right);
            }
        }
        return set.size() == n;
    }

    class Node {
        int index;
        Node left;
        Node right;
        Node parent;

        public Node(int index) {
            this.index = index;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index=" + index +
                    ", left=" + ((left == null) ? "null" : left.index) +
                    ", right=" + ((right == null) ? "null" : right.index) +
                    "}";
        }
    }

}
