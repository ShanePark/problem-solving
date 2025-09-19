package shane.leetcode.problems.easy;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime
 * 31
 * ms
 * Beats
 * 93.90%
 */
public class Q3063LinkedListFrequency {

    @Test
    public void test() {
        ListNode listNode = frequenciesOfElements(ListNode.of(1, 1, 2, 1, 2, 3));
        assertThat(listNode).isEqualTo(ListNode.of(3, 2, 1));
    }

    public ListNode frequenciesOfElements(ListNode head) {
        Map<Integer, Integer> cnt = new HashMap<>();
        while (head != null) {
            cnt.merge(head.val, 1, Integer::sum);
            head = head.next;
        }
        return toListNode(cnt.values());
    }

    ListNode toListNode(Collection<Integer> collection) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for (Integer i : collection) {
            cur.next = new ListNode(i);
            cur = cur.next;
        }
        return head.next;
    }
}
