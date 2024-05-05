package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q237DeleteNodeInALinkedList3 {

    @Test
    public void test() {
        ListNode node = ListNode.of(4, 5, 1, 9);
        deleteNode(node.next);
        assertThat(node).isEqualTo(ListNode.of(4, 1, 9));

        node = ListNode.of(4, 5, 1, 9);
        deleteNode(node.next.next);
        assertThat(node).isEqualTo(ListNode.of(4, 5, 9));
    }

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        if (next == null)
            return;
        node.next = next.next;
        node.val = next.val;
    }

}
