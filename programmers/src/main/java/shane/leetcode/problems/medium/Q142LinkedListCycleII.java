package shane.leetcode.problems.medium;

import org.assertj.core.api.Assertions;

import java.util.HashSet;
import java.util.Set;

public class Q142LinkedListCycleII {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next = new ListNode(2);
        head.next = next;
        next.next = head;
        ListNode answer = detectCycle(head);
        Assertions.assertThat(answer.val).isEqualTo(1);
        Assertions.assertThat(answer.next.val).isEqualTo(2);
    }

    public static ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        if (head == null) {
            return null;
        }
        set.add(head);
        while (head.next != null) {
            if (!set.add(head.next)) {
                return head.next;
            }
            head = head.next;
        }
        return null;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next.val +
                    '}';
        }
    }
}
