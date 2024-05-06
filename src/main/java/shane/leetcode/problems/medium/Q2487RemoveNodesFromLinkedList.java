package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 101 ms Beats 5.46% of users with Java
 */
public class Q2487RemoveNodesFromLinkedList {

    @Test
    public void test() {
        assertThat(removeNodes(ListNode.of(5, 2, 13, 3, 8))).isEqualTo(ListNode.of(13, 8));
        assertThat(removeNodes(ListNode.of(1, 1, 1, 1))).isEqualTo(ListNode.of(1, 1, 1, 1));
    }

    public ListNode removeNodes(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        Stack<Integer> stack2 = new Stack<>();
        int max = Integer.MIN_VALUE;
        while (!stack.isEmpty()) {
            int pop = stack.pop();
            if (max <= pop) {
                stack2.push(pop);
                max = pop;
            }
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (!stack2.isEmpty()) {
            cur.next = new ListNode(stack2.pop());
            cur = cur.next;
        }
        return dummy.next;
    }

}
