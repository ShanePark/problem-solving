package shane.leetcode.problems.medium;

import com.github.shanepark.leetcode.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q24SwapNodesinPairs {

    @Test
    void test() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);

        ListNode head = swapPairs(root);

        Assertions.assertThat(head.val).isEqualTo(2);
        Assertions.assertThat(head.next.val).isEqualTo(1);
        Assertions.assertThat(head.next.next.val).isEqualTo(4);
        Assertions.assertThat(head.next.next.next.val).isEqualTo(3);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode root = dummy;
        while (root.next != null && root.next.next != null) {
            swap(root, root.next, root.next.next);
            root = root.next.next;
        }
        return dummy.next;
    }

    private void swap(ListNode cur, ListNode head, ListNode next) {
        head.next = next.next;
        cur.next = next;
        cur.next.next = head;
    }

}
