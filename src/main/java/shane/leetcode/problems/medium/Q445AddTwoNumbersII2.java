package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 6 ms Beats 32.33%
 * Memory 43.9 MB Beats 33.7%
 */
public class Q445AddTwoNumbersII2 {

    @Test
    public void test() {
        assertThat(addTwoNumbers(ListNode.of(7, 2, 4, 3), ListNode.of(5, 6, 4))).isEqualTo(ListNode.of(7, 8, 0, 7));
        assertThat(addTwoNumbers(ListNode.of(2, 4, 3), ListNode.of(5, 6, 4))).isEqualTo(ListNode.of(8, 0, 7));
        assertThat(addTwoNumbers(ListNode.of(0), ListNode.of(0))).isEqualTo(ListNode.of(0));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = toStack(l1);
        Stack<Integer> s2 = toStack(l2);

        ListNode cur = null;
        int sum = 0;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            sum += s1.isEmpty() ? 0 : s1.pop();
            sum += s2.isEmpty() ? 0 : s2.pop();
            ListNode parent = new ListNode(sum % 10);
            parent.next = cur;
            cur = parent;
            sum /= 10;
        }
        if (sum > 0) {
            ListNode parent = new ListNode(sum);
            parent.next = cur;
            cur = parent;
        }
        return cur;
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
