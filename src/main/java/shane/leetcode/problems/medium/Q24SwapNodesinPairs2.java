package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Runtime 0 ms Beats 100%
 * Memory 40 MB Beats 93.11%
 */
public class Q24SwapNodesinPairs2 {

    @Test
    void test() {
        Assertions.assertThat(swapPairs(ListNode.of(1, 2, 3, 4))).isEqualTo(ListNode.of(2, 1, 4, 3));
        Assertions.assertThat(swapPairs(null)).isEqualTo(null);
        Assertions.assertThat(swapPairs(ListNode.of(1))).isEqualTo(ListNode.of(1));
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return null;
        ListNode next = head.next;
        if (next != null) {
            ListNode tail = next.next;
            head.next = swapPairs(tail);
            next.next = head;
            return next;
        }
        return head;
    }


}
