package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 7 ms Beats 9.68% of users with Java
 */
public class Q1171RemoveZeroSumConsecutiveNodesFromLinkedList {

    @Test
    public void test() {
        assertThat(removeZeroSumSublists(ListNode.of(1, 0, 1, 0, 2))).isEqualTo(ListNode.of(1, 1, 2));
        assertThat(removeZeroSumSublists(ListNode.of(0, 0))).isEqualTo(null);
        assertThat(removeZeroSumSublists(ListNode.of(1, 2, -3, 3, 1))).isEqualTo(ListNode.of(3, 1));
        assertThat(removeZeroSumSublists(ListNode.of(1, 2, 3, -3, 4))).isEqualTo(ListNode.of(1, 2, 4));
        assertThat(removeZeroSumSublists(ListNode.of(1, 2, 3, -3, -2))).isEqualTo(ListNode.of(1));
    }

    public ListNode removeZeroSumSublists(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        for (int start = 0; start < list.size(); start++) {
            int sum = 0;
            for (int end = start; end < list.size(); end++) {
                sum += list.get(end);
                if (sum == 0) {
                    for (int i = 0; i < end - start + 1; i++) {
                        list.remove(start);
                    }
                    start--;
                    break;
                }
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (Integer i : list) {
            cur.next = new ListNode();
            cur.next.val = i;
            cur = cur.next;
        }
        return dummy.next;
    }

}
