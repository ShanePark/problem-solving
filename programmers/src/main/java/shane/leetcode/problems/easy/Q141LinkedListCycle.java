package shane.leetcode.problems.easy;

import com.tistory.shanepark.leetcode.ListNode;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class Q141LinkedListCycle {

    @Test
    void test() {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        Assertions.assertThat(hasCycle(head)).isTrue();
    }

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode jump = head;

        while (jump.next != null && jump.next.next != null) {
            head = head.next;
            jump = jump.next.next;
            if (head == jump) return true;
        }
        return false;
    }

}
