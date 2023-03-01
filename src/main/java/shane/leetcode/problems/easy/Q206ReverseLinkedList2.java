package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q206ReverseLinkedList2 {

    @Test
    public void test() {
        ListNode root = ListNode.of(1, 2, 3, 4, 5);
        assertThat(reverseList(root)).isEqualTo(ListNode.of(5, 4, 3, 2, 1));
    }

    @Test
    public void test3() {
        ListNode root = ListNode.of(1, 2);
        assertThat(reverseList(root)).isEqualTo(ListNode.of(2, 1));
    }

    @Test
    public void test2() {
        assertThat(reverseList(null)).isNull();
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
