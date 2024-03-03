package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q19RemoveNthNodeFromEndOfList2 {

    @Test
    public void test() {
        assertThat(removeNthFromEnd(ListNode.of(1, 2, 3, 4, 5), 5)).isEqualTo(ListNode.of(2, 3, 4, 5));
        assertThat(removeNthFromEnd(ListNode.of(1, 2, 3, 4, 5), 2)).isEqualTo(ListNode.of(1, 2, 3, 5));
        assertThat(removeNthFromEnd(ListNode.of(1), 1)).isEqualTo(ListNode.of());
        assertThat(removeNthFromEnd(ListNode.of(1, 2), 1)).isEqualTo(ListNode.of(1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        traverse(head, list);
        int size = list.size();
        if (size == 1)
            return null;
        int delIndex = size - n;
        if (delIndex == 0) {
            return head.next;
        }
        ListNode before = list.get(delIndex - 1);
        ListNode target = list.get(delIndex);
        before.next = target.next;
        return head;
    }

    private void traverse(ListNode node, List<ListNode> list) {
        if (node == null)
            return;
        list.add(node);
        traverse(node.next, list);
    }

}
