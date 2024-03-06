package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 0 ms Beats 100.00% of users with Java
 */
public class Q141LinkedListCycle3 {

    @Test
    void test1() {
        ListNode head = ListNode.of(3, 2, 0, -4);
        head.next.next.next = head.next;
        assertThat(hasCycle(head)).isTrue();
    }

    @Test
    void test2() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        assertThat(hasCycle(head)).isTrue();
    }

    @Test
    public void test3() {
        ListNode head = ListNode.of(1);
        assertThat(hasCycle(head)).isFalse();
    }

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            fast = fast.next;
            if (fast == null)
                return false;
            fast = fast.next;
            if (fast == null)
                return false;
        } while (slow != fast);
        return true;
    }

}
