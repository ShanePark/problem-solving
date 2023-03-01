package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class Q1721SwappingNodesInALinkedList {

    @Test
    public void test() {
        ListNode node = ListNode.of(new int[]{1, 2, 3, 4, 5});
        ListNode swap = swapNodes(node, 2);
        swap.print();
        assertThat(swap.val).isEqualTo(1);
        swap = swap.next;
        assertThat(swap.val).isEqualTo(4);
        swap = swap.next;
        assertThat(swap.val).isEqualTo(3);
        swap = swap.next;
        assertThat(swap.val).isEqualTo(2);
        swap = swap.next;
        assertThat(swap.val).isEqualTo(5);
        assertThat(swap.next).isNull();
    }

    public ListNode swapNodes(ListNode head, int k) {
        ListNode cur = head;
        int index = 0;
        Map<Integer, ListNode> map = new HashMap<>();
        while (cur != null) {
            map.put(++index, cur);
            cur = cur.next;
        }
        int temp = map.get(k).val;
        map.get(k).val = map.get(index - k + 1).val;
        map.get(index - k + 1).val = temp;

        return head;
    }
}
