package shane.leetcode.problems.easy;

import com.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Q876MiddleOfTheLinkedList {

    @Test
    public void test() {
        assertThat(middleNode(ListNode.of(1, 2, 3, 4, 5))).isEqualTo(ListNode.of(3, 4, 5));
        assertThat(middleNode(ListNode.of(1, 2, 3, 4, 5, 6))).isEqualTo(ListNode.of(4, 5, 6));
    }

    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode normal = head;

        while (fast.next != null) {
            fast = fast.next;
            normal = normal.next;
            if (fast.next != null)
                fast = fast.next;
        }
        return normal;
    }
}
