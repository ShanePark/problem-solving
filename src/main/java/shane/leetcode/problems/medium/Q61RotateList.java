package shane.leetcode.problems.medium;

import com.github.shanepark.leetcode.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class Q61RotateList {

    @Test
    void test() {
        ListNode head = ListNode.of(new int[]{1, 2, 3, 4, 5});
        ListNode result = rotateRight(head, 2);
        Assertions.assertThat(result.val).isEqualTo(4);
        result = result.next;
        Assertions.assertThat(result.val).isEqualTo(5);
        result = result.next;
        Assertions.assertThat(result.val).isEqualTo(1);
        result = result.next;
        Assertions.assertThat(result.val).isEqualTo(2);
        result = result.next;
        Assertions.assertThat(result.val).isEqualTo(3);
    }

    @Test
    void test2() {
        ListNode head = ListNode.of(new int[]{1, 2});
        ListNode result = rotateRight(head, 0);
        Assertions.assertThat(result.val).isEqualTo(1);
        result = result.next;
        Assertions.assertThat(result.val).isEqualTo(2);
    }

    @Test
    void test3() {
        ListNode head = ListNode.of(new int[]{1, 2});
        ListNode result = rotateRight(head, 1);
        Assertions.assertThat(result.val).isEqualTo(2);
        result = result.next;
        Assertions.assertThat(result.val).isEqualTo(1);
        Assertions.assertThat(result.next).isNull();
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        if (k == 0)
            return head;

        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        k %= list.size();

        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        for (int i = list.size() - k; i < 2 * list.size() - k; i++) {
            cur.next = new ListNode(list.get(i % list.size()));
            cur = cur.next;
        }

        return dummy.next;

    }

}
