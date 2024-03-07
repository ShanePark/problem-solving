package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q876MiddleOfTheLinkedList2 {

    @Test
    public void test() {
        assertThat(middleNode(ListNode.of(1))).isEqualTo(ListNode.of(1));
        assertThat(middleNode(ListNode.of(1, 2))).isEqualTo(ListNode.of(2));
        assertThat(middleNode(ListNode.of(1, 2, 3, 4, 5))).isEqualTo(ListNode.of(3, 4, 5));
        assertThat(middleNode(ListNode.of(1, 2, 3, 4, 5, 6))).isEqualTo(ListNode.of(4, 5, 6));
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        while (fast != null) {
            fast = fast.next;
            if (fast == null)
                return head;
            head = head.next;
            fast = fast.next;
            if (fast == null || fast.next == null)
                return head;
        }
        return head;
    }

}
