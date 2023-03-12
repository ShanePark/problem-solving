package shane.leetcode.problems.xhard;

import io.github.shanepark.leetcode.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Q23MergekSortedLists2 {

    @Test
    void test() {
        Assertions.assertThat(mergeKLists(new ListNode[]{
                ListNode.of(1, 4, 5),
                ListNode.of(1, 3, 4),
                ListNode.of(2, 6)
        })).isEqualTo(ListNode.of(1, 1, 2, 3, 4, 4, 5, 6));

        Assertions.assertThat(mergeKLists(new ListNode[]{})).isEqualTo(null);
        Assertions.assertThat(mergeKLists(null)).isEqualTo(null);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null)
            return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(n -> n.val));
        for (ListNode node : lists) {
            while (node != null) {
                pq.offer(node);
                node = node.next;
            }
        }
        if (pq.isEmpty())
            return null;

        ListNode head = pq.poll();
        ListNode cur = head;
        while (!pq.isEmpty()) {
            cur.next = pq.poll();
            cur = cur.next;
        }
        cur.next = null;
        return head;
    }

}
