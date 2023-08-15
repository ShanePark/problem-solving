package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime Details -ms Beats 100.00%of users with Java
 * Memory Details 40.70mb Beats 90.70%of users with Java
 */
public class Q86PartitionList2 {

    @Test
    public void test() {
        ListNode partition = partition(ListNode.of(1, 4, 3, 2, 5, 2), 3);
        assertThat(partition).isEqualTo(ListNode.of(1, 2, 2, 4, 3, 5));
    }

    @Test
    public void test2() {
        ListNode partition = partition(ListNode.of(2, 1), 2);
        assertThat(partition).isEqualTo(ListNode.of(1, 2));
    }

    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead = new ListNode(0);
        ListNode smaller = smallerHead;
        ListNode biggerHead = new ListNode(0);
        ListNode bigger = biggerHead;
        while (head != null) {
            int val = head.val;
            head = head.next;
            if (val < x) {
                smaller.next = new ListNode(val);
                smaller = smaller.next;
                continue;
            }
            bigger.next = new ListNode(val);
            bigger = bigger.next;
        }
        if (smallerHead.next == null) {
            return biggerHead.next;
        }
        smaller.next = biggerHead.next;
        return smallerHead.next;
    }

}
