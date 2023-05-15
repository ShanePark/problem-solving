package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3 ms Beats 53.70%
 * Memory 58 MB Beats 20.23%
 */
public class Q1721SwappingNodesInALinkedList3 {

    @Test
    public void test() {
        ListNode node = ListNode.of(new int[]{1, 2, 3, 4, 5});
        assertThat(swapNodes(node, 2)).isEqualTo(ListNode.of(1, 4, 3, 2, 5));
    }

    @Test
    public void test2() {
        ListNode node = ListNode.of(7, 9, 6, 6, 7, 8, 3, 0, 9, 5);
        assertThat(swapNodes(node, 5)).isEqualTo(ListNode.of(7, 9, 6, 6, 8, 7, 3, 0, 9, 5));
    }

    @Test
    public void test3() {
        assertThat(swapNodes(ListNode.of(100, 90), 2)).isEqualTo(ListNode.of(90, 100));
        assertThat(swapNodes(ListNode.of(1, 2), 1)).isEqualTo(ListNode.of(2, 1));
        assertThat(swapNodes(ListNode.of(1), 1)).isEqualTo(ListNode.of(1));
    }

    public ListNode swapNodes(ListNode head, int k) {
        int length = getLength(head);
        ListNode cur = head;
        for (int i = 0; i < k - 1; i++) {
            cur = cur.next;
        }
        ListNode first = cur;

        cur = head;
        for (int i = 0; i < length - k; i++) {
            cur = cur.next;
        }
        ListNode second = cur;

        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
        return head;
    }

    private int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        return length;
    }

}
