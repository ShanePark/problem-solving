package shane.leetcode.problems.medium;

import io.github.shanepark.leetcode.ListNode;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Runtime1msBeats100.00%
 */
public class Q2807InsertGreatestCommonDivisorsInLinkedList {

    @Test
    public void test() {
        assertThat(insertGreatestCommonDivisors(ListNode.of(18, 6, 10, 3))).isEqualTo(ListNode.of(18, 6, 6, 2, 10, 1, 3));
        assertThat(insertGreatestCommonDivisors(ListNode.of(7))).isEqualTo(ListNode.of(7));
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode cur = head;
        while (cur.next != null) {
            int gcd = getGcd(cur.val, cur.next.val);
            ListNode next = cur.next;
            cur.next = new ListNode(gcd, next);
            cur = next;
        }
        return head;
    }

    private int getGcd(int i, int j) {
        if (i % j == 0)
            return j;
        return getGcd(j, i % j);
    }

}
