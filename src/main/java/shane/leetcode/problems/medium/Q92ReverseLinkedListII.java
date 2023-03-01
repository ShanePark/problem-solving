package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Q92ReverseLinkedListII {

    @Test
    public void test() {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        assertThat(reverseBetween(head, 2, 4)).isEqualTo(ListNode.of(1, 4, 3, 2, 5));
    }

    @Test
    public void test2() {
        ListNode head = ListNode.of(5);
        assertThat(reverseBetween(head, 1, 1)).isEqualTo(ListNode.of(5));
    }

    @Test
    public void test3() {
        ListNode head = ListNode.of(1, 2);
        assertThat(reverseBetween(head, 1, 2)).isEqualTo(ListNode.of(2, 1));
    }

    @Test
    public void test4() {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        assertThat(reverseBetween(head, 3, 4)).isEqualTo(ListNode.of(1, 2, 4, 3, 5));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) return head;
        ListNode tail = null;
        ListNode cur;
        if (left > 1) {
            tail = head;
            for (int i = 0; i < left - 2; i++) {
                tail = tail.next;
            }
            cur = tail;
        } else {
            cur = new ListNode();
            cur.next = head;
        }

        Stack<ListNode> stack = new Stack<>();
        for (int i = 0; i < right - left + 1; i++) {
            cur = cur.next;
            stack.add(cur);
        }

        ListNode last = cur == null ? null : cur.next;
        while (!stack.isEmpty()) {
            ListNode pop = stack.pop();
            if (tail == null) {
                head = pop;
                tail = pop;
            } else {
                tail.next = pop;
                tail = tail.next;
            }
        }
        tail.next = last;

        return head;
    }

}
