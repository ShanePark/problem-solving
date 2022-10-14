package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 10 ms, faster than 26.36% of Java online submissions for Delete the Middle Node of a Linked List.
 * Memory Usage: 217.8 MB, less than 54.42% of Java online submissions for Delete the Middle Node of a Linked List.
 */
public class Q2095DeleteTheMiddleNodeOfALinkedList {

    @Test
    public void test() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result = deleteMiddle(head);
        assertThat(result).isEqualTo(new ListNode(1, new ListNode(2, new ListNode(4))));
    }

    @Test
    public void test2() {
        ListNode head = ListNode.of(1, 3, 4, 7, 1, 2, 6);
        ListNode listNode = deleteMiddle(head);
        assertThat(listNode).isEqualTo(ListNode.of(1, 3, 4, 1, 2, 6));
    }

    @Test
    public void test3() {
        ListNode original = ListNode.of(2, 1);
        ListNode head = deleteMiddle(original);
        assertThat(head).isEqualTo(ListNode.of(2));
    }

    @Test
    public void tes4() {
        assertThat(deleteMiddle(ListNode.of(1))).isEqualTo(null);
    }

    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        if (slow.next != null) {
            slow.val = slow.next.val;
            slow.next = slow.next.next;
        } else {
            head.next = null;
        }
        return head;
    }

}
