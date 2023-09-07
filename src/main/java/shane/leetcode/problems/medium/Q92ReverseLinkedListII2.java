package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 0ms Beats 100.00%of users with Java
 * Memory Details 40.27MB Beats 39.94%of users with Java
 */
public class Q92ReverseLinkedListII2 {

    @Test
    public void test() {
        assertThat(reverseBetween(ListNode.of(1, 2), 1, 2)).isEqualTo(ListNode.of(2, 1));
        assertThat(reverseBetween(ListNode.of(5), 1, 1)).isEqualTo(ListNode.of(5));
        assertThat(reverseBetween(ListNode.of(1, 2, 3, 4, 5), 2, 4)).isEqualTo(ListNode.of(1, 4, 3, 2, 5));
        assertThat(reverseBetween(ListNode.of(1, 2, 3, 4, 5), 3, 4)).isEqualTo(ListNode.of(1, 2, 4, 3, 5));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode beforeReverse = dummy;
        for (int i = 0; i < left - 1; i++) {
            beforeReverse = beforeReverse.next;
        }

        ListNode cur = beforeReverse.next;
        ListNode tail = cur;
        ListNode previous = null;

        for (int i = left; i <= right; i++) {
            ListNode tmp = cur.next;
            cur.next = previous;
            previous = cur;
            cur = tmp;
        }

        beforeReverse.next = previous;
        if (tail != null) {
            tail.next = cur;
        }

        return dummy.next;
    }

}
