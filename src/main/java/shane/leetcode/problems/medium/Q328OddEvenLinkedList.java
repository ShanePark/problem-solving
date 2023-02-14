package shane.leetcode.problems.medium;

import com.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100%
 * Memory 45.3 MB Beats 11.4%
 */
public class Q328OddEvenLinkedList {

    @Test
    public void test() {
        assertThat(oddEvenList(ListNode.of(2, 1, 3, 5, 6, 4, 7))).isEqualTo(ListNode.of(2, 3, 6, 7, 1, 5, 4));
        assertThat(oddEvenList(ListNode.of(1, 2, 3, 4, 5))).isEqualTo(ListNode.of(1, 3, 5, 2, 4));
        assertThat(oddEvenList(null)).isEqualTo(null);
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode firstDummy = new ListNode(0);
        ListNode secondDummy = new ListNode(0);
        ListNode first = firstDummy;
        ListNode second = secondDummy;
        while (head != null) {
            first.next = head;
            first = first.next;
            head = head.next;

            if (head == null) break;
            second.next = head;
            second = second.next;
            head = head.next;

        }
        first.next = secondDummy.next;
        second.next = null;

        return firstDummy.next;
    }
}
