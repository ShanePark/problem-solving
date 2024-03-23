package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 5 ms Beats 10.79% of users with Java
 */
public class Q143ReorderList {

    @Test
    public void test1() {
        ListNode node = ListNode.of(1, 2, 3, 4);
        reorderList(node);
        assertThat(node).isEqualTo(ListNode.of(1, 4, 2, 3));
    }

    @Test
    public void test2() {
        ListNode node = ListNode.of(1, 2, 3, 4, 5);
        reorderList(node);
        assertThat(node).isEqualTo(ListNode.of(1, 5, 2, 4, 3));
    }

    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode cur = head;
        while (cur != null) {
            deque.offerLast(cur);
            cur = cur.next;
        }
        deque.pollFirst();
        cur = head;
        while (!deque.isEmpty()) {
            cur.next = deque.pollLast();
            cur = cur.next;
            if (!deque.isEmpty()) {
                cur.next = deque.pollFirst();
                cur = cur.next;
            }
        }
        cur.next = null;
    }

}
