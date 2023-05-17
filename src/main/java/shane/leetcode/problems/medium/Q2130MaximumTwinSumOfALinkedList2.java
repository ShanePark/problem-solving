package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 45 ms Beats 13.97%
 * Memory 61.6 MB Beats 76.17%
 */
public class Q2130MaximumTwinSumOfALinkedList2 {

    @Test
    void test() {
        assertThat(pairSum(ListNode.of(5, 4, 2, 1))).isEqualTo(6);
        assertThat(pairSum(ListNode.of(4, 2, 2, 3))).isEqualTo(7);
        assertThat(pairSum(ListNode.of(1, 100000))).isEqualTo(100001);
    }

    public int pairSum(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = head;
        ListNode fast = head;
        while (fast != null) {
            stack.push(cur.val);
            cur = cur.next;
            fast = fast.next.next;
        }
        int max = 0;
        while (cur != null) {
            Integer pop = stack.pop();
            max = Math.max(max, pop + cur.val);
            cur = cur.next;
        }
        return max;
    }

}
