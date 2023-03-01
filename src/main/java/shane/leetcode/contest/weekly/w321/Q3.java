package shane.leetcode.contest.weekly.w321;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Q3 {

    @Test
    public void test() {
        ListNode node = ListNode.of(5, 2, 13, 3, 8);
        assertThat(removeNodes(node)).isEqualTo(ListNode.of(13, 8));
    }

    @Test
    public void test2() {
        ListNode node = ListNode.of(1, 1, 1, 1);
        assertThat(removeNodes(node)).isEqualTo(ListNode.of(1, 1, 1, 1));
    }

    public ListNode removeNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        int length = list.size();
        int[] maxArr = new int[length];
        int max = 0;
        for (int i = length - 1; i >= 0; i--) {
            max = Math.max(max, list.get(i));
            maxArr[i] = max;
        }
        ListNode dummy = new ListNode();
        cur = head;
        ListNode answer = dummy;
        for (int i = 0; i < length; i++) {
            if (cur.val >= maxArr[i]) {
                answer.next = new ListNode(cur.val);
                answer = answer.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }

}
