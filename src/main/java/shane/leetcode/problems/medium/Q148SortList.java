package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Comparator;

public class Q148SortList {


    @Test
    void test() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        ListNode list = sortList(head);
        System.out.println("list.val = " + list.val);
        System.out.println("list.val = " + list.next.val);
        System.out.println("list.val = " + list.next.next.val);
        System.out.println("list.val = " + list.next.next.next.val);

    }

    public ListNode sortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        list.sort(Comparator.comparingInt(a -> a));
        for (Integer i : list) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }

        return dummy.next;

    }

}

