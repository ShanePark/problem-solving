package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Delete Node in a Linked List.
 * Memory Usage: 41.7 MB, less than 94.47% of Java online submissions for Delete Node in a Linked List.
 */
public class Q237DeleteNodeInALinkedList2 {

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
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
