package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

public class Q138CopyListWithRandomPointer {

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
        Node dummy = new Node(0);
        Node headDummy = new Node(0);
        headDummy.next = head;
        Node originalCur = headDummy.next;
        Node copyCur = dummy;

        Map<Node, Integer> randomIndexMap = new HashMap<>();
        Map<Integer, Node> mapCopy = new HashMap<>();
        int index = 0;

        while (originalCur != null) {
            copyCur.next = new Node(originalCur.val);

            randomIndexMap.put(originalCur, index);
            mapCopy.put(index++, copyCur.next);

            originalCur = originalCur.next;
            copyCur = copyCur.next;
        }

        originalCur = headDummy.next;
        copyCur = dummy.next;
        while (originalCur != null) {
            Integer i = randomIndexMap.get(originalCur.random);
            copyCur.random = mapCopy.get(i);
            originalCur = originalCur.next;
            copyCur = copyCur.next;
        }

        return dummy.next;
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
