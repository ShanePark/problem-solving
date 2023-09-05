package shane.leetcode.problems.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 1ms Beats 7.93%of users with Java
 * Memory Details 43.51MB Beats 22.75%of users with Java
 */
public class Q138CopyListWithRandomPointer3 {

    @Test
    void test() {
        // nodes
        Node root = new Node(7);
        root.next = new Node(13);
        root.next.next = new Node(11);
        root.next.next.next = new Node(10);
        root.next.next.next.next = new Node(1);

        // set random
        root.random = null;
        root.next.random = root;
        root.next.next.random = root.next.next.next.next;
        root.next.next.next.random = root.next.next;
        root.next.next.next.next.random = root;

        Node copy = copyRandomList(root);
        assertThat(copy == root).isFalse();
        assertThat(copy.val).isEqualTo(7);
        assertThat(copy.random).isNull();
        assertThat(copy.next.val).isEqualTo(13);
        assertThat(copy.next.random.val).isEqualTo(7);
        assertThat(copy.next.next.val).isEqualTo(11);
        assertThat(copy.next.next.random.val).isEqualTo(1);
        assertThat(copy.next.next.next.val).isEqualTo(10);
        assertThat(copy.next.next.next.random.val).isEqualTo(11);
        assertThat(copy.next.next.next.next.val).isEqualTo(1);
        assertThat(copy.next.next.next.next.random.val).isEqualTo(7);
    }

    @Test
    public void test2() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        node1.next = node2;
        node1.random = node2;
        node2.random = node2;
        copyRandomList(node1);
    }

    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Map<Node, Node> map = new HashMap<>();
        Node root = new Node(head.val);
        map.put(head, root);

        Queue<Node> q = new LinkedList<>();
        q.offer(head);

        while (!q.isEmpty()) {
            Node poll = q.poll();
            Node copy = map.get(poll);

            Node next = poll.next;
            if (next != null && !map.containsKey(next)) {
                Node nextCopy = new Node(next.val);
                map.put(next, nextCopy);
                q.offer(next);
            }
            copy.next = map.get(next);

            Node random = poll.random;
            if (random != null && !map.containsKey(random)) {
                Node randomCopy = new Node(random.val);
                map.put(random, randomCopy);
                q.offer(random);
            }
            copy.random = map.get(random);
        }

        return map.get(head);
    }

    class Node {
        int val;
        Node next;
        Node random;

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    '}';
        }

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
