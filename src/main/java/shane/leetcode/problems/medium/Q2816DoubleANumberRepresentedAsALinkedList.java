package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class Q2816DoubleANumberRepresentedAsALinkedList {

    @Test
    public void test() {
        assertThat(doubleIt(ListNode.of(9, 9, 9))).isEqualTo(ListNode.of(1, 9, 9, 8));
        assertThat(doubleIt(ListNode.of(1, 8, 9))).isEqualTo(ListNode.of(3, 7, 8));
        assertThat(doubleIt(ListNode.of(9, 1, 9, 5, 0, 5, 1, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9))).isEqualTo(ListNode.of(1, 8, 3, 9, 0, 1, 0, 3, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 9, 8));
        assertThat(doubleIt(ListNode.of(3, 4, 5, 4, 2, 5, 5, 9, 9, 9))).isEqualTo(ListNode.of(6, 9, 0, 8, 5, 1, 1, 9, 9, 8));
    }

    public ListNode doubleIt(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }

        StringBuilder val = new StringBuilder();
        int mod = 0;
        while (!stack.isEmpty()) {
            mod += 2 * stack.pop();
            val.insert(0, mod % 10);
            mod /= 10;
        }
        if (mod > 0) {
            val.insert(0, mod);
        }

        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (int i = 0; i < val.length(); i++) {
            char c = val.charAt(i);
            cur.next = new ListNode(c - '0');
            cur = cur.next;
        }
        return dummy.next;
    }

}
