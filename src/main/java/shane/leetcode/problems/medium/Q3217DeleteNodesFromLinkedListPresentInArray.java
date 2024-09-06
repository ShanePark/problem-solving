package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime21msBeats45.83%
 */
public class Q3217DeleteNodesFromLinkedListPresentInArray {

    @Test
    public void test() {
        assertThat(modifiedList(new int[]{1, 2, 3}, ListNode.of(1, 2, 3, 4, 5))).isEqualTo(ListNode.of(4, 5));
        assertThat(modifiedList(new int[]{1}, ListNode.of(1, 2, 1, 2, 1, 2))).isEqualTo(ListNode.of(2, 2, 2));
        assertThat(modifiedList(new int[]{5}, ListNode.of(1, 2, 3, 4))).isEqualTo(ListNode.of(1, 2, 3, 4));
        assertThat(modifiedList(new int[]{1, 2}, ListNode.of(1, 2))).isNull();
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> delTargets = new HashSet<>();
        for (int num : nums) {
            delTargets.add(num);
        }
        ListNode cur = head;
        while (cur.next != null) {
            if (delTargets.contains(cur.next.val)) {
                cur.next = cur.next.next;
                continue;
            }
            cur = cur.next;
        }
        if (delTargets.contains(head.val)) {
            return head.next;
        }
        return head;
    }

}
