package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.ListNode;

public class Q2AddTwoNumbers {

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3, null)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4, null)));
        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))))));
        ListNode l2 = new ListNode(9, new ListNode(9, new ListNode(9, new ListNode(9, null))));
        ListNode result = addTwoNumbers(l1, l2);
        result.print();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int save = 0;
        ListNode result = new ListNode(0);
        ListNode curr = result;
        boolean isFirst = true;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int sum = val1 + val2 + save;
            save = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if(save > 0)
            curr.next = new ListNode(save);

        return result.next;
    }

}

