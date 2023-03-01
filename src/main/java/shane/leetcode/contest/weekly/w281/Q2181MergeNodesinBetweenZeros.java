package shane.leetcode.contest.weekly.w281;

import io.github.shanepark.leetcode.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q2181MergeNodesinBetweenZeros {

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
        List<Integer> list = new ArrayList<>();
        traverse(head.next, list, 0);
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (Integer i : list) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return dummy.next;
    }

    private void traverse(ListNode head, List<Integer> list, int sum) {
        if (head.val == 0) {
            list.add(sum);
            sum = 0;
        }
        if (head.next != null) {
            traverse(head.next, list, sum + head.val);
        }
    }

}
