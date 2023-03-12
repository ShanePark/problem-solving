package shane.leetcode.problems.xhard;

import io.github.shanepark.leetcode.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Runtime 1 ms Beats 100%
 * Memory 44.5 MB Beats 35.80%
 */
public class Q23MergekSortedLists3 {

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
        if (lists == null || lists.length == 0)
            return null;
        return mergeNodes(lists, 0, lists.length - 1);
    }

    private ListNode mergeNodes(ListNode[] lists, int left, int right) {
        if (left == right)
            return lists[left];
        if (left == right - 1) {
            ListNode node1 = lists[left];
            ListNode node2 = lists[right];
            return mergeNodes(node1, node2);
        }
        int mid = (left + right) / 2;
        ListNode node1 = mergeNodes(lists, left, mid);
        ListNode node2 = mergeNodes(lists, mid + 1, right);
        return mergeNodes(node1, node2);
    }

    private ListNode mergeNodes(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                cur.next = node1;
                node1 = node1.next;
                cur = cur.next;
                continue;
            }
            cur.next = node2;
            node2 = node2.next;
            cur = cur.next;
        }
        cur.next = node1 != null ? node1 : node2;
        return dummy.next;
    }

}
