package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Q138CopyListWithRandomPointer2 {

    @Test
    void test() {
        Node root = new Node(7);
        root.next = new Node(13);
        root.next.next = new Node(11);
        root.next.next.next = new Node(10);
        root.next.next.next.next = new Node(1);

        root.random = null;
        root.next.random = root;
        root.next.next.random = root.next.next.next.next;
        root.next.next.next.random = root.next.next;
        root.next.next.next.next.random = root;

        Node copy = copyRandomList(root);
        Assertions.assertThat(copy.val).isEqualTo(7);
        Assertions.assertThat(copy.random).isNull();
        Assertions.assertThat(copy.next.val).isEqualTo(13);
        Assertions.assertThat(copy.next.random.val).isEqualTo(7);
        Assertions.assertThat(copy.next.next.val).isEqualTo(11);
        Assertions.assertThat(copy.next.next.random.val).isEqualTo(1);
        Assertions.assertThat(copy.next.next.next.val).isEqualTo(10);
        Assertions.assertThat(copy.next.next.next.random.val).isEqualTo(11);
        Assertions.assertThat(copy.next.next.next.next.val).isEqualTo(1);
        Assertions.assertThat(copy.next.next.next.next.random.val).isEqualTo(7);
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }

        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + (next == null ? "null" : next.val) +
                    ", random=" + (random == null ? "null" : random.val) +
                    '}';
        }
    }

}
