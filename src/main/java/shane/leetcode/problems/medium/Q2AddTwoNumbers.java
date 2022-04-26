package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

public class Q2AddTwoNumbers {

    @Test
    void test1() {
        ListNode l1 = ListNode.of(new int[]{2, 4, 3});
        ListNode l2 = ListNode.of(new int[]{5, 6, 4});
        ListNode result = addTwoNumbers(l1, l2);
        result.print();
    }

    @Test
    void test2() {
        ListNode l1 = ListNode.of(new int[]{0});
        ListNode l2 = ListNode.of(new int[]{0});
        ListNode result = addTwoNumbers(l1, l2);
        result.print();
    }

    @Test
    void test3() {
        ListNode l1 = ListNode.of(new int[]{9, 9, 9, 9, 9, 9, 9});
        ListNode l2 = ListNode.of(new int[]{9, 9, 9, 9});
        ListNode result = addTwoNumbers(l1, l2);
        result.print();
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        int save = 0;

        while (l1 != null || l2 != null) {
            int sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + save;
            save = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (save > 0)
            curr.next = new ListNode(save);

        return dummy.next;
    }

}

