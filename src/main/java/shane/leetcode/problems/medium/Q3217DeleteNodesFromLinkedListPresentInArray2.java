package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 31
 * ms
 * Beats
 * 5.29%
 */
public class Q3217DeleteNodesFromLinkedListPresentInArray2 {

    @Test
    public void test() {
        assertThat(modifiedList(new int[]{1, 2, 3}, ListNode.of(1, 2, 3, 4, 5))).isEqualTo(ListNode.of(4, 5));
        assertThat(modifiedList(new int[]{1}, ListNode.of(1, 2, 1, 2, 1, 2))).isEqualTo(ListNode.of(2, 2, 2));
        assertThat(modifiedList(new int[]{5}, ListNode.of(1, 2, 3, 4))).isEqualTo(ListNode.of(1, 2, 3, 4));
    }

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        for (; head != null; head = head.next) {
            if (set.contains(head.val)) {
                continue;
            }
            cur.next = head;
            cur = head;
        }
        cur.next = null;
        return dummy.next;
    }

}
