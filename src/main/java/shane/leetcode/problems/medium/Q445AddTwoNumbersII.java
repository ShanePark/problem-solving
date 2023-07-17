package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 7 ms Beats 10.97%
 * Memory 44.1 MB Beats 14.54%
 */
public class Q445AddTwoNumbersII {

    @Test
    public void test() {
        assertThat(addTwoNumbers(ListNode.of(7, 2, 4, 3), ListNode.of(5, 6, 4))).isEqualTo(ListNode.of(7, 8, 0, 7));
        assertThat(addTwoNumbers(ListNode.of(2, 4, 3), ListNode.of(5, 6, 4))).isEqualTo(ListNode.of(8, 0, 7));
        assertThat(addTwoNumbers(ListNode.of(0), ListNode.of(0))).isEqualTo(ListNode.of(0));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> q1 = toStack(l1);
        Stack<Integer> q2 = toStack(l2);
        // q1 is longer than q2
        if (q1.size() < q2.size()) {
            Stack<Integer> tmp = q1;
            q1 = q2;
            q2 = tmp;
        }

        int left = 0;
        Stack<Integer> stack = new Stack<>();
        while (!q2.isEmpty()) {
            int sum = q1.pop() + q2.pop() + left;
            left = 0;
            if (sum >= 10) {
                left = sum / 10;
                sum %= 10;
            }
            stack.push(sum);
        }
        while (!q1.isEmpty()) {
            int sum = q1.pop() + left;
            left = 0;
            if (sum >= 10) {
                left = sum / 10;
                sum %= 10;
            }
            stack.push(sum);
        }
        if (left > 0)
            stack.push(left);

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!stack.isEmpty()) {
            cur.next = new ListNode(stack.pop());
            cur = cur.next;
        }

        return dummy.next;
    }

    private Stack<Integer> toStack(ListNode node) {
        Stack<Integer> answer = new Stack<>();
        while (node != null) {
            answer.add(node.val);
            node = node.next;
        }
        return answer;
    }

}
