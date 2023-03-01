package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 1 ms, faster than 10.11% of Java online submissions for Delete Node in a Linked List.
 * Memory Usage: 43 MB, less than 83.96% of Java online submissions for Delete Node in a Linked List.
 */
public class Q237DeleteNodeInALinkedList {

    @Test
    public void test() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        deleteNode(head.next);
        assertThat(head.val).isEqualTo(4);
        assertThat(head.next.val).isEqualTo(1);
        assertThat(head.next.next.val).isEqualTo(9);
        assertThat(head.next.next.next).isNull();
    }

    public void deleteNode(ListNode node) {
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }

}
