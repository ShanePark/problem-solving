package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime 12 ms Beats 6.45%
 * Memory 57.1 MB Beats 89.61%
 */
public class Q1721SwappingNodesInALinkedList2 {

    @Test
    public void test() {
        ListNode node = ListNode.of(new int[]{1, 2, 3, 4, 5});
        assertThat(swapNodes(node, 2)).isEqualTo(ListNode.of(1, 4, 3, 2, 5));
    }

    @Test
    public void test2() {
        ListNode node = ListNode.of(7, 9, 6, 6, 7, 8, 3, 0, 9, 5);
        assertThat(swapNodes(node, 5)).isEqualTo(ListNode.of(7, 9, 6, 6, 8, 7, 3, 0, 9, 5));
    }

    @Test
    public void test3() {
        assertThat(swapNodes(ListNode.of(1, 2), 1)).isEqualTo(ListNode.of(2, 1));
        assertThat(swapNodes(ListNode.of(1), 1)).isEqualTo(ListNode.of(1));
    }

    public ListNode swapNodes(ListNode head, int k) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        Collections.swap(list, k - 1, list.size() - k);
        ListNode answer = new ListNode(list.get(0));
        ListNode cur = answer;
        for (int i = 1; i < list.size(); i++) {
            Integer n = list.get(i);
            ListNode listNode = new ListNode(n);
            cur.next = listNode;
            cur = listNode;
        }
        return answer;
    }

}
