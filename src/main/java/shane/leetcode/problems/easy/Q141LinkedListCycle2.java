package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details 3ms Beats 15.66%of users with Java
 * Memory Details 43.53MB Beats 52.88%of users with Java
 */
public class Q141LinkedListCycle2 {

    @Test
    void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        assertThat(hasCycle(head)).isTrue();
    }

    @Test
    public void test2() {
        ListNode head = ListNode.of(3, 2, 0, -4);
        head.next.next.next = head.next;
        assertThat(hasCycle(head)).isTrue();
    }

    @Test
    public void test3() {
        ListNode head = ListNode.of(1);
        assertThat(hasCycle(head)).isFalse();
    }

    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (!set.add(head))
                return true;
            head = head.next;
        }
        return false;
    }

}
