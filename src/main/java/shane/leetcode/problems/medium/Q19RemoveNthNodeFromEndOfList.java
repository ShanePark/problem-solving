package shane.leetcode.problems.medium;

import com.tistory.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime: 1 ms, faster than 75.59% of Java online submissions for Remove Nth Node From End of List.
 * Memory Usage: 42.7 MB, less than 15.03% of Java online submissions for Remove Nth Node From End of List.
 */
public class Q19RemoveNthNodeFromEndOfList {

    @Test
    public void test() {
        assertThat(removeNthFromEnd(ListNode.of(1, 2, 3, 4, 5), 5)).isEqualTo(ListNode.of(2, 3, 4, 5));
        assertThat(removeNthFromEnd(ListNode.of(1, 2, 3, 4, 5), 2)).isEqualTo(ListNode.of(1, 2, 3, 5));
        assertThat(removeNthFromEnd(ListNode.of(1), 1)).isEqualTo(ListNode.of());
        assertThat(removeNthFromEnd(ListNode.of(1, 2), 1)).isEqualTo(ListNode.of(1));
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        final int SIZE = list.size();
        if (SIZE == 1) {
            return null;
        } else if (SIZE == n) {
            return list.get(1);
        }

        ListNode beforeRemove = list.get(SIZE - n - 1);
        ListNode toRemove = list.get(SIZE - n);
        beforeRemove.next = toRemove.next;
        return list.get(0);
    }
}
