package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 3 ms Beats 27.55%
 * Memory 43.6 MB Beats 15.11%
 */
public class Q142LinkedListCycleII2 {
    @Test
    public void test() {
        ListNode node = ListNode.of(3, 2, 0, 2);
        node.next.next.next.next = node.next;
        assertThat(detectCycle(node)).isEqualTo(node.next);
    }

    @Test
    public void test2() {
        ListNode node = ListNode.of(1, 2);
        node.next.next = node;
        assertThat(node).isEqualTo(node.next);
    }

    @Test
    public void test3() {
        assertThat(detectCycle(ListNode.of(1))).isEqualTo(null);
    }

    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head)) {
                return head;
            }
            head = head.next;
        }
        return null;
    }

}
