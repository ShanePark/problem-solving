package shane.leetcode.contest.weekly.w281;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q2181MergeNodesinBetweenZeros2 {

    @Test
    void test() {
        ListNode head = new ListNode(0);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next = new ListNode(0);

        ListNode result = mergeNodes(head);

        Assertions.assertThat(result.val).isEqualTo(4);
        Assertions.assertThat(result.next.val).isEqualTo(11);
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        ListNode cur = head.next;
        while (cur != null) {
            int sum = 0;
            while (cur.val != 0) {
                sum += cur.val;
                cur = cur.next;
            }
            prev.next = new ListNode(sum);
            prev = prev.next;
            cur = cur.next;
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
