package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q206ReverseLinkedList3 {

    @Test
    public void test() {
        ListNode root = ListNode.of(1, 2, 3, 4, 5);
        assertThat(reverseList(root)).isEqualTo(ListNode.of(5, 4, 3, 2, 1));
    }

    @Test
    public void test2() {
        ListNode root = ListNode.of(1, 2);
        assertThat(reverseList(root)).isEqualTo(ListNode.of(2, 1));
    }

    @Test
    public void test3() {
        assertThat(reverseList(null)).isNull();
    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode prev = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = prev;
            prev = head;
            head = tmp;
        }
        return prev;
    }

}
